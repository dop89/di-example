package com.github.dop89.test;

import com.github.dop89.di.annotations.Autowired;

/**
 * Sample bean in which another bean will be injected
 */
public class Vehicle {

    private String id;

    private String name;

    @Autowired
    private Gearbox gearbox;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gearbox=" + gearbox +
                '}';
    }
}
