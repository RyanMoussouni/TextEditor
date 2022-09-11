package PopUpGUI.Vue;

import Files.IMyFile;
import Files.MyDirectory;
import Files.MyFile;
import PopUpGUI.Vue.PopUpDataModel.PopUpDataModel;
/* Frame = ok; */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PopUpFrame extends JFrame {
    public static void main(String[] args){
        PopUpFrame popUpFrame = new PopUpFrame();
        List<IMyFile> files = new ArrayList<IMyFile>(
                Collections.singleton(new MyDirectory("/", "update test", Collections.singletonList(new MyFile("/usr", ""))))
        );

        popUpFrame.update(files);
    }
    private final int WIDTH = 300;
    private final int HEIGHT = 300;

    private MyTable filesTable;
    private final int numRows = 12;
    private final int numColumns = 4;

    public PopUpFrame(){
        this.setSize(new Dimension(WIDTH, HEIGHT));

        setMainPanel();
        this.setVisible(true);
    }

    private void setMainPanel(){
            JPanel mainPanel = new JPanel();
            filesTable = new MyTable();
            mainPanel.add(filesTable);

            this.add(mainPanel, BorderLayout.CENTER);
    }

    public void update(List<IMyFile> files){
        filesTable.updateDisplayedFiles(files);
    }
}
