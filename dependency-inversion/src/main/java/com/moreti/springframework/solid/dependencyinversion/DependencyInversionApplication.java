package com.moreti.springframework.solid.dependencyinversion;

import com.moreti.springframework.solid.dependencyinversion.model.EletricPowerSwitch;
import com.moreti.springframework.solid.dependencyinversion.model.Switch;
import com.moreti.springframework.solid.dependencyinversion.model.Switchable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInversionApplication implements CommandLineRunner{

	Switchable switchableBulb;

	Switchable switchableFan;

	public DependencyInversionApplication(@Qualifier("lightBulb") Switchable bulb, @Qualifier("fan") Switchable fan) {
		this.switchableBulb = bulb;
		this.switchableFan = fan;
	}

	public static void main(String[] args) {
		SpringApplication.run(DependencyInversionApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Switch bulbPowerSwitch = new EletricPowerSwitch(switchableBulb);
		bulbPowerSwitch.press();
		bulbPowerSwitch.press();
		Switch fanPowerSwitch = new EletricPowerSwitch(switchableFan);
		fanPowerSwitch.press();
		fanPowerSwitch.press();
	}
}
