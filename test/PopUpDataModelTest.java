package test;

import main.Files.IMyFile;
import main.Files.MyFile;
import main.PopUpGUI.Vue.PopUpDataModel.PopUpDataModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PopUpDataModelTest {
    private PopUpDataModel dataModel;

    @BeforeEach
    void setUp() {
        var setUpFiles = new ArrayList<IMyFile>();
        setUpFiles.add(new MyFile("PATH_1", "NAME_1"));

        dataModel = new PopUpDataModel(setUpFiles);
    }

    @Test
    void getValueAt(){
        Assertions.assertEquals(dataModel.getValueAt(0, 0), "NAME_1");
        Assertions.assertEquals(dataModel.getValueAt(0,1), "File");
    }

    @Test
    void updateFiles() {
        ArrayList<IMyFile> expected = new ArrayList<IMyFile>();
        expected.add(new MyFile("PATH_1", "NAME_1"));
        expected.add(new MyFile("PATH_2", "NAME_2"));

        dataModel.updateFiles(expected);

        Assertions.assertEquals("NAME_1", dataModel.getValueAt(0, 0));
        Assertions.assertEquals( "File", dataModel.getValueAt(0, 1));
        Assertions.assertEquals("NAME_2", dataModel.getValueAt(1, 0));
        Assertions.assertEquals( "File", dataModel.getValueAt(1, 1));
    }
}