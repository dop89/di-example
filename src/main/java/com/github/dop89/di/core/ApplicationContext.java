package com.github.dop89.di.core;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private ConcurrentHashMap<Class, Object> mappings;

    private Injector injector;

    public ApplicationContext() {
        this.injector = new Injector(this);
        this.mappings = new ConcurrentHashMap<>();
    }

    public void scanClasses(Class... classes) {
        try {
            injector.scan(classes);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            System.err.println("Could not scan classes for bean definitions");
        }
    }

    public void inject() {
        try {
            injector.inject();
        } catch (IllegalAccessException ex) {
            System.err.println("Could not inject beans");
        }
    }

    public void registerBean(Class clazz, Object obj) {
        mappings.put(clazz, obj);
    }

    public <T> T getBean(Class<T> clazz) {
        return clazz.cast(mappings.get(clazz));
    }

    public void printDeclaredBeans() {
        mappings.entrySet().stream().forEach(e -> System.out.println("Bean for class [" + e.getKey() + "]: " + e.getValue().toString()));
    }

    public boolean hasBeanForClass(Class cls) {
        return getClasses().contains(cls);
    }

    public Set<Class> getClasses() {
        return new HashSet<>(Collections.list(mappings.keys()));
    }
}
