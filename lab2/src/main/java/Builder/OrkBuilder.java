/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;
import com.github.javafaker.Faker;
import AbstractFactory.OrkGearFactory;

abstract public class OrkBuilder {
    protected Ork ork;
    protected Faker faker = new Faker();
    protected OrkGearFactory gearFactory;
    
    public OrkBuilder() {
        this.ork = new Ork(); 
    }
    
    public void setGearFactory(OrkGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }
    
    public Ork getOrk() {return ork;}
    public void createNewOrk() {ork = new Ork();}
    
    public abstract void buildName();
    public abstract void buildTribe();
    public abstract void buildStrength();
    public abstract void buildAgility();
    public abstract void buildIntelligence();
    public abstract void buildHealth();
    public abstract void buildWeapon();
    public abstract void buildWeapon(String customWeapon);
    public abstract void buildArmor();
    public abstract void buildBanner();
    public abstract void buildBanner(String customBanner);
}