package main.Backend.IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//Wrapper around Java File implementation
public class MyFile implements IMyFile{
    private final File _f;

    public MyFile(String parentPath, String fileName){
        _f = new File(parentPath, fileName);
    }
    public MyFile(File f){this._f = f;}

    @Override
    public String getAbsolutePath() {
        return _f.getAbsolutePath();
    }

    @Override
    public String getParentPath() {
        return _f.getParent();
    }

    @Override
    public String getName() {
        return _f.getName();
    }

    @Override
    public boolean isTextFile() throws IOException {
        boolean isTextFile;
        var fileType = getFileType();

        if (fileType == null) {
            isTextFile = true;
        } else isTextFile = fileType.startsWith("text");
        return isTextFile;
    }

    private String getFileType() throws IOException {
        return Files.probeContentType(Path.of(getAbsolutePath()));
    }

    @Override
    public boolean isDirectory() {
        return _f.isDirectory();
    }

    @Override
    public boolean isAuthorizedFile() throws IOException {
        var isReadable = _f.canRead();

        return isReadable && isTextFile();
    }

    @Override
    public Reader getInputStreamReader() throws FileNotFoundException {
        var in = new FileInputStream(_f);
        return new InputStreamReader(in);
    }

    @Override
    public Writer getOutputStreamWriter() throws FileNotFoundException {
        var out = new FileOutputStream(_f);
        return new OutputStreamWriter(out);
    }

    @Override
    public List<IMyFile> getChildren() {
        var children = new ArrayList<IMyFile>();
        var childFiles = _f.listFiles();
        if (childFiles != null){
            for (File childFile: childFiles){
                children.add(new MyFile(childFile));
            }
        }
        return children;
    }

    @Override
    public String getText() throws IOException, FileNotFoundException{
        var inputStream = getInputStreamReader();
        var bufferedReader = new BufferedReader(inputStream);
        var lines = bufferedReader.lines().toList();

        return String.join("\n", lines);
    }
}
