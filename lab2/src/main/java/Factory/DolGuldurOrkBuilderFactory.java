/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import AbstractFactory.DolGuldurGearFactory;
import Builder.OrkBuilder;
import Builder.DolGuldurOrkBuilder;

public class DolGuldurOrkBuilderFactory extends OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        return new DolGuldurOrkBuilder();
    }
}