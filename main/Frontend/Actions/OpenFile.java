package main.Frontend.Actions;

import main.Backend.IO.MyFile;
import main.Frontend.Main.MainFrameBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenFile extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        var fileChooser = new JFileChooser();
        var returnValue = fileChooser.showOpenDialog(MainFrameBuilder.mainFrame);
        var finder = MainFrameBuilder.finder;

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            var fileToOpen = fileChooser.getSelectedFile();
            var textArea = (JTextArea) finder.find("Text Area").get();
            try {
                var myFile = new MyFile(fileToOpen);
                if (myFile.isAuthorizedFile()){
                    var text = myFile.getText();
                    textArea.setText(text);
                }
                else {
                    throw new RuntimeException("This file cannot be read by the software");
                }
            }
            catch (FileNotFoundException fnfe) {
                var exceptionMessage = "The file has not been found";
                throw new RuntimeException(exceptionMessage);
            }
            catch (IOException ioe) {
                var exceptionMessage = "The file can't be opened";
                throw new RuntimeException(exceptionMessage);
            }
        }

        else {
            //TODO: add logging here
        }
    }
}
