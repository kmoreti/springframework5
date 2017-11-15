package com.moreti.springframework.solid.dependencyinversion.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fan")
public class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Fan: Fan turned ON...");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan: Fan turned OFF...");
    }
}
