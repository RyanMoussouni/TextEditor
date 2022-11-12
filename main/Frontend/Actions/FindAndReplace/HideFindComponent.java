package main.Frontend.Actions.FindAndReplace;

import main.Frontend.Dialogs.FindDialogBuilder;
import main.Frontend.Main.MainFrameBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HideFindComponent extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        var findDialog = FindDialogBuilder.findDialog;
        var optionalTextArea = MainFrameBuilder.finder.find("Text Area");

        if (findDialog == null) {
            var exceptionMessage = "The dialog should not be null"
                    + " This is not an expected behavior";
            throw new RuntimeException(exceptionMessage);
        }
        else if (optionalTextArea.isEmpty()) {
            var exceptionMessage = "The text area can't be found"
                    + " This is not an expected behavior";
            throw new RuntimeException(exceptionMessage);
        }
        else if (!(optionalTextArea.get() instanceof JTextArea textArea) ) {
            var exceptionMessage = "The text area can't be found"
                    + " This is not an expected behavior";
            throw new RuntimeException(exceptionMessage);
        }
        else {
            findDialog.setVisible(false);
            textArea.getHighlighter().removeAllHighlights();
        }
    }
}
