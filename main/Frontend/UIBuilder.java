package main.Frontend;

import main.Frontend.ComponentTreeOperators.ComponentTreeFinder.ComponentFinder;
import main.Frontend.ComponentTreeOperators.ComponentTreeFinder.IComponentFinder;
import main.Frontend.Main.MainFrame;
import main.Frontend.Main.MainPanel;

import java.awt.*;

// TODO: refactor this:
// TODO: add regions
// TODO: factorize some code that is shared by a lot of subroutines
public class UIBuilder {
    //This container is used by the controllers to search for specific components
    public static IComponentFinder finder;

    public static void build(){
        Component header = Header.getMenuBar();
        Component main = CentralArea.getScrollableTextArea();
        Component footer = Footer.getStatusBar();

        var mainPanel = new MainPanel(header, main, footer);
        var root = new MainFrame(mainPanel);

        mainPanel.setName("Main Panel");
        root.setName("Main Frame");

        finder = new ComponentFinder(root);
    }
}