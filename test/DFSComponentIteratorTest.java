package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DFSComponentIteratorTest {
    private Component _root;

    @BeforeEach
    void setUp() {
        var flattenedBinaryTree = new Component[]{
            new Container(),
            new Container(),
            new JButton(),
            new Container(),
            new JButton()
        };
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void next() {
    }
}