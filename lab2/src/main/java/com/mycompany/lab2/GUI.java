/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import Builder.*;
import Factory.*;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class GUI extends JFrame {
    private JTree armyTree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode rootNode;

    private JPanel infoPanel;
    private JLabel nameValue, tribeValue, typeValue, weaponValue, armorValue, bannerValue;
    private JProgressBar strengthBar, agilityBar, intelligenceBar, healthBar;

    public GUI() {
        super("Менеджер Армии Саурона");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLayout(new BorderLayout());

        createControlPanel();
        initializeArmyTree();
        createInfoPanel();

        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(armyTree), BorderLayout.WEST);
        add(infoPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void initializeArmyTree() {
        rootNode = new DefaultMutableTreeNode("Армия");
        rootNode.add(new DefaultMutableTreeNode("Мордор"));
        rootNode.add(new DefaultMutableTreeNode("Мглистые горы"));
        rootNode.add(new DefaultMutableTreeNode("Дол Гулдур"));

        treeModel = new DefaultTreeModel(rootNode);
        armyTree = new JTree(treeModel);

        armyTree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.getUserObject() instanceof Ork) {
                displayOrkInfo((Ork) selectedNode.getUserObject());
            }
        });
    }

    private JPanel controlPanel;
    private void createControlPanel() {
        controlPanel = new JPanel(new FlowLayout());

        JComboBox<String> tribeCombo = new JComboBox<>(new String[]{"Мордор", "Мглистые горы", "Дол Гулдур"});
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Базовый", "Разведчик", "Командир"});
        JButton createButton = new JButton("Создать орка");

        createButton.addActionListener(e -> {
            String selectedTribe = (String) tribeCombo.getSelectedItem();
            String selectedType = (String) typeCombo.getSelectedItem();
            Ork newOrk = createNewOrk(selectedTribe, selectedType);

            DefaultMutableTreeNode tribeNode = findTribeNode(selectedTribe);
            if (tribeNode != null) {
                tribeNode.add(new DefaultMutableTreeNode(newOrk));
                treeModel.reload(rootNode);
                armyTree.expandPath(new TreePath(tribeNode.getPath()));
            }
        });

        controlPanel.add(new JLabel("Племя:"));
        controlPanel.add(tribeCombo);
        controlPanel.add(new JLabel("Тип:"));
        controlPanel.add(typeCombo);
        controlPanel.add(createButton);
    }

    private void createInfoPanel() {
        infoPanel = new JPanel(new BorderLayout(10, 10));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Информация об орке"));

        JPanel statsPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        nameValue = new JLabel(); tribeValue = new JLabel(); typeValue = new JLabel();
        weaponValue = new JLabel(); armorValue = new JLabel(); bannerValue = new JLabel();
        statsPanel.add(new JLabel("Имя:")); statsPanel.add(nameValue);
        statsPanel.add(new JLabel("Племя:")); statsPanel.add(tribeValue);
        statsPanel.add(new JLabel("Тип:")); statsPanel.add(typeValue);
        statsPanel.add(new JLabel("Оружие:")); statsPanel.add(weaponValue);
        statsPanel.add(new JLabel("Броня:")); statsPanel.add(armorValue);
        statsPanel.add(new JLabel("Знамя:")); statsPanel.add(bannerValue);

        JPanel progressPanel = new JPanel();
        progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.Y_AXIS));
        strengthBar = new JProgressBar(0, 130);
        agilityBar = new JProgressBar(0, 130);
        intelligenceBar = new JProgressBar(0, 50);
        healthBar = new JProgressBar(0, 250);
        progressPanel.add(new JLabel("Сила:")); progressPanel.add(strengthBar);
        progressPanel.add(new JLabel("Ловкость:")); progressPanel.add(agilityBar);
        progressPanel.add(new JLabel("Интеллект:")); progressPanel.add(intelligenceBar);
        progressPanel.add(new JLabel("Здоровье:")); progressPanel.add(healthBar);

        infoPanel.add(statsPanel, BorderLayout.NORTH);
        infoPanel.add(progressPanel, BorderLayout.CENTER);
    }

    private Ork createNewOrk(String tribe, String type) {
        OrkBuilderFactory factory;

        switch (tribe) {
            case "Мордор":
                factory = new MordorOrkBuilderFactory();
                break;
            case "Мглистые горы":
                factory = new MistyMountainsOrkBuilderFactory();
                break;
            case "Дол Гулдур":
                factory = new DolGuldurOrkBuilderFactory();
                break;
            default:
                factory = new DolGuldurOrkBuilderFactory();
                break;
        }

        OrkBuilder builder = factory.createOrkBuilder();
        OrkDirector director = new OrkDirector();
        director.setOrkBuilder(builder);

        switch (type) {
            case "Разведчик":
                return director.createScoutOrk();
            case "Командир":
                return director.createLeaderOrk();
            default:
                Ork ork = director.createBasicOrk();
                ork.setType("Базовый");
                return ork;
        }
    }

    private DefaultMutableTreeNode findTribeNode(String tribeName) {
        for (int i = 0; i < rootNode.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) rootNode.getChildAt(i);
            if (node.getUserObject().equals(tribeName)) {
                return node;
            }
        }
        return null;
    }

    private void displayOrkInfo(Ork ork) {
        nameValue.setText(ork.getName());
        tribeValue.setText(ork.getTribe());
        typeValue.setText(ork.getType());
        weaponValue.setText(ork.getWeapon());
        armorValue.setText(ork.getArmor());
        bannerValue.setText(ork.getBanner());

        strengthBar.setValue(ork.getStrength());
        agilityBar.setValue(ork.getAgility());
        intelligenceBar.setValue(ork.getIntelligence());
        healthBar.setValue(ork.getHealth());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
