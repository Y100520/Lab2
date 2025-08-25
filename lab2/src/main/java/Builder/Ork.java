/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

public class Ork {
    private String name;
    private String tribe;
    private String type;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;
    private String weapon;
    private String armor;
    private String banner;
    
    public void setName (String name) {this.name = name;}
    public void setTribe (String tribe) {this.tribe = tribe;}
    public void setType (String type) {this.type = type;}
    public void setStrength (int strength) {this.strength = strength;}
    public void setAgility (int agility) {this.agility = agility;}
    public void setIntelligence (int intelligence) {this.intelligence = intelligence;}
    public void setHealth (int health) {this.health = health;}
    public void setWeapon(String weapon) { this.weapon = weapon; }
    public void setArmor(String armor) { this.armor = armor; }
    public void setBanner(String banner) { this.banner = banner; }

    public String getName() {return name;}
    public String getTribe() {return tribe;}
    public String getType() {return type;}
    public int getStrength() {return strength;}
    public int getAgility() {return agility;}
    public int getIntelligence() {return intelligence;}
    public int getHealth() {return health;}
    public String getWeapon() { return weapon; }
    public String getArmor() { return armor; }
    public String getBanner() { return banner; }
    
    @Override
    public String toString() {
        return name;
    }
}