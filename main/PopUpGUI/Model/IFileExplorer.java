package main.PopUpGUI.Model;


import main.Files.MyFile;

import java.util.ArrayList;

public interface IFileExplorer {
    public ArrayList<MyFile> getSubFiles(MyFile file);
}