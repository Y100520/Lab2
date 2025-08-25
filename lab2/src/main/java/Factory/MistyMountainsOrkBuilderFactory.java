/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import AbstractFactory.MistyMountainsGearFactory;
import Builder.OrkBuilder;
import Builder.MistyMountainsOrkBuilder;


public class MistyMountainsOrkBuilderFactory extends OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        return new MistyMountainsOrkBuilder();
    }
}