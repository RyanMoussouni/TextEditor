package Files;

import java.util.List;

public record MyDirectory(String path, String name, List<IMyFile> subFiles) implements IMyFile {}