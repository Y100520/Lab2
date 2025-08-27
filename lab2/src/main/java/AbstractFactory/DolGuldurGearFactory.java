/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

public class DolGuldurGearFactory implements OrkGearFactory {
    @Override
    public Weapon createWeapon() {
        return new DolGuldurWeapon();
    }

    @Override
    public Armor createArmor() {
        return new DolGuldurArmor();
    }

    @Override
    public Banner createBanner() {
        return new DolGuldurBanner();
    }

    class DolGuldurWeapon implements Weapon {
        @Override
        public String getDiscription() {
            return "Копье";
        }
    }

    class DolGuldurArmor implements Armor {
        @Override
        public String getDiscription() {
            return "Кольчуга";
        }
    }

    class DolGuldurBanner implements Banner {
        @Override
        public String getDiscription() {
            return "Знамя с пауком";
        }
    }
}
