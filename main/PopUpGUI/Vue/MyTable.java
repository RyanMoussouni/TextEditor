package main.PopUpGUI.Vue;

import main.Files.MyFile;
import main.PopUpGUI.Vue.PopUpDataModel.PopUpDataModel;

import javax.swing.*;
import java.util.ArrayList;

public class MyTable extends JTable implements IMyTable {
    protected PopUpDataModel dataModel;

    public MyTable(){
        super(new PopUpDataModel());
        dataModel = (PopUpDataModel) super.dataModel;
    }

    @Override
    public void updateDisplayedFiles(ArrayList<MyFile> myFiles) {
        dataModel.updateFiles(myFiles);
    }
}
