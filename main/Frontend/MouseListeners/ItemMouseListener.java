package main.Frontend.MouseListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemMouseListener implements MouseListener {
    private final Action _itemAction;

    public ItemMouseListener(Action itemAction){
        _itemAction = itemAction;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        var source = e.getSource();
        var id = e.getID();
        var actionEvent = new ActionEvent(source, id, null);

        _itemAction.actionPerformed(actionEvent);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
