package main.PopUpGUI.Model;


import main.Files.MyFile;

import java.util.List;

public interface IFileExplorer {
    List<MyFile> getSubFiles(MyFile file);
}