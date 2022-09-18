package main.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//this class is becoming a "wrapper" (?) around the File Class; is it an anti-pattern?
public class MyFile implements IMyFile{
    private File f;

    public MyFile(String parentPath, String fileName){
        f = new File(parentPath, fileName);
    }

    @Override
    public String getAbsolutePath() {
        return f.getAbsolutePath();
    }

    @Override
    public String getParentPath() {
        return f.getParent();
    }

    @Override
    public String getName() {
        return f.getName();
    }

    @Override
    public boolean isTextFile() throws IOException {
        boolean isTextFile;
        var fileType = getFileType();

        if (fileType == null) {
            isTextFile = true;
        } else if (fileType.startsWith("text")) {
            isTextFile = false;
        } else {
            isTextFile = true;
        }
        return isTextFile;
    }

    private String getFileType() throws IOException {
        return Files.probeContentType(Path.of(getAbsolutePath()));
    }

    @Override
    public boolean isDirectory() {
        return f.isDirectory();
    }

    @Override
    public boolean isAuthorizedFile() {
        return f.canRead();
    }
}
