import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Main {
    public static int HEIGHT = 300;
    public static int LENGTH = 300;

    public static void main(String[] args){
        Dimension dimension = getDimension();
        JFrame frame = new JFrame();
        JMenuBar menuBar = new JMenuBar();
        BorderLayout borderLayout = new BorderLayout();
        JMenu menu = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        menu.add(open);
        menu.add(save);
        menuBar.add(menu);
        JTextArea textArea = new JTextArea();

        frame.setSize(dimension);
        frame.setLayout(borderLayout);
        frame.add(menuBar, BorderLayout.PAGE_START);
        frame.add(textArea, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static Dimension getDimension(){
        return new Dimension(HEIGHT, LENGTH);
    }
}