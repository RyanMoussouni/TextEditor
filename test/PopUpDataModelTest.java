package test;

import main.Files.MyFile;
import main.PopUpGUI.Vues.PopUpDataModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PopUpDataModelTest {
    private PopUpDataModel dataModel;

    @BeforeEach
    void setUp() {
        var setUpFiles = new ArrayList<MyFile>();
        setUpFiles.add(new MyFile("PATH_1", "NAME_1", false));

        dataModel = new PopUpDataModel(setUpFiles);
    }

    @Test
    void getValueAt(){
        Assertions.assertEquals("NAME_1", dataModel.getValueAt(0, 0));
        Assertions.assertEquals("File", dataModel.getValueAt(0,1));
    }

    @Test
    void updateFiles() {
        ArrayList<MyFile> expected = new ArrayList<>();
        expected.add(new MyFile("PATH_1", "NAME_1", false));
        expected.add(new MyFile("PATH_2", "NAME_2", false));

        dataModel.updateFiles(expected);

        Assertions.assertEquals("NAME_1", dataModel.getValueAt(0, 0));
        Assertions.assertEquals( "File", dataModel.getValueAt(0, 1));
        Assertions.assertEquals("NAME_2", dataModel.getValueAt(1, 0));
        Assertions.assertEquals( "File", dataModel.getValueAt(1, 1));
    }
}