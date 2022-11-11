package test;

import main.Frontend.ComponentTreeOperators.ComponentTreeFinder.ComponentFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.openmbean.InvalidKeyException;
import javax.swing.*;
import java.awt.*;
import java.util.Optional;

//TODO: Add a test for null value
class ComponentFinderTest {
    private ComponentFinder _finder;

    @BeforeEach
    void setUp(){
        var root = new Container();
        var child1_level1 = new Container();
        var child2_level1 = new Container();
        var child3_level1 = new JButton();
        var child1_level2 = new JButton();
        var child2_level2 = new JButton();
        var child3_level2 = new JButton();

        root.setName("1");
        child1_level1.setName("2");
        child2_level1.setName("2");
        child3_level1.setName("3");
        child1_level2.setName("4");
        child2_level2.setName("5");
        child3_level2.setName("6");

        root.add(child1_level1);
        root.add(child2_level1);
        root.add(child3_level1);
        child1_level1.add(child1_level2);
        child2_level1.add(child2_level2);
        child2_level1.add(child3_level2);

        _finder = new ComponentFinder(root);
    }

    @Test
    void findByNameWhenSingleComponentMatches(){
        var match = _finder.find("6");

        Assertions.assertTrue(match.isPresent());
        Assertions.assertEquals("6", match.get().getName());
    }

    @Test
    void findByNameWhenMultipleComponentsMatch(){
        Assertions.assertThrows(InvalidKeyException.class, () -> _finder.find("2"));
    }

    @Test
    void findByNameWhenNoComponentMatch(){
        var match = _finder.find("10");

        Assertions.assertTrue(match.isEmpty());
    }

    @Test
    void findMultipleTimes(){
        Optional<Component> match;

        match = _finder.find("1");
        Assertions.assertTrue(match.isPresent());

        match = _finder.find("3");
        Assertions.assertTrue(match.isPresent());

        match = _finder.find("4");
        Assertions.assertTrue(match.isPresent());
    }
}