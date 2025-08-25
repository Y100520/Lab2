/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

public class MistyMountainsGearFactory implements OrkGearFactory {
    @Override
    public Weapon createWeapon() {
        return new MistyMountainsWeapon();
    }

    @Override
    public Armor createArmor() {
        return new MistyMountainsArmor();
    }

    @Override
    public Banner createBanner() {
        return new MistyMountainsBanner();
    }
}