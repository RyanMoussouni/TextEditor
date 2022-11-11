package main.Frontend.Main;

import main.Frontend.SwingUtils.ComponentTreeFinder.ComponentFinder;
import main.Frontend.SwingUtils.ComponentTreeFinder.IComponentFinder;

import java.awt.*;

// TODO: refactor this:
// TODO: add regions
// TODO: factorize some code that is shared by a lot of subroutines
public class MainFrameBuilder {
    // Used by the controllers to search for specific components
    public static IComponentFinder finder;

    public static void build() {
        var mainPanel = getMainPanel();

        var mainFrame = new MainFrame(mainPanel);
        mainFrame.setName("Main Frame");

        finder = new ComponentFinder(mainFrame);
    }

    public static Component getMainPanel() {
        Component header = HeaderBuilder.build();
        Component main = CentralAreaBuilder.build();
        Component footer = FooterBuilder.build();

        var mainPanel = new MainPanel(header, main, footer);
        mainPanel.setName("Main Panel");

        return mainPanel;
    }
}