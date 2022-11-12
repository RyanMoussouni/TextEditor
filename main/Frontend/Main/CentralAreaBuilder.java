package main.Frontend.Main;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class CentralAreaBuilder {
    public static Component centralArea;

    public static void build() {
        var textArea = getTextArea();
        var scrollPane = getScrollPanel(textArea);

        centralArea = scrollPane;
    }

    private static Component getTextArea() {
        var textArea = new JTextArea();
        textArea.setName("Text Area");

        var manager = new UndoManager();
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });

        KeyStroke undoKeystroke = KeyStroke.getKeyStroke("meta Z");
        KeyStroke redoKeystroke = KeyStroke.getKeyStroke("meta Y");


        textArea.getInputMap().put(undoKeystroke, "undoKeystroke");
        textArea.getActionMap().put("undoKeystroke", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.undo();
                }
                catch (CannotUndoException cue) {
                    System.out.println("Cannot undo");
                }
            }
        });

        textArea.getInputMap().put(redoKeystroke, "redoKeystroke");
        textArea.getActionMap().put("redoKeystroke", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.redo();
                }
                catch (CannotRedoException cre) {
                    System.out.println("Cannot redo");
                }
            }
        });
        return textArea;
    }

    private static Component getScrollPanel(Component textArea) {
        var scrollPanel = new JScrollPane(textArea);
        scrollPanel.setName("Scroll Panel");

        return scrollPanel;
    }
}
