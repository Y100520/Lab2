/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import AbstractFactory.MistyMountainsGearFactory;
import java.util.Random;

public class MistyMountainsOrkBuilder extends OrkBuilder {

    public MistyMountainsOrkBuilder() {
        super();
        super.setGearFactory(new MistyMountainsGearFactory());
    }

    @Override
    public void buildAttributes() {
        Random random = new Random();
        ork.setTribe("Мглистые горы");
        ork.setName(faker.lordOfTheRings().character());

        ork.setStrength(50 + random.nextInt(50));
        int baseAgility = 10 + random.nextInt(90);
        ork.setAgility((int) (baseAgility * 1.3));
        ork.setIntelligence(1 + random.nextInt(20));
        ork.setHealth(50 + random.nextInt(150));
    }

    @Override
    public void buildGear() {
        ork.setWeapon(gearFactory.createWeapon().getDiscription());
        ork.setArmor(gearFactory.createArmor().getDiscription());
        ork.setBanner(gearFactory.createBanner().getDiscription());
    }
}
