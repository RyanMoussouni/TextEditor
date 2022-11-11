package main.Frontend.Main;

import javax.swing.*;
import java.awt.*;

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

        return textArea;
    }

    private static Component getScrollPanel(Component textArea) {
        var scrollPanel = new JScrollPane(textArea);
        scrollPanel.setName("Scroll Panel");

        return scrollPanel;
    }
}
