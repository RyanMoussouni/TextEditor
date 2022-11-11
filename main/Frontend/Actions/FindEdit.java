package main.Frontend.Actions;

import main.Frontend.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FindEdit extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        var optionalTextArea = UIBuilder.finder.find("Text Area");

        if (optionalTextArea.isPresent()){
            var text = ((JTextArea) optionalTextArea.get()).getText();
            System.out.println(text);
        }
        else{
            var exceptionMessage = "Error: The key you used to find the text area component is invalid";
            System.out.println(exceptionMessage);
        }
    }
}
