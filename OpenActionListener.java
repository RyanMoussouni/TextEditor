import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenActionListener implements ActionListener {
    public OpenActionListener(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button pressed");
    }
}
