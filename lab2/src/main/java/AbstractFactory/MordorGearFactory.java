/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

public class MordorGearFactory implements OrkGearFactory{
    @Override
    public Weapon createWeapon(){
        return new MordorWeapon();
    }
    
    @Override
    public Armor createArmor() {
        return new MordorArmor();
    }

    @Override
    public Banner createBanner() {
        return new MordorBanner();
    }
}