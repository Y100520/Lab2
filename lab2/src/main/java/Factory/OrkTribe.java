/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Builder.OrkBuilder;
import Factory.MordorOrkBuilderFactory;
import Factory.MistyMountainsOrkBuilderFactory;
import Factory.DolGuldurOrkBuilderFactory;
import java.util.function.Supplier;

public enum OrkTribe {
    MORDOR("Мордор", MordorOrkBuilderFactory::new),
    MISTY_MOUNTAINS("Мглистые горы", MistyMountainsOrkBuilderFactory::new),
    DOL_GULDUR("Дол Гулдур", DolGuldurOrkBuilderFactory::new);

    private final String tribeName;
    private final Supplier<OrkBuilderFactory> factorySupplier;

    OrkTribe(String tribeName, Supplier<OrkBuilderFactory> factorySupplier) {
        this.tribeName = tribeName;
        this.factorySupplier = factorySupplier;
    }

    public String getTribeName() {
        return tribeName;
    }

    public OrkBuilder createBuilder() {
        return factorySupplier.get().createOrkBuilder();
    }

    public static OrkTribe getByTribeName(String tribeName) {
        for (OrkTribe tribe : values()) {
            if (tribe.getTribeName().equalsIgnoreCase(tribeName.trim())) {
                return tribe;
            }
        }
        throw new IllegalArgumentException("Неизвестное племя: " + tribeName);
    }
}