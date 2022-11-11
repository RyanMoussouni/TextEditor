package main.Frontend.ComponentTreeOperators.ComponentTreeFinder;

import java.awt.*;
import java.util.Optional;

public interface IComponentFinder {
    Optional<Component> find(String name);
}
