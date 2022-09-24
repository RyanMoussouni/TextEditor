package main.PopUpGUI.Vues;

import main.Files.IMyFile;
import main.PopUpGUI.Model.PopUpModel;

import javax.swing.*;
import java.util.List;

public class MyTable extends JTable implements IMyTable {
    protected PopUpModel dataModel;

    public MyTable(){
        super(new PopUpModel());
        dataModel = (PopUpModel) super.dataModel;
    }

    @Override
    public void updateDisplayedFiles(List<IMyFile> myFiles) {
        dataModel.updateFilesData(myFiles);
        updateUI();
    }

    public IMyFile getClickedFile() {
        var selectedRow = getSelectedRow();
        return dataModel.getFileAt(selectedRow);
    }
}
