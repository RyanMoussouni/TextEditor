package main.Frontend.Actions;

import javax.swing.*;
import java.awt.*;

public class ReplaceEdit extends AbstractTextAction {
    @Override
    protected void showDialog(Component mainFrame, Component relativeComponent) {
        var absoluteLocation = relativeComponent.getLocationOnScreen();
        var size = relativeComponent.getSize();

        var dialog = new JDialog((JFrame) mainFrame, "Dialog");
        dialog.add(new JButton("My Button"));

        dialog.setLocationRelativeTo(relativeComponent);
        dialog.setSize(new Dimension(200,100));
        dialog.setLocation(absoluteLocation.x + size.width - 200, absoluteLocation.y);
        dialog.setUndecorated(true);
        dialog.setVisible(true);
        dialog.setResizable(false);
    }
}