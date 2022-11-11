package main.Frontend.Main;

import javax.swing.*;
import java.awt.*;

public class CentralAreaBuilder {
    public static Component build() {
        var textArea = getTextArea();
        var scrollPane = getScrollPanel(textArea);

        return scrollPane;
    }

    private static Component getTextArea() {
        var textArea = new JTextArea();
        textArea.setName("Text Area");

        return textArea;
    }

    private static Component getScrollPanel(Component textArea) {
        var scrollPanel = new JScrollPane(textArea);
        scrollPanel.setName("Scroll Panel");

        return scrollPanel;
    }
}
