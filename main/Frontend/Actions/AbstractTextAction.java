package main.Frontend.Actions;

import main.Frontend.UIBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class AbstractTextAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        var optionalMainFrame = UIBuilder.finder.find("Main Frame");
        var optionalScrollPanel = UIBuilder.finder.find("Scroll Panel");

        if (optionalMainFrame.isPresent() && optionalScrollPanel.isPresent()){
            var mainFrame = optionalMainFrame.get();
            var scrollPanel = optionalScrollPanel.get();

            assertIsGUINotResizable(mainFrame);
            showDialog(mainFrame, scrollPanel);
        }
        else{
            var exceptionMessage = "Error: The key you used to find the text area component is invalid";
            System.out.println(exceptionMessage);
        }
    }

    private void assertIsGUINotResizable(Component component) throws RuntimeException {
        var isGUIResizable = ((JFrame) component).isResizable();

        if (isGUIResizable) {
            var exceptionMessage = "The main frame being resizable is not part of the specifications"
                    + " This could lead to unexpected behavior";
            throw new RuntimeException(exceptionMessage);
        }
    }

    protected abstract void showDialog(Component mainFrame, Component relativeComponent);
}
