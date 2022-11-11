package main.Frontend.Actions;

import javax.swing.*;
import java.awt.*;

public class FindEdit extends AbstractTextAction {

    @Override
    protected void showDialog(Component mainFrame, Component relativeComponent) {
        var absoluteLocation = relativeComponent.getLocationOnScreen();
        var size = relativeComponent.getSize();

        var dialog = new JDialog((JFrame) mainFrame, "Dialog");
        dialog.setLayout(new BorderLayout());

        var textField = getTextField();
        var findButton = getFindButton();

        dialog.add(textField, BorderLayout.CENTER);
        dialog.add(findButton, BorderLayout.PAGE_END);

        dialog.setLocationRelativeTo(relativeComponent);
        dialog.setSize(new Dimension(200,50));
        dialog.setLocation(absoluteLocation.x + size.width - 200, absoluteLocation.y);
        dialog.setUndecorated(true);
        dialog.setVisible(true);
        dialog.setResizable(false);
    }

    private static Component getTextField() {
        var textField = new JTextField();
        textField.addActionListener(new ToyAction());

        return textField;
    }

    private static Component getFindButton() {
        var findButton = new JButton("Find");
        findButton.addActionListener(new ToyAction());

        return findButton;
    }
}
