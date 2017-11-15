package com.moreti.springframework.solid.dependencyinversion.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("lightBulb")
public class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("LightBulb: Bulb turned ON...");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb: Bulb turned OFF...");
    }
}
