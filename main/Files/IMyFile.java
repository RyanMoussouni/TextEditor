package main.Files;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public interface IMyFile{
    String getAbsolutePath();
    String getParentPath();
    String getName();
    boolean isTextFile() throws IOException;
    boolean isDirectory();
    boolean isAuthorizedFile();
    Reader getInputStreamReader();
    Writer getOutputStreamWriter();
}