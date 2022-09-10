import javax.swing.*;

public class MyMenuBar extends JMenuBar {
    private final String TabName = "File";
    private final String OpenMenuItem = "Open";
    private final String SaveMenuItem = "Save";

    private class FileMenu extends JMenu {
        public FileMenu() {
            super(TabName);

            JMenuItem open = new JMenuItem(OpenMenuItem);
            JMenuItem save = new JMenuItem(SaveMenuItem);

            add(open);
            add(save);
        }
    }

    public MyMenuBar() {
        add(new FileMenu());
    }
}