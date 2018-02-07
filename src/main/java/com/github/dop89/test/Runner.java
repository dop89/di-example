package com.github.dop89.test;

import com.github.dop89.di.core.ApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class Runner {

    public static void main (String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        // scan classes for bean definitions
        ApplicationContext.scanClasses(BeanDefinitions.class);

        // print all registered beans
        ApplicationContext.printDeclaredBeans();

        // inject dependencies
        ApplicationContext.inject();

        // print all registered beans after dependency injection
        ApplicationContext.printDeclaredBeans();

        // get Vehicle Bean from application context
        Vehicle vehicle = ApplicationContext.getBean(Vehicle.class);
        System.out.println(vehicle);
    }
}
