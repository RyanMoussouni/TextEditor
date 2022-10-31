package main.Frontend.Main;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(Component header, Component main, Component footer){
        super();
        setLayout(header, main, footer);

        setVisible(true);
    }

    private void setLayout(Component header, Component main, Component footer) {
        var layout = new BorderLayout();
        super.setLayout(layout);

        add(header, BorderLayout.PAGE_START);
        add(main, BorderLayout.CENTER);
        add(footer, BorderLayout.PAGE_END);
    }
}
