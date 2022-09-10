package PopUpGUI.Vue;

import Files.IMyFile;
/* Frame = ok; */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PopUpFrame extends JFrame {
    public static void main(String[] args){
        JFrame popUpFrame = new PopUpFrame();
    }
    private final int WIDTH = 300;
    private final int HEIGHT = 300;

    private JTable filesTable;
    private final int numRows = 12;
    private final int numColumns = 4;

    public PopUpFrame(){
        this.setSize(new Dimension(WIDTH, HEIGHT));

        setMainPanel();
        this.setVisible(true);
    }

    private void setMainPanel(){
            JPanel mainPanel = new JPanel();
            filesTable = new JTable(numRows, numColumns);
            mainPanel.add(filesTable);

            this.add(mainPanel, BorderLayout.CENTER);
    }

    public void update(List<IMyFile> files){
    }
}
