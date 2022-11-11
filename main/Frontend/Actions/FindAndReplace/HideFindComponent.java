package main.Frontend.Actions.FindAndReplace;

import main.Frontend.Dialogs.FindDialogBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HideFindComponent extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        var findDialog = FindDialogBuilder.findDialog;

        if (findDialog == null) {
            var warningMessage = "The dialog should not be null"
                    + " This is not an expected behavior, the dialog won't show";
            System.out.println(warningMessage);
        }
        else {
            findDialog.setVisible(false);
        }
    }
}
