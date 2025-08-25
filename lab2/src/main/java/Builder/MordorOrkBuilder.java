package Builder;
import AbstractFactory.MordorGearFactory;
import java.util.Random;

public class MordorOrkBuilder extends OrkBuilder{
    
    public MordorOrkBuilder(){
        this.gearFactory = new MordorGearFactory();
    }
    
    private Random random = new Random();
    
    @Override
    public void buildName() {ork.setName(faker.lordOfTheRings().character());}
    
    @Override
    public void buildTribe() {ork.setTribe("Mordor");}
   
    @Override
    public void buildStrength() {
        int baseStrength = 50 + random.nextInt(30);
        ork.setStrength((int)(baseStrength * 1.3));}
    
    @Override
    public void buildAgility() {ork.setAgility(10 + random.nextInt(30));}
    
    @Override
    public void buildIntelligence() {ork.setIntelligence(1 + random.nextInt(50));}
    
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