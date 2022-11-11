package main.Frontend;

import main.Frontend.Actions.*;
import main.Frontend.MouseListeners.ItemMouseListener;

import javax.swing.*;
import java.awt.*;

//TODO: make everything abstract so that someone will be able to maintain it and change it in the future
public class Header {
    public static Component getMenuBar() {
        JMenu fileMenu = getFileMenu();
        JMenu editMenu = getEditMenu();
        JMenu viewMenu = getViewMenu();

        fileMenu.setName("File Menu");
        editMenu.setName("Edit Menu");
        viewMenu.setName("View Menu");

        JMenuBar menuBar = new JMenuBar();

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        menuBar.setName("Menu Bar");

        return menuBar;
    }

    private static JMenu getFileMenu(){
        JMenuItem newItem = getNewItem();
        JMenuItem openItem = getOpenItem();
        JMenuItem saveItem = getSaveItem();

        newItem.setName("New Item");
        openItem.setName("Open Item");
        saveItem.setName("Save Item");

        var fileMenu = new JMenu("File");

        fileMenu.setName("File Menu");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        return fileMenu;
    }

    //TODO: refactor this, key and new should be properties
    private static JMenuItem getNewItem(){
        var newMenuItem = new JMenuItem("New");

        var key = "meta N";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new NewFile();
        var inputMap = new ComponentInputMap(newMenuItem);
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var newItemMouseListener = new ItemMouseListener(action);
        newMenuItem.addMouseListener(newItemMouseListener);


        newMenuItem.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        newMenuItem.setActionMap(actionMap);
        newMenuItem.setAccelerator(keyStroke);

        return newMenuItem;
    }

    private static JMenuItem getOpenItem() {
        var openMenuItem = new JMenuItem("Open");

        var key = "meta O";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new OpenFile();
        var inputMap = new ComponentInputMap(openMenuItem);
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var openItemMouseListener = new ItemMouseListener(action);
        openMenuItem.addMouseListener(openItemMouseListener);

        openMenuItem.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        openMenuItem.setActionMap(actionMap);
        openMenuItem.setAccelerator(keyStroke);

        return openMenuItem;
    }

    private static JMenuItem getSaveItem(){
        var saveMenuItem = new JMenuItem("Save");

        var key = "meta S";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new SaveFile();
        var inputMap = new ComponentInputMap(saveMenuItem);
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var saveItemMouseListener = new ItemMouseListener(action);
        saveMenuItem.addMouseListener(saveItemMouseListener);

        saveMenuItem.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        saveMenuItem.setActionMap(actionMap);
        saveMenuItem.setAccelerator(keyStroke);

        return saveMenuItem;
    }

    private static JMenu getEditMenu() {
        JMenuItem undoItem = getUndoMenuItem();
        JMenuItem redoItem = getRedoMenuItem();
        JMenuItem findItem = getFindMenuItem();
        JMenuItem replaceItem = getReplaceMenuItem();

        undoItem.setName("Undo Item");
        redoItem.setName("Redo Item");
        findItem.setName("Find Item");
        replaceItem.setName("Replace Item");

        var editMenu = new JMenu("Edit");
        editMenu.add(undoItem);
        editMenu.add(redoItem);
        editMenu.add(findItem);
        editMenu.add(replaceItem);

        return editMenu;
    }

    private static JMenuItem getUndoMenuItem() {
        var undoMenuItem = new JMenuItem("Undo");

        var key = "meta Z";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new UndoEdit();
        var inputMap = new ComponentInputMap(undoMenuItem);
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var undoMenuItemMouseListener = new ItemMouseListener(action);
        undoMenuItem.addMouseListener(undoMenuItemMouseListener);

        undoMenuItem.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        undoMenuItem.setActionMap(actionMap);
        undoMenuItem.setAccelerator(keyStroke);

        return undoMenuItem;
    }

    private static JMenuItem getRedoMenuItem() {
        var redoMenuItem = new JMenuItem("Redo");
        var key = "meta Y";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new RedoEdit();
        var inputMap = new ComponentInputMap(redoMenuItem);
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var redoMenuItemMouseListener = new ItemMouseListener(action);
        redoMenuItem.addMouseListener(redoMenuItemMouseListener);

        redoMenuItem.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        redoMenuItem.setActionMap(actionMap);
        redoMenuItem.setAccelerator(keyStroke);

        return redoMenuItem;
    }

    private static JMenuItem getFindMenuItem() {
        var findMenuItem = new JMenuItem("Find");
        var key = "meta F";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new FindEdit();
        var inputMap = new ComponentInputMap(findMenuItem);
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var findMenuItemMouseListener = new ItemMouseListener(action);
        findMenuItem.addMouseListener(findMenuItemMouseListener);

        findMenuItem.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        findMenuItem.setActionMap(actionMap);
        findMenuItem.setAccelerator(keyStroke);

        return findMenuItem;
    }

    private static JMenuItem getReplaceMenuItem() {
        var replaceMenuItem = new JMenuItem("Replace");
        var key = "meta R";
        var keyStroke = KeyStroke.getKeyStroke(key);
        var action = new ReplaceEdit();
        var inputMap = new ComponentInputMap(replaceMenuItem);
        var actionMap = new ActionMap();
        actionMap.put(key, action);
        inputMap.put(keyStroke, key);

        var replaceMenuItemMouseListener = new ItemMouseListener(action);
        replaceMenuItem.addMouseListener(replaceMenuItemMouseListener);

        replaceMenuItem.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        replaceMenuItem.setActionMap(actionMap);
        replaceMenuItem.setAccelerator(keyStroke);

        return replaceMenuItem;
    }

    private static JMenu getViewMenu() {
        return new JMenu("View");
    }
}
