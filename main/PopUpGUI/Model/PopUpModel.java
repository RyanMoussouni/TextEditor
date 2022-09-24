package main.PopUpGUI.Model;

import jdk.jshell.spi.ExecutionControl;
import main.Files.IMyFile;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class PopUpModel implements TableModel {
    private static final int COLUMN_COUNT = 2;
    private List<IMyFile> files;

    public PopUpModel(){
        files = new ArrayList<>();
    }

    public PopUpModel(List<IMyFile> myFiles){
        files = myFiles;
    }

    public void updateFilesData(List<IMyFile> myFiles){
        files = myFiles;
    }

    public IMyFile getFileAt(int rowNumber) {
        var isInvalidRowNumber = (rowNumber >= files.size() || rowNumber < 0);
        if(isInvalidRowNumber) {
            try {
                throw new Exception("Invalid Argument");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return files.get(rowNumber);
    }

    @Override
    public int getRowCount() {
        return files.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
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
        return "Sample string".getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var row = files.get(rowIndex);
        Object returnedValue = null;
        switch (columnIndex) {
            case 0:
                var fileName = row.getName();
                returnedValue = fileName;
            case 1:
                var fileTypeName = row.isDirectory() ? "Directory" : "File";
                returnedValue = fileTypeName;
            default:
                try {
                    throw new NoSuchFieldException("Value");
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                break;
        }
        return returnedValue;
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
