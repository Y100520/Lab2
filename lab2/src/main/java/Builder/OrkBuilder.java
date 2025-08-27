package Builder;

import AbstractFactory.OrkGearFactory;
import com.github.javafaker.Faker;

public abstract class OrkBuilder {
    protected Ork ork;
    protected Faker faker;
    protected OrkGearFactory gearFactory;

    public OrkBuilder() {
        this.ork = new Ork();
        this.faker = new Faker();
    }

    public void createNewOrk() {
        ork = new Ork();
    }

    public Ork getOrk() {
        return ork;
    }

    public void setGearFactory(OrkGearFactory gearFactory) {
        this.gearFactory = gearFactory;
    }

    public abstract void buildAttributes();

    public abstract void buildGear();

    public void buildCustomWeapon(String weapon) {
        ork.setWeapon(weapon);
    }

    public void buildCustomBanner(String addition) {
        ork.setBanner(ork.getBanner() + " " + addition);
    }
}
