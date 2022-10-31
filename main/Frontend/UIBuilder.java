package main.Frontend;

import main.Frontend.ItemActions.NewFile;
import main.Frontend.ItemActions.OpenFile;
import main.Frontend.ItemActions.SaveFile;
import main.Frontend.Main.MainFrame;
import main.Frontend.Main.MainPanel;

import javax.swing.*;
import java.awt.*;

// Static class
public class UIBuilder {

    public static void build(){
        Component header = getFileMenu();
        Component main = new JButton("Main");
        Component footer = new JButton("Footer");

        var mainPanel = new MainPanel(header, main, footer);
        var mainFrame = new MainFrame(mainPanel);
    }


    private static JMenu getFileMenu(){
        var newItem = getNewItem();
        var openItem = getOpenItem();
        var saveItem = getSaveItem();


        var fileMenu = new JMenu();

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        return fileMenu;
    }

    //TODO: refactor this, key and new should be properties
    private static JMenuItem getNewItem(){
        var key = "meta N";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new NewFile();
        var inputMap = new InputMap();
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var newMenuItem = new JMenuItem("New");
        newMenuItem.setInputMap(JComponent.WHEN_FOCUSED, inputMap);
        newMenuItem.setActionMap(actionMap);

        return newMenuItem;
    }

    private static JMenuItem getOpenItem() {
        var key = "meta O";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new OpenFile();
        var inputMap = new InputMap();
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var openMenuItem = new JMenuItem("Open");
        openMenuItem.setInputMap(JComponent.WHEN_FOCUSED, inputMap);
        openMenuItem.setActionMap(actionMap);

        return openMenuItem;
    }

    private static JMenuItem getSaveItem(){
        var key = "meta S";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new SaveFile();
        var inputMap = new InputMap();
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setInputMap(JComponent.WHEN_FOCUSED, inputMap);
        saveMenuItem.setActionMap(actionMap);

        return saveMenuItem;
    }
}