package main.Backend.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public interface IMyFile{
    String getAbsolutePath();
    String getParentPath();
    String getName();
    boolean isTextFile() throws IOException;
    boolean isDirectory();
    boolean isAuthorizedFile() throws IOException;
    Reader getInputStreamReader() throws FileNotFoundException;
    Writer getOutputStreamWriter() throws FileNotFoundException;
    List<IMyFile> getChildren();
    String getText() throws IOException, FileNotFoundException;
}