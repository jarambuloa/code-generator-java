package com.jarambuloa.codegeneratorjava.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriterService {
  
  public static void write(Path path, String content) throws IOException {
    Files.createDirectories(path.getParent());
    Files.writeString(
        path,
        content,
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING
    );
  }
}

