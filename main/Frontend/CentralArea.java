package main.Frontend;

import javax.swing.*;
import java.awt.*;

public class CentralArea {
    public static Component getScrollableTextArea() {
        var textArea = getTextArea();

        return new JScrollPane(textArea);
    }

    private static Component getTextArea() {
        var textArea = new JTextArea();
        textArea.setName("Text Area");

        return textArea;
    }
}
