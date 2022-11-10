package test;

import main.Frontend.ComponentTreeOperators.ComponentTreeIterator.DFSComponentIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.NoSuchElementException;

class DFSComponentIteratorTest {


    // We use the name as a way of indexing the components
    @Test
    void test_no_next() {
        var root = new JButton();
        var iterator = new DFSComponentIterator(root);
        iterator.next(); //iterate over the root element

        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void test_single_component_node() {
        var root = new JButton();
        var iterator = new DFSComponentIterator(root);

        root.setName("1");

        var expected = "1";
        var actual = iterator.next().getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_single_container_node() {
        var root = new Container();
        var iterator = new DFSComponentIterator(root);

        root.setName("1");

        var expected = "1";
        var actual = iterator.next().getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_single_node_with_single_child() {
        var root = new Container();
        var child = new JButton();

        root.setName("1");
        child.setName("2");

        root.add(child);

        var iterator = new DFSComponentIterator(root);

        var expected = new String[]{"1", "2"};
        var actual = new String[]{iterator.next().getName(), iterator.next().getName()};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test_single_node_with_multiple_children(){
        var root = new Container();
        var child1 = new JButton();
        var child2 = new JButton();
        var child3 = new JButton();

        root.setName("1");
        child1.setName("2");
        child2.setName("3");
        child3.setName("4");

        root.add(child1);
        root.add(child2);
        root.add(child3);

        var iterator = new DFSComponentIterator(root);

        var expected = new String[]{"1", "2", "3", "4"};
        var actual = new String[]{
                iterator.next().getName(),
                iterator.next().getName(),
                iterator.next().getName(),
                iterator.next().getName()};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test_perfect_binary_tree_of_depth_three(){
        var root = new Container();
        var child1_level1 = new Container();
        var child2_level1 = new Container();
        var child1_level2 = new JButton();
        var child2_level2 = new JButton();
        var child3_level2 = new JButton();
        var child4_level2 = new JButton();
        
        root.setName("1");
        child1_level1.setName("2");
        child1_level2.setName("3");
        child2_level2.setName("4");
        child2_level1.setName("5");
        child3_level2.setName("6");
        child4_level2.setName("7");

        root.add(child1_level1);
        root.add(child2_level1);
        child1_level1.add(child1_level2);
        child1_level1.add(child2_level2);
        child2_level1.add(child3_level2);
        child2_level1.add(child4_level2);

        var iterator = new DFSComponentIterator(root);

        var expected = new String[]{"1", "2", "3", "4", "5", "6", "7"};

        var actual = new String[]{
                iterator.next().getName(),
                iterator.next().getName(),
                iterator.next().getName(),
                iterator.next().getName(),
                iterator.next().getName(),
                iterator.next().getName(),
                iterator.next().getName()};

        Assertions.assertArrayEquals(expected, actual);
    }
}