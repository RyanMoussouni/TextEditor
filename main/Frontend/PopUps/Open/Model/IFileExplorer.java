package main.Frontend.PopUps.Open.Model;


import main.Backend.IO.IMyFile;

import java.util.List;

public interface IFileExplorer {
    List<IMyFile> getSubFiles(IMyFile file);
}