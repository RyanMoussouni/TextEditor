package main.Frontend.Actions.FindAndReplace;

import main.Frontend.Dialogs.FindDialogBuilder;
import main.Frontend.Dialogs.ReplaceDialogBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShowFindComponent extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        var findDialog = FindDialogBuilder.findDialog;

        if (findDialog == null) {
            var warningMessage = "The dialog should not be null"
                    + " This is not an expected behavior, the dialog won't show";
            System.out.println(warningMessage);
        }
        else {
            if (!findDialog.isVisible()){
                findDialog.setVisible(true);

                var replaceDialog = ReplaceDialogBuilder.replaceDialog;
                if (replaceDialog != null && replaceDialog.isVisible())
                    replaceDialog.setVisible(false);
            }
        }
    }
}
