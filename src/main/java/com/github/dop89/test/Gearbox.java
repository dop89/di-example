package com.github.dop89.test;

/**
 * Sample bean which will be injected
 */
public class Gearbox {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gearbox{" +
                "name='" + name + '\'' +
                '}';
    }
}
