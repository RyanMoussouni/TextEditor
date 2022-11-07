package main.Frontend.ComponentTreeOperators.ComponentTreeFinder;

import java.awt.*;
import java.util.Optional;

public interface IComponentFinder {
    Optional<Component> find(int id);
    Optional<Component> find(String name);
    Optional<Component> find(Component component);
}
