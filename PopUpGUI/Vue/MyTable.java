package PopUpGUI.Vue;

import Files.IMyFile;
import PopUpGUI.Vue.PopUpDataModel.PopUpDataModel;

import javax.swing.*;
import java.util.List;

public class MyTable extends JTable implements IMyTable {
    protected PopUpDataModel dataModel;

    public MyTable(){
        super(new PopUpDataModel());
        dataModel = (PopUpDataModel) super.dataModel;
    }

    @Override
    public void updateDisplayedFiles(List<IMyFile> myFiles) {
        dataModel.updateFiles(myFiles);
    }
}
