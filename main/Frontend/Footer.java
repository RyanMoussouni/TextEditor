package main.Frontend;

import javax.swing.*;
import java.awt.*;

public class Footer {
    public static Component getStatusBar() {
        var statusBar = new JButton("Status Bar");
        statusBar.setName("Status Bar");

        return statusBar;
    }
}
