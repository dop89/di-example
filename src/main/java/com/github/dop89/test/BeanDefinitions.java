package com.github.dop89.test;

import com.github.dop89.di.annotations.Bean;

public class BeanDefinitions {

    @Bean
    public Gearbox gearbox() {
        Gearbox g = new Gearbox();
        g.setName("Sport");

        return g;
    }

    @Bean
    public Vehicle vehicle() {
        Vehicle vehicle =  new Vehicle();
        vehicle.setId("1337");
        vehicle.setName("Tesla");

        return vehicle;
    }
}
