package main.Frontend;

import javax.swing.*;
import java.awt.*;

public class CentralArea {
    public static Component getCentralTextArea() {
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
