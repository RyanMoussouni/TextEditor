package main.Frontend.Dialogs;

import main.Frontend.Actions.FindAndReplace.HideFindComponent;
import main.Frontend.Actions.FindAndReplace.HideReplaceComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ReplaceDialogBuilder {
    public static Component replaceDialog;

    public static void build(JFrame frame, Component component) {
        var absoluteLocation = component.getLocationOnScreen();
        var size = component.getSize();

        var dialog = new JDialog(frame, "Replace Dialog");
        dialog.setLayout(new BorderLayout());

        var upperTextField = getUpperTextField();
        var lowerTextField = getLowerTextField();
        var replaceButton = getReplaceButton();

        dialog.add(upperTextField, BorderLayout.PAGE_START);
        dialog.add(lowerTextField, BorderLayout.CENTER);
        dialog.add(replaceButton, BorderLayout.PAGE_END);

        dialog.setLocationRelativeTo(component);
        dialog.setSize(new Dimension(200,80));
        dialog.setLocation(absoluteLocation.x + size.width - 200, absoluteLocation.y);
        dialog.setUndecorated(true);
        dialog.setResizable(false);

        var root = (JPanel) dialog.getContentPane();
        var escapeStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                escapeStroke, "esc"
        );
        root.getActionMap().put( "esc", new HideReplaceComponent()
        );

        replaceDialog = dialog;
    }

    private static Component getReplaceButton() {
        return new JButton("Replace");
    }

    private static Component getUpperTextField() throws RuntimeException {
        return new JTextField("Search");
    }

    private static Component getLowerTextField() {
        return new JTextField("Replace");
    }
}
