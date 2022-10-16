package main.PopUps.Search;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SearchKeyListener implements KeyListener {
    private final char SEARCH_KEY = 'F';
    private final int SEARCH_KEY_MODIFIER = KeyEvent.CTRL_DOWN_MASK;

    @Override
    public void keyTyped(KeyEvent e) {
        var keyTyped = e.getKeyChar();
        var keyModifier = e.getModifiersEx();

        if (keyTyped == SEARCH_KEY
            && keyModifier == SEARCH_KEY_MODIFIER){
            //TODO: implement this
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //intentionally left empty
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //intentionally left empty
    }
}
