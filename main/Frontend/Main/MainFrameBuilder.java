package main.Frontend.Main;

import main.Frontend.SwingUtils.ComponentTreeFinder.ComponentFinder;
import main.Frontend.SwingUtils.ComponentTreeFinder.IComponentFinder;

import javax.swing.*;
import java.awt.*;

// TODO: refactor this:
public class MainFrameBuilder {
    // Used by the controllers to search for specific components
    public static IComponentFinder finder;
    public static JFrame mainFrame;

    public static void build() {
        var mainPanel = getMainPanel();
        mainFrame = new MainFrame(mainPanel);
        mainFrame.setName("Main Frame");

        finder = new ComponentFinder(mainFrame);
    }

    public static Component getMainPanel() {
        HeaderBuilder.build();
        CentralAreaBuilder.build();
        FooterBuilder.build();

        var mainPanel = new MainPanel(
                HeaderBuilder.header
                , CentralAreaBuilder.centralArea
                , FooterBuilder.footer);

        mainPanel.setName("Main Panel");

        return mainPanel;
    }
}