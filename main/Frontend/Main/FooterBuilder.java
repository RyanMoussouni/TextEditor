package main.Frontend.Main;

import javax.swing.*;
import java.awt.*;

public class FooterBuilder {
    public static Component build() {
        var statusBar = new JButton("Status Bar");
        statusBar.setName("Status Bar");

        return statusBar;
    }
}
