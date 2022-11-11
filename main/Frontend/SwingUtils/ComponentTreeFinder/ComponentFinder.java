package main.Frontend.SwingUtils.ComponentTreeFinder;

import main.Frontend.SwingUtils.ComponentTreeIterator.DFSComponentIterator;

import javax.management.openmbean.InvalidKeyException;
import java.awt.*;
import java.util.Iterator;
import java.util.Optional;

public class ComponentFinder implements IComponentFinder {
    private final Container _rootComponent;

    public ComponentFinder(Container root) {
        _rootComponent = root;
    }

    // TODO: refactor this
    // The name of a component should be a unique identifier of this component for the component finder to be correct
    @Override
    public Optional<Component> find(String key) throws InvalidKeyException {
        Optional<Component> match = Optional.empty();
        var iterator = getIterator();

        var foundCounter = 0;
        while (iterator.hasNext()) {
            var candidate = iterator.next();

            if (candidate.getName() == null) {
                var warningMessage = "One of the UI component has no name."
                        + " It could lead to an unexpected behavior";
                System.out.println(warningMessage);
            }

            //TODO: change this condition so that the != null is not here
            if (candidate.getName() != null && candidate.getName().equals(key)) {
                foundCounter += 1;

                if (foundCounter > 1) {
                    var exceptionMessage = String.format("Multiple components name match the %s provided key.", key)
                            + " Please check your settings";
                    throw new InvalidKeyException(exceptionMessage);
                }

                match = Optional.of(candidate);
            }
        }

        return match;
    }

    private Iterator<Component> getIterator() {
        return new DFSComponentIterator(_rootComponent);
    }
}
