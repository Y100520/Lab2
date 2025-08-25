/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

import Builder.*;
import Factory.*;

public class GUI extends JFrame {
    private JTree armyTree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode rootNode;
    private JPanel infoPanel;

    public GUI() {
        super("Менеджер Армии");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);
        setLayout(new BorderLayout());
        initializeArmyTree();
        createControlPanel();
        createInfoPanel();
        add(new JScrollPane(armyTree), BorderLayout.WEST);
        add(infoPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void initializeArmyTree() {
        rootNode = new DefaultMutableTreeNode("Армия");
        DefaultMutableTreeNode mordorNode = new DefaultMutableTreeNode("Мордор");
        DefaultMutableTreeNode mistyMountainsNode = new DefaultMutableTreeNode("Мглистые горы");
        DefaultMutableTreeNode dolGuldurNode = new DefaultMutableTreeNode("Дол Гулдур");

        rootNode.add(mordorNode);
        rootNode.add(mistyMountainsNode);
        rootNode.add(dolGuldurNode);

        treeModel = new DefaultTreeModel(rootNode);
        armyTree = new JTree(treeModel);

        armyTree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.getUserObject() instanceof Ork) {
                displayOrkInfo((Ork) selectedNode.getUserObject());
            }
        });
    }

    private void createControlPanel() {
        JPanel controlPanel = new JPanel(new FlowLayout());

        JLabel tribeLabel = new JLabel("Выберите племя:");
        JComboBox<String> tribeCombo = new JComboBox<>(new String[]{"Мордор", "Мглистые горы", "Дол Гулдур"});

        JLabel typeLabel = new JLabel("Тип орка:");
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Обычный", "Разведчик", "Командир"});


        JButton createButton = new JButton("Создать нового орка");
        createButton.addActionListener(e -> {
            String selectedTribe = (String) tribeCombo.getSelectedItem();
            String selectedType = (String) typeCombo.getSelectedItem();
            Ork newOrk = createNewOrk(selectedTribe, selectedType);

            DefaultMutableTreeNode tribeNode = findTribeNode(selectedTribe);
            if (tribeNode != null) {
                tribeNode.add(new DefaultMutableTreeNode(newOrk));
                treeModel.reload();

                int childCount = treeModel.getChildCount(rootNode);
                for (int i = 0; i < childCount; i++) {
                    armyTree.expandPath(new TreePath(((DefaultMutableTreeNode) treeModel.getChild(rootNode, i)).getPath()));
                }
            }
        });

        controlPanel.add(tribeLabel);
        controlPanel.add(tribeCombo);
        controlPanel.add(typeLabel);
        controlPanel.add(typeCombo);
        controlPanel.add(createButton);

        add(controlPanel, BorderLayout.NORTH);
    }

    private void createInfoPanel() {
        infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBorder(BorderFactory.createTitledBorder("Информация об орке"));

        JPanel statsPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        JLabel nameLabel = new JLabel("Имя:");
        JLabel nameValue = new JLabel();
        nameValue.setName("nameValue");

        JLabel tribeLabel = new JLabel("Племя:");
        JLabel tribeValue = new JLabel();
        tribeValue.setName("tribeValue");
        
        JLabel typeLabel = new JLabel("Тип:");
        JLabel typeValue = new JLabel();
        typeValue.setName("typeValue");

        JLabel weaponLabel = new JLabel("Оружие:");
        JLabel weaponValue = new JLabel();
        weaponValue.setName("weaponValue");

        JLabel armorLabel = new JLabel("Броня:");
        JLabel armorValue = new JLabel();
        armorValue.setName("armorValue");

        JLabel bannerLabel = new JLabel("Знамя:");
        JLabel bannerValue = new JLabel();
        bannerValue.setName("bannerValue");

        statsPanel.add(nameLabel);
        statsPanel.add(nameValue);
        statsPanel.add(tribeLabel);
        statsPanel.add(tribeValue);
        statsPanel.add(typeLabel);
        statsPanel.add(typeValue);
        statsPanel.add(weaponLabel);
        statsPanel.add(weaponValue);
        statsPanel.add(armorLabel);
        statsPanel.add(armorValue);
        statsPanel.add(bannerLabel);
        statsPanel.add(bannerValue);

        JPanel progressPanel = new JPanel(new GridLayout(4, 1, 5, 5));

        JLabel strengthLabel = new JLabel("Сила:");
        JProgressBar strengthBar = new JProgressBar(0, 100);
        strengthBar.setName("strengthBar");

        JLabel agilityLabel = new JLabel("Ловкость:");
        JProgressBar agilityBar = new JProgressBar(0, 100);
        agilityBar.setName("agilityBar");

        JLabel intelligenceLabel = new JLabel("Интеллект:");
        JProgressBar intelligenceBar = new JProgressBar(0, 50);
        intelligenceBar.setName("intelligenceBar");

        JLabel healthLabel = new JLabel("Здоровье:");
        JProgressBar healthBar = new JProgressBar(0, 200);
        healthBar.setName("healthBar");

        progressPanel.add(strengthLabel);
        progressPanel.add(strengthBar);
        progressPanel.add(agilityLabel);
        progressPanel.add(agilityBar);
        progressPanel.add(intelligenceLabel);
        progressPanel.add(intelligenceBar);
        progressPanel.add(healthLabel);
        progressPanel.add(healthBar);

        infoPanel.add(statsPanel, BorderLayout.NORTH);
        infoPanel.add(progressPanel, BorderLayout.CENTER);
    }

    private Ork createNewOrk(String tribe, String type) {
        OrkBuilder builder = OrkTribe.getByTribeName(tribe).createBuilder();
        OrkDirector director = new OrkDirector();
        director.setOrkBuilder(builder);

        switch (type) {
            case "Разведчик":
                return director.createScoutOrk();
                
            case "Командир":
                return director.createLeaderOrk();
            default:
                Ork ork = director.createBasicOrk();
                ork.setType(type);
                return ork;
        }
    }
        

    private DefaultMutableTreeNode findTribeNode(String tribeName) {
        int childCount = treeModel.getChildCount(rootNode);
        for (int i = 0; i < childCount; i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeModel.getChild(rootNode, i);
            if (node.getUserObject().equals(tribeName)) {
                return node;
            }
        }
        return null;
    }

    private void displayOrkInfo(Ork ork) {

    findLabelAndSetText(infoPanel, "nameValue", ork.getName());
    findLabelAndSetText(infoPanel, "tribeValue", ork.getTribe());
    findLabelAndSetText(infoPanel, "typeValue", ork.getType());
    findLabelAndSetText(infoPanel, "weaponValue", ork.getWeapon());
    findLabelAndSetText(infoPanel, "armorValue", ork.getArmor());
    findLabelAndSetText(infoPanel, "bannerValue", ork.getBanner());

    findProgressBarAndSetValue(infoPanel, "strengthBar", ork.getStrength());
    findProgressBarAndSetValue(infoPanel, "agilityBar", ork.getAgility());
    findProgressBarAndSetValue(infoPanel, "intelligenceBar", ork.getIntelligence());
    findProgressBarAndSetValue(infoPanel, "healthBar", ork.getHealth());
}

    private void findLabelAndSetText(Container container, String name, String text) {
    for (Component comp : container.getComponents()) {
        if (comp.getName() != null && comp.getName().equals(name)) {
            ((JLabel) comp).setText(text);
            return;
        }
        if (comp instanceof Container) {
            findLabelAndSetText((Container) comp, name, text);
        }
    }
}

private void findProgressBarAndSetValue(Container container, String name, int value) {
    for (Component comp : container.getComponents()) {
        if (comp.getName() != null && comp.getName().equals(name)) {
            ((JProgressBar) comp).setValue(value);
            return;
        }
        if (comp instanceof Container) {
            findProgressBarAndSetValue((Container) comp, name, value);
        }
    }}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}