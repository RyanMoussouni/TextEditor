package main.Frontend.Main;

import javax.swing.*;
import java.awt.*;

public class FooterBuilder {
    public static Component footer;

    public static void build() {
        var statusBar = new JButton("Status Bar");
        statusBar.setName("Status Bar");

        footer = statusBar;
    }
}
