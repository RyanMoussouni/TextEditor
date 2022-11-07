package main.Frontend.ComponentTreeOperators.ComponentTreeFinder;

import main.Frontend.ComponentTreeOperators.ComponentTreeIterator.DFSComponentIterator;

import java.awt.*;
import java.util.Iterator;
import java.util.Optional;

public class ComponentFinder implements IComponentFinder {
    private Container _rootComponent;

    public ComponentFinder(Container root){
        _rootComponent = root;
    }

    @Override
    public Iterator<Component> getIterator(Container component) {

    }

    @Override
    public Optional<Component> find(int id) {
        var iterator = new DFSComponentIterator(_rootComponent);
        for ()
    }

    @Override
    public Optional<Component> find(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Component> find(Component component) {
        return Optional.empty();
    }
}
