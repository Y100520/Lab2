/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import AbstractFactory.MistyMountainsGearFactory;
import java.util.Random;

public class MistyMountainsOrkBuilder extends OrkBuilder{
    public MistyMountainsOrkBuilder() {
        this.gearFactory = new MistyMountainsGearFactory();
    }
    
    private Random random = new Random();
    
    @Override
    public void buildName() {ork.setName(faker.lordOfTheRings().character());}
    
    @Override
    public void buildTribe() {ork.setTribe("Misty Mountains");}
    
    @Override
    public void buildStrength() {ork.setStrength(50 + random.nextInt(50));}
    
    @Override
    public void buildAgility() {
        int baseAgility = 10 + random.nextInt(90);
        ork.setAgility((int)(baseAgility * 1.3));}
    
    @Override
    public void buildIntelligence() {ork.setIntelligence(1 + random.nextInt(20));}
    
    @Override
    public void buildHealth() {ork.setHealth(50 + random.nextInt(150));}

    @Override
    public void buildWeapon() {
        ork.setWeapon(gearFactory.createWeapon().getDiscription());
    }

    @Override
    public void buildArmor() {
        ork.setArmor(gearFactory.createArmor().getDiscription());
    }

    @Override
    public void buildBanner() {
        ork.setBanner(gearFactory.createBanner().getDiscription());
    }
    
     @Override
    public void buildWeapon(String customWeapon) {
        ork.setWeapon(customWeapon);
    }
    
    @Override
    public void buildBanner(String customBanner) {
        ork.setBanner(gearFactory.createBanner() + " " + customBanner);
    }
}
