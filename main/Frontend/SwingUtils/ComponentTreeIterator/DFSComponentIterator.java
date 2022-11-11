package main.Frontend.SwingUtils.ComponentTreeIterator;

import java.awt.*;
import java.util.*;

public class DFSComponentIterator implements Iterator<Component> {
    private enum Color {WHITE, GRAY, BLACK}

    private Stack<Component> _componentStack;
    private final Hashtable<Component, Color> _componentColor = new Hashtable<>();

    public DFSComponentIterator(Container root) {
        setComponentStack(root);
    }

    private void setComponentStack(Container root) {
        _componentStack = new Stack<>();

        _componentStack.push(root);
        _componentColor.put(root, Color.WHITE);
    }

    //TODO: test this (possibly not correct)
    public boolean hasNext() {
        return _componentColor.contains(Color.WHITE);
    }

    public Component next() throws NoSuchElementException {
        Optional<Component> next = Optional.empty();

        while (!_componentStack.isEmpty() && next.isEmpty()) {
            var peek = _componentStack.peek();
            var peekColor = _componentColor.get(peek);

            if (peekColor == Color.WHITE) {
                // component is being discovered
                _componentColor.replace(peek, Color.GRAY);
                next = Optional.of(peek);
                addChildren(peek);
            }

            if (peekColor == Color.GRAY) {
                // component is discovered
                if (isNewComponentColorBlack(peek)) {
                    _componentColor.replace(peek, Color.BLACK);
                }
            }

            if (peekColor == Color.BLACK) {
                //sub rooted-tree has been discovered
                _componentStack.pop();
            }
        }

        if (next.isEmpty()) {
            throw new NoSuchElementException();
        }

        return next.get();
    }

    private void addChildren(Component component) {
        if (component instanceof Container) {
            var children = Arrays.asList(((Container) component).getComponents());
            Collections.reverse(children);

            for (Component child : children) {
                _componentColor.putIfAbsent(child, Color.WHITE);

                if (_componentColor.get(child) == Color.WHITE) {
                    _componentStack.push(child);
                }
            }
        }
    }

    private boolean isNewComponentColorBlack(Component component) {
        var isContainer = component instanceof Container;

        return !isContainer || isNewContainerColorBlack((Container) component);
    }

    private boolean isNewContainerColorBlack(Container container) {
        var children = container.getComponents();
        var hasWhiteChild = Arrays.stream(children).anyMatch(
                c -> _componentColor.get(c) == Color.WHITE
        );

        return !hasWhiteChild;
    }
}