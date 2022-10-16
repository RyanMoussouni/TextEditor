package main.PopUps.Search;

import main.MainFrame.TextArea.ISearchableTextArea;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SearchKeyListener implements KeyListener {
    private final char SEARCH_KEY = 'F';
    private final int SEARCH_KEY_MODIFIER = KeyEvent.ALT_DOWN_MASK;
    private ISearchableTextArea _textArea;

    public SearchKeyListener(ISearchableTextArea textArea){
        System.out.println("HW0");
        this._textArea = textArea;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        e.consume();
        var keyTyped = e.getKeyChar();
        var keyModifier = e.getModifiersEx();

        var displayedKeyTyped = String.format("Key Typed %c", keyTyped);
        var displayedKeyModifier = String.format("Key modifier %d", keyModifier);

        System.out.println(displayedKeyTyped);
        System.out.println(displayedKeyModifier);

        if (keyTyped == SEARCH_KEY
            && keyModifier == SEARCH_KEY_MODIFIER){
            System.out.println("HW");
            new JSearchPopUpFrame(_textArea);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        var keyPressed = e.getKeyChar();
        var displayedKeyPressed = String.format("Key Pressed %c", keyPressed);

        System.out.println(displayedKeyPressed);
        //intentionally left empty
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //intentionally left empty
    }
}
