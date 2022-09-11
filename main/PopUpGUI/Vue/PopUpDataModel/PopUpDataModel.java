package main.PopUpGUI.Vue.PopUpDataModel;

import main.Files.IMyFile;
import main.Files.MyDirectory;
import main.Files.MyFile;
import jdk.jshell.spi.ExecutionControl;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PopUpDataModel implements TableModel {
    private List<IMyFile> files;

    public PopUpDataModel(){
        var sampleFiles = new ArrayList<IMyFile>(
                        Collections.singleton(
                                                new MyDirectory("/",
                                                                "usr",
                                                                Collections.singletonList(new MyFile("/usr", "bin"))))
                        );

        files = sampleFiles;
    }

    public PopUpDataModel(List<IMyFile> myFiles){
        files = myFiles;
    }

    public void updateFiles(List<IMyFile> myFiles){
        files = myFiles;
    }

    @Override
    public int getRowCount() {
        return files.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String columnName = null;
        switch(columnIndex){
            case 0:
                columnName = "Name";
                break;
            case 1:
                columnName = "Type";
                break;
            default:
                try {
                    throw new NoSuchFieldException("Value");
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                break;
        }
        return columnName;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        String string = "";
        return string.getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        IMyFile row = files.get(rowIndex);
        boolean isDirectory = row instanceof MyDirectory;
        String value = null;

        switch (columnIndex){
            case 0:
                if (isDirectory) {
                    MyDirectory directory = (MyDirectory) row;
                    value = directory.name();
                }
                else{
                    MyFile simpleFile = (MyFile) row;
                    value = simpleFile.name();
                }
                break;
            case 1:
                value = isDirectory ? "Directory" : "File";
                break;
            default:
                try{
                    throw new NoSuchFieldException();
                }
                catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            throw new ExecutionControl.NotImplementedException("Sorry");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
}
