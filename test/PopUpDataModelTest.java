package test;

import main.Files.IMyFile;
import main.Files.MyFile;
import main.PopUps.Open.Model.PopUpModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PopUpDataModelTest {
    private PopUpModel dataModel;

    @BeforeEach
    void setUp() {
        var setUpFiles = new ArrayList<IMyFile>();
        setUpFiles.add(new MyFile("PATH_1", "NAME_1"));

        dataModel = new PopUpModel(setUpFiles);
    }

    @Test
    void getValueAt(){
        Assertions.assertEquals("NAME_1", dataModel.getValueAt(0, 0));
        Assertions.assertEquals("File", dataModel.getValueAt(0,1));
    }

    @Test
    void updateFiles() {
        ArrayList<IMyFile> expected = new ArrayList<>();
        expected.add(new MyFile("PATH_1", "NAME_1"));
        expected.add(new MyFile("PATH_2", "NAME_2"));

        dataModel.updateFilesData(expected);

        Assertions.assertEquals("NAME_1", dataModel.getValueAt(0, 0));
        Assertions.assertEquals( "File", dataModel.getValueAt(0, 1));
        Assertions.assertEquals("NAME_2", dataModel.getValueAt(1, 0));
        Assertions.assertEquals( "File", dataModel.getValueAt(1, 1));
    }
}