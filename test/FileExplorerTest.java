package test;

import main.Files.MyFile;
import main.PopUpGUI.Model.FileExplorer;
import main.PopUpGUI.Model.IFileExplorer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileExplorerTest {
    private FileExplorer fileExplorer;

    private List<MyFile> filesToTest;

    @BeforeEach
    void setUp(){
        fileExplorer = new FileExplorer();
        setFilesToTest();
    }

    private List<MyFile> setFilesToTest(){
        filesToTest = new ArrayList<>();

        filesToTest.add(new MyFile("/", "Users"));
        return filesToTest;
    }

    //This test will fail on another computer; it is intended for personal use
    @Test
    void getSubFiles() {
        var actual = fileExplorer.getSubFiles(filesToTest.get(0));
        var expected = new ArrayList<MyFile>();
        expected.add(new MyFile("/Users", ".localized"));
        expected.add(new MyFile("/Users", "Shared"));
        expected.add(new MyFile("/Users", "ryan"));
        expected.add(new MyFile("/Users", "engineering"));

        Assertions.assertIterableEquals(expected, actual);
    }
}