package main.PopUpGUI.Model;

import main.Files.IMyFile;

import java.util.List;

public class FileExplorer implements IFileExplorer {
    @Override
    public List<IMyFile> getSubFiles(IMyFile myFile) {
        return myFile.getChildren();
    }
}
