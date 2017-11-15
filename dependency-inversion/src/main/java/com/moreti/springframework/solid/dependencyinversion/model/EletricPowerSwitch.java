package com.moreti.springframework.solid.dependencyinversion.model;

public class EletricPowerSwitch implements Switch {

    private Switchable client;
    private boolean isOn;

    public EletricPowerSwitch(Switchable client) {
        this.client = client;
        isOn = false;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void press() {
        boolean checkOn = isOn();
        if (checkOn) {
            client.turnOff();
            this.isOn = false;
        } else {
            client.turnOn();
            this.isOn = true;
        }
    }
}
