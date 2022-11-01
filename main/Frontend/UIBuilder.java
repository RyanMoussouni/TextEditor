package main.Frontend;

import main.Frontend.ComponentTraverser.DFSComponentTraverser;
import main.Frontend.Main.MainFrame;
import main.Frontend.Main.MainPanel;

import javax.swing.*;
import java.awt.*;

// TODO: refactor this:
// TODO: add regions
// TODO: factorize some code that is shared by a lot of subroutines
public class UIBuilder {
    public static ISearchableContainer mainFrame;

    public static void build(){
        Component header = Header.getMenuBar();
        Component main = CentralArea.getScrollableTextArea();
        Component footer = Footer.getStatusBar();

        var mainPanel = new MainPanel(header, main, footer);
        mainFrame = new MainFrame(mainPanel);
        var traverser = new DFSComponentTraverser();
        var components = traverser.traverse(mainPanel);

    }
}