package main.Files;

//TODO: [Design] this should be a class (methods: getParentPath, getFileExtension, isReadableFile, getAbsolutePath, isDirectory, ...)
public record MyFile(String parentPath, String name, boolean isDirectory){}
