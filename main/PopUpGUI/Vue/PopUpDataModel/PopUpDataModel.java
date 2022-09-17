package main.PopUpGUI.Vue.PopUpDataModel;

import jdk.jshell.spi.ExecutionControl;
import main.Files.MyFile;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

//TODO: think about how to refactor this, it is no easily rideable
public class PopUpDataModel implements TableModel {
    private List<MyFile> files;

    public PopUpDataModel(){files = new ArrayList<>();};

    public PopUpDataModel(List<MyFile> myFiles){
        files = myFiles;
    }

    public void updateFiles(List<MyFile> myFiles){
        files = myFiles;
    }

    public MyFile getFileAt(int row) {
        if(row >= files.size() || row < 0) {
            try {
                throw new Exception("Invalid Argument");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return files.get(row);
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
        var row = files.get(rowIndex);
        return columnIndex == 0 ? row.name() : (row.isDirectory() ? "Directory" : "File");
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
