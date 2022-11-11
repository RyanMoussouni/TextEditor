package main.Frontend.Dialogs;

import main.Frontend.Actions.FindAndReplace.HideFindComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FindDialogBuilder {
    public static Component findDialog;

    public static void build(JFrame relativeFrame, Component relativeComponent) {
        var absoluteLocation = relativeComponent.getLocationOnScreen();
        var size = relativeComponent.getSize();

        var dialog = new JDialog(relativeFrame, "Find Dialog");
        dialog.setLayout(new BorderLayout());

        var textField = getTextField();
        var findButton = getFindButton();

        dialog.add(textField, BorderLayout.CENTER);
        dialog.add(findButton, BorderLayout.PAGE_END);

        dialog.setLocationRelativeTo(relativeComponent);
        dialog.setSize(new Dimension(200,50));
        dialog.setLocation(absoluteLocation.x + size.width - 200, absoluteLocation.y);
        dialog.setUndecorated(true);
        dialog.setResizable(false);

        //TODO: refactor this and add exception for the type casting
        var root = (JPanel) dialog.getContentPane();
        var escapeStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                escapeStroke, "esc"
        );
        root.getActionMap().put( "esc", new HideFindComponent()
        );

        findDialog = dialog;
    }

    public static Component getTextField() {
        return new JTextField();
    }

    public static Component getFindButton() {
        return new JButton("Find");
    }
}
