/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import AbstractFactory.DolGuldurGearFactory;
import java.util.Random;

public class DolGuldurOrkBuilder extends OrkBuilder {

    public DolGuldurOrkBuilder() {
        super();
        super.setGearFactory(new DolGuldurGearFactory());
    }

    @Override
    public void buildAttributes() {
        Random random = new Random();
        ork.setTribe("Дол Гулдур");
        ork.setName(faker.lordOfTheRings().character());

        ork.setStrength(50 + random.nextInt(50));
        ork.setAgility(10 + random.nextInt(90));
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
