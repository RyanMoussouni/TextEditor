package main.Frontend;

import main.Frontend.Main.MainFrame;
import main.Frontend.Main.MainPanel;

import java.awt.*;

// TODO: refactor this:
// TODO: add regions
// TODO: factorize some code that is shared by a lot of subroutines
public class UIBuilder {
    //This container is used by the controllers to search for specific components
    public static Container rootComponent;

    public static void build(){
        Component header = Header.getMenuBar();
        Component main = CentralArea.getScrollableTextArea();
        Component footer = Footer.getStatusBar();

        var mainPanel = new MainPanel(header, main, footer);
        rootComponent = new MainFrame(mainPanel);
    }
}