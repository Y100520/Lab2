/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import Builder.*;
import Builder.OrkBuilder;

public class OrkDirector {
    private OrkBuilder orkBuilder;
    
    public void setOrkBuilder(OrkBuilder builder) {
        this.orkBuilder = builder;
    }
    
    public Ork getOrk() {
        return orkBuilder.getOrk();
    }
    
    public Ork createBasicOrk() {
        orkBuilder.createNewOrk();
        orkBuilder.buildName();
        orkBuilder.buildTribe();
        orkBuilder.buildWeapon();
        orkBuilder.buildArmor();
        orkBuilder.buildBanner();
        orkBuilder.buildStrength();
        orkBuilder.buildAgility();
        orkBuilder.buildIntelligence();
        orkBuilder.buildHealth();
        return getOrk();
    }
    
    public Ork createLeaderOrk() {
        Ork ork = createBasicOrk();
        ork.setStrength(ork.getStrength() + 20);
        ork.setHealth(ork.getHealth() + 50);
        ork.setBanner(ork.getBanner() + " и горн");
        ork.setType("Командир");
        return ork;
    }
    
    public Ork createScoutOrk() {
        Ork ork = createBasicOrk();
        ork.setWeapon("лук");
        ork.setAgility(ork.getAgility() + 30);
        ork.setHealth(ork.getHealth() - 20); 
        ork.setType("Разведчик");
        return ork;
    }
    
    public void constructCustomOrk(boolean withBanner, boolean isRanged) {
        orkBuilder.createNewOrk();
        orkBuilder.buildName();
        orkBuilder.buildTribe();
        orkBuilder.buildStrength();
        orkBuilder.buildAgility();
        orkBuilder.buildIntelligence();
        orkBuilder.buildHealth();
        
        if (isRanged) {
            orkBuilder.buildWeapon("Лук"); 
        } else {
            orkBuilder.buildWeapon();
        }
        
        if (withBanner) {
            orkBuilder.buildBanner();
        }
    }
}