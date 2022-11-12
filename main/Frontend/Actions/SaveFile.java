package main.Frontend.Actions;

import main.Backend.IO.IMyFile;
import main.Backend.IO.MyFile;
import main.Frontend.Main.MainFrameBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class SaveFile extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        var finder = MainFrameBuilder.finder;
        var textArea = (JTextArea) finder.find("Text Area").get();

        var optionalFile = Optional.ofNullable((IMyFile) textArea.getDocument().getProperty("file"));

        if (optionalFile.isEmpty()) {
            var fileChooser = new JFileChooser();
            var returnValue = fileChooser.showSaveDialog(MainFrameBuilder.mainFrame);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                optionalFile = Optional.of(new MyFile(fileChooser.getSelectedFile()));
            }
        }

        if (optionalFile.isPresent()) {
            var file = optionalFile.get();
            try {
                if (file.isAuthorizedFile()) {
                    var text = textArea.getText();
                    file.writeText(text);
                } else {
                    throw new RuntimeException("This file cannot be read by the software");
                }
            } catch (FileNotFoundException fnfe) {
                var exceptionMessage = "The file has not been found";
                throw new RuntimeException(exceptionMessage);
            } catch (IOException ioe) {
                var exceptionMessage = "The file can't be opened";
                throw new RuntimeException(exceptionMessage);
            }
        }
        else {
            System.out.println("User stopped ...");
        }
    }
}
