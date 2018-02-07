package com.github.dop89.di.core;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private ApplicationContext() {
        // prevent initialization
    }

    private static ConcurrentHashMap<Class, Object> mappings = new ConcurrentHashMap<>();

    public static void scanClasses(Class... classes) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Injector.scan(classes);
    }

    public static void inject() throws IllegalAccessException {
        Injector.inject();
    }

    public static void registerBean(Class clazz, Object obj) {
        mappings.put(clazz, obj);
    }

    public static <T> T getBean(Class<T> clazz) {
        return clazz.cast(mappings.get(clazz));
    }

    public static void printDeclaredBeans() {
        mappings.entrySet().stream().forEach(e -> {
            System.out.println("Bean for class [" + e.getKey() + "]: " + e.getValue().toString());
        });

    }

    public static boolean hasBeanForClass(Class cls) {
        return getClasses().contains(cls);
    }

    public static Set<Class> getClasses() {
        return new HashSet<>(Collections.list(mappings.keys()));

    }

}
