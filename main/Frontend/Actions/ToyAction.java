package main.Frontend.Actions;

import java.awt.*;

public class ToyAction extends AbstractTextAction {
    @Override
    protected void showDialog(Component mainFrame, Component relativeComponent) {
        System.out.println("You name it");
    }
}
