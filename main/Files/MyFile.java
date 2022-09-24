package main.Files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//this class is becoming a "wrapper" (?) around the File Class; is it an anti-pattern?
public class MyFile implements IMyFile{
    private File f;

    public MyFile(String parentPath, String fileName){
        f = new File(parentPath, fileName);
    }
    public MyFile(File f){this.f = f;}

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

    @Override
    public Reader getInputStreamReader() throws FileNotFoundException {
        var in = new FileInputStream(f);
        return new InputStreamReader(in);
    }

    @Override
    public Writer getOutputStreamWriter() throws FileNotFoundException {
        var out = new FileOutputStream(f);
        return new OutputStreamWriter(out);
    }

    @Override
    public List<IMyFile> getChildren() {
        var children = new ArrayList<IMyFile>();
        var childFiles = f.listFiles();
        if (childFiles != null){
            for (File childFile: childFiles){
                children.add(new MyFile(childFile));
            }
        }
        return children;
    }
}
