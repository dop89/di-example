package com.github.dop89.di.core;

import com.github.dop89.di.annotations.Autowired;
import com.github.dop89.di.annotations.Bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Injector {

    private ApplicationContext context;

    Injector(ApplicationContext context) {
        this.context = context;
    }

    void scan(Class... clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        for (Class cls : clazz) {

            Method[] methods = cls.getMethods();

            for (Method m : methods) {

                if (m.getAnnotation(Bean.class) != null) {

                    // method is a bean definition, getBean constructor and create new instance
                    Constructor<?> cons = cls.getConstructors()[0];
                    Object object = cons.newInstance();

                    // invoke method to getBean bean
                    Object bean = m.invoke(object);

                    //save bean in registry
                    context.registerBean(bean.getClass(), bean);
                }
            }
        }
    }

    void inject() throws IllegalAccessException {

        Set<Class> classes = context.getClasses();

        for (Class cls : classes) {

            Field[] fields = cls.getDeclaredFields();

            for (Field field : fields) {

                // check if field has Autowired annotation
                if (field.getAnnotation(Autowired.class) != null) {

                    Class<?> typeOfField = field.getType();

                    boolean hasBeanForField = context.hasBeanForClass(typeOfField);
                    boolean hasBeanForObjectToInject = context.hasBeanForClass(cls);

                    // check if beans are available for classes
                    if (hasBeanForField && hasBeanForObjectToInject) {

                        Object theFieldObject = context.getBean(typeOfField);
                        Object theObjectToInject = context.getBean(cls);

                        field.setAccessible(true);
                        field.set(theObjectToInject, theFieldObject);
                    }
                }
            }
        }
    }

}
