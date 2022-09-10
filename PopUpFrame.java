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

    public PopUpFrame(){
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.add(new JTextArea(), BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void update(List<IMyFile> files){
    }
}
