package main.Frontend.Actions.FindAndReplace;

import main.Backend.StringMatcher.BruteForceStringMatcher;
import main.Frontend.Dialogs.ReplaceDialogBuilder;
import main.Frontend.Main.MainFrameBuilder;
import main.Frontend.SwingUtils.ComponentTreeFinder.ComponentFinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Replace extends AbstractAction {

    //TODO: refactor this
    @Override
    public void actionPerformed(ActionEvent e) {
        var searchKey = getSearchKey();
        var replaceKey = getReplaceKey();
        var toMatch = getText();
        var stringMatcher = new BruteForceStringMatcher();

        var matches = stringMatcher.match(toMatch, searchKey);

        var displayedTextArea = (JTextArea) MainFrameBuilder.finder.find("Text Area").get();

        var delta = replaceKey.length() - searchKey.length();
        var cpt = 0;
        for (var match: matches) {
            displayedTextArea.replaceRange(
                    replaceKey,
                    match.getPosition() + cpt*delta,
                    match.getPosition() + cpt*delta + searchKey.length());
            cpt += 1;
        }
    }

    private String getSearchKey() throws RuntimeException {
        var finder = new ComponentFinder((Container) ReplaceDialogBuilder.replaceDialog);
        var optionalTextField = finder.find("Upper Text Field");

        if (optionalTextField.isEmpty()) {
            var exceptionMessage = "Could not find the text component that contains"
                    + " the key to search for in the text";
            throw new RuntimeException(exceptionMessage);
        }

        if (!(optionalTextField.get() instanceof JTextField textField)){
            var exceptionMessage = "The component should be a text field";
            throw new RuntimeException(exceptionMessage);
        }

        return textField.getText();
    }

    private String getReplaceKey() throws RuntimeException {
        var finder = new ComponentFinder((Container) ReplaceDialogBuilder.replaceDialog);
        var optionalTextField = finder.find("Lower Text Field");

        if (optionalTextField.isEmpty()) {
            var exceptionMessage = "Could not find the text component that contains"
                    + " the key to search for in the text";
            throw new RuntimeException(exceptionMessage);
        }

        if (!(optionalTextField.get() instanceof JTextField textField)){
            var exceptionMessage = "The component should be a text field";
            throw new RuntimeException(exceptionMessage);
        }

        return textField.getText();
    }

    //TODO: add exceptions for robustness
    private String getText() {
        var finder = MainFrameBuilder.finder;
        var textArea = finder.find("Text Area");

        return ((JTextArea) textArea.get()).getText();
    }
}
