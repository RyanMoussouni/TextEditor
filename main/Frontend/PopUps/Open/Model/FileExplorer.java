package main.Frontend.PopUps.Open.Model;

import main.Backend.IO.IMyFile;

import java.util.List;

public class FileExplorer implements IFileExplorer {
    @Override
    public List<IMyFile> getSubFiles(IMyFile myFile) {
        return myFile.getChildren();
    }
}
