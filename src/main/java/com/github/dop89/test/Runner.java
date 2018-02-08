package com.github.dop89.test;

import com.github.dop89.di.core.ApplicationContext;

public class Runner {

    public static void main(String[] args) {

        ApplicationContext context = new ApplicationContext();

        // scan classes for bean definitions
        context.scanClasses(BeanDefinitions.class);

        // print all registered beans
        context.printDeclaredBeans();

        // inject dependencies
        context.inject();

        // print all registered beans after dependency injection
        context.printDeclaredBeans();

        // get Vehicle Bean from application context
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println(vehicle);
    }
}
