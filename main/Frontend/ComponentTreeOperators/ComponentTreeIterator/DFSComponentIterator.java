package main.Frontend.ComponentTreeOperators.ComponentTreeIterator;

import java.awt.*;
import java.util.*;

//TODO: test this and refactor;
public class DFSComponentIterator implements Iterator<Component> {
    private enum Color {GRAY, BLACK}
    private Stack<Component> _componentStack;
    private final Hashtable<Component,Color> _componentColor = new Hashtable<>();

    public DFSComponentIterator(Container root){
        setComponentStack(root);
    }

    private void setComponentStack(Container root) {
        _componentStack = new Stack<>();

        _componentColor.put(root, Color.GRAY);
        _componentStack.push(root);
    }

    //TODO: change this (faux)
    public boolean hasNext(){
        throw new RuntimeException();
    }

    //TODO: finish this
    public Component next() throws NoSuchElementException{
        Optional<Component> next = Optional.empty();
        while (!_componentStack.isEmpty()){
            var top = _componentStack.pop();
            var topColor = _componentColor.get(top);

            if(topColor != Color.BLACK){
                _componentStack.push(top);
                _componentColor.replace(top, getUpdatedComponentColor(top));

                if (top instanceof Container){
                    var topChildren = ((Container) top).getComponents();
                    for (Component child : topChildren){
                        var childColor = _componentColor.get(child);

                        if (childColor == null){
                            _componentColor.put(child, Color.GRAY);
                            next = Optional.of(child);
                        }
                    }
                }
            }
        }

        if (next.isEmpty()){
            throw new NoSuchElementException();
        }

        return next.get();
    }

    private Color getUpdatedComponentColor(Component component){
        var isContainer = component instanceof Container;
        var black = Color.BLACK;

        return isContainer ? getUpdatedContainerColor((Container) component)
                : black;
    }

    private Color getUpdatedContainerColor(Container container) {
        var gray = Color.GRAY;
        var black = Color.BLACK;

        var components = container.getComponents();
        var hasWhiteChild = Arrays.stream(components).anyMatch(
                c -> _componentColor.get(c) != null
        );

        return hasWhiteChild ? gray
                : black;
    }
}