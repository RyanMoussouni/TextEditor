package main.PopUpGUI.Model;

import main.Files.*;

import java.util.List;

public interface IFileExplorer {
    public List<IMyFile> getSubFiles(IMyFile file);
}