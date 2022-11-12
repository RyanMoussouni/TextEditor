package main;
import main.Frontend.Dialogs.PopUpDialogsBuilder;
import main.Frontend.Main.MainFrameBuilder;

import javax.swing.*;

public class Main {

    public static void main(String[] args){
        MainFrameBuilder.build();
        PopUpDialogsBuilder.build();

        var fileChooser = new JFileChooser();
    }
}