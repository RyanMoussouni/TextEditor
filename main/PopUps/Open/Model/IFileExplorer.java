package main.PopUps.Open.Model;


import main.Files.IMyFile;

import java.util.List;

public interface IFileExplorer {
    List<IMyFile> getSubFiles(IMyFile file);
}