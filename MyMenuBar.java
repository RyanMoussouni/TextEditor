import javax.swing.*;

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
        }
    }

    public MyMenuBar() {
        add(new FileMenu());
    }
}