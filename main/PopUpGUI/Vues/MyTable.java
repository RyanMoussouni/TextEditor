package main.PopUpGUI.Vues;

import main.Files.IMyFile;
import main.Files.MyFile;

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
        updateUI();
    }

    public IMyFile getClickedFile() {
        var selectedRow = getSelectedRow();
        return dataModel.getFileAt(selectedRow);
    }
}
