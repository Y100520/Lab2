/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import AbstractFactory.MordorGearFactory;

import java.util.Random;

public class MordorOrkBuilder extends OrkBuilder {

    public MordorOrkBuilder() {
        super();
        super.setGearFactory(new MordorGearFactory());
    }

    @Override
    public void buildAttributes() {
        Random random = new Random();
        ork.setTribe("Mordor");
        ork.setName(faker.lordOfTheRings().character());

        int baseStrength = 50 + random.nextInt(30);
        ork.setStrength((int) (baseStrength * 1.3));
        ork.setAgility(10 + random.nextInt(30));
        ork.setIntelligence(1 + random.nextInt(50));
        ork.setHealth(50 + random.nextInt(150));
    }

    @Override
    public void buildGear() {
        ork.setWeapon(gearFactory.createWeapon().getDiscription());
        ork.setArmor(gearFactory.createArmor().getDiscription());
        ork.setBanner(gearFactory.createBanner().getDiscription());
    }
}
