package main.Frontend.Actions.FindAndReplace;

import main.Frontend.Dialogs.ReplaceDialogBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HideReplaceComponent extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        var replaceDialog = ReplaceDialogBuilder.replaceDialog;

        if (replaceDialog == null) {
            var warningMessage = "The dialog should not be null"
                    + " This is not an expected behavior, the dialog won't show";
            System.out.println(warningMessage);
        }
        else {
            replaceDialog.setVisible(false);
        }
    }
}
