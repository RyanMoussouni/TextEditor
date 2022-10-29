package main.Frontend.PopUps.Open.Vues;

import main.Backend.IO.IMyFile;

import java.util.List;

public interface IMyTable {
    void updateDisplayedFiles(List<IMyFile> myFiles);
}
