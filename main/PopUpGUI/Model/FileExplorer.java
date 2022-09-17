package main.PopUpGUI.Model;

import main.Files.MyFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileExplorer implements IFileExplorer{
    @Override
    public List<MyFile> getSubFiles(MyFile myFile) {
        List<MyFile> subFiles = new ArrayList<>();
        if (myFile.isDirectory())
        {
            Path directoryPath = Path.of(String.join("/", myFile.parentPath(), myFile.name()));
            try{
                List<MyFile> fileAndSubFiles = Files.walk(directoryPath, 1)
                        .map(path -> pathMapper(path))
                        .toList();
                subFiles = fileAndSubFiles.subList(1, fileAndSubFiles.size());
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return subFiles;
    }

    private MyFile pathMapper(Path filePath){
        String fileName = filePath.getFileName().toString();
        String parentPath = filePath.getParent().toString();
        boolean isDirectory = Files.isDirectory(filePath);

        return new MyFile(parentPath, fileName, isDirectory);
    }
}
