/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import Builder.Ork;
import Builder.OrkBuilder;

public class OrkDirector {
    private OrkBuilder orkBuilder;

    public void setOrkBuilder(OrkBuilder builder) {
        this.orkBuilder = builder;
    }

    public Ork createBasicOrk() {
        orkBuilder.createNewOrk();
        orkBuilder.buildAttributes();
        orkBuilder.buildGear();
        return orkBuilder.getOrk();
    }

    public Ork createLeaderOrk() {
        Ork ork = createBasicOrk();
        ork.setType("Командир");
        ork.setStrength(ork.getStrength() + 20);
        ork.setHealth(ork.getHealth() + 50);
        ork.setBanner(ork.getBanner() + " и горн");
        return ork;
    }

    public Ork createScoutOrk() {
        Ork ork = createBasicOrk();
        ork.setType("Разведчик");
        ork.setWeapon("Лук");
        ork.setAgility(ork.getAgility() + 30);
        ork.setHealth(ork.getHealth() - 20);
        return ork;
    }
}
