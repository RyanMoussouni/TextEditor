package main.MainGUI;

import main.Files.MyFile;
import main.PopUpGUI.Controllers.OpenPopUpController;
import main.PopUpGUI.Model.FileExplorer;
import main.PopUpGUI.Vues.Frame.OpenPopUpFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MyFrame extends JFrame {
    public class OpenActionListener implements ActionListener {
        //TODO: refactor this
        @Override
        public void actionPerformed(ActionEvent e) {
            MyFrame myFrame = MyFrame.this;
            var openPopUpFrame = new OpenPopUpFrame();
            var fileExplorer = new FileExplorer();
            var openPopUpController = new OpenPopUpController(myFrame, openPopUpFrame, fileExplorer);
            var files = new ArrayList<>(Arrays.asList(new MyFile("/", "Users", true)));
            openPopUpFrame.update(files);
            openPopUpFrame.addMouseClickEventListener(openPopUpController);
        }
    }

    public class SaveActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var isFileLoadedIntoTextPane = MyFrame.this.isFileLoadedIntoTextPane();
            if (isFileLoadedIntoTextPane){
                try {
                    MyFrame.this.saveDisplayedTextIntoFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else{
                System.out.println("Not implemented sry");
            }
        }
    }

    public class MyMenuBar extends JMenuBar {
        private final String TabName = "File";
        private final String OpenMenuItem = "Open";
        private final String SaveMenuItem = "Save";

        private class FileMenu extends JMenu {
            JMenuItem openButton, saveButton;

            public FileMenu() {
                super(TabName);

                setOpenButton();
                setSaveButton();
            }

            public void setOpenButton(){
                openButton = new JMenuItem(OpenMenuItem);

                OpenActionListener openAL = new OpenActionListener();
                openButton.addActionListener(openAL);
                add(openButton);
            }

            public void setSaveButton(){
                saveButton = new JMenuItem(SaveMenuItem);
                add(saveButton);

                SaveActionListener saveAL = new SaveActionListener();
                saveButton.addActionListener(saveAL);
                add(saveButton);
            }
        }

        public MyMenuBar() {
            add(new FileMenu());
        }
    }

    public MyFrame(MyTextPane textPane, Dimension dimension) {
        super();
        setSize(dimension);
        setLayout();
        setMenuBar(new MyMenuBar());
        setTextPane(textPane);

        setVisible(true);
    }

    private void setLayout() {
        setLayout(new BorderLayout());
    }

    private void setMenuBar(MyMenuBar myMenuBar) {
        add(myMenuBar, BorderLayout.PAGE_START);
    }

    private void setTextPane(MyTextPane textPane) {
        add(textPane, BorderLayout.CENTER);
    }

    private MyTextPane getTextPane() throws NullPointerException {
        var components = getContentPane().getComponents();

        MyTextPane textPane = null;
        for (Component component: components) {
            if (component instanceof MyTextPane)
                textPane = (MyTextPane) component;
        }
        if (textPane == null){
            throw new NullPointerException("Pane has not been initialized");
        }
        return textPane;
    }

    public void readIntoTextPane(File f) throws NullPointerException, IOException {
        MyTextPane textPane = getTextPane();

        textPane.read(f);
    }

    public boolean isFileLoadedIntoTextPane(){
        MyTextPane textPane = getTextPane();

        return textPane.getDisplayedFile() != null;
    }

    private void saveDisplayedTextIntoFile() throws IOException {
        var textPane = getTextPane();

        textPane.saveDisplayedTextIntoFile();
    }
}