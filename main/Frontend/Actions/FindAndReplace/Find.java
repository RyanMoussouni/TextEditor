package main.Frontend.Actions.FindAndReplace;

import main.Backend.StringMatcher.BruteForceStringMatcher;
import main.Frontend.Dialogs.FindDialogBuilder;
import main.Frontend.Main.MainFrameBuilder;
import main.Frontend.SwingUtils.ComponentTreeFinder.ComponentFinder;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Find extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        var key = getKey();
        var toMatch = getText();
        var stringMatcher = new BruteForceStringMatcher();

        var matches = stringMatcher.match(toMatch, key);

        var displayedTextArea = (JTextArea) MainFrameBuilder.finder.find("Text Area").get();
        var highlighter = displayedTextArea.getHighlighter();

        for (var match : matches) {
            try {
                var position = match.getPosition();
                var keyLength = key.length();
                highlighter.addHighlight(
                        position,
                        position + keyLength,
                        new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
            }
            catch (BadLocationException ble) {
                ble.printStackTrace();
            }
        }
    }

    private String getKey() throws RuntimeException {
        var finder = new ComponentFinder((Container) FindDialogBuilder.findDialog);
        var optionalTextField = finder.find("Text Field");

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
