package com.jarambuloa.codegeneratorjava.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterService {
  
  private static final String START = "// >>> CUSTOM CODE START";
  private static final String END   = "// >>> CUSTOM CODE END";
  
  public static void write(Path path, String newContent) throws IOException {
    
    Files.createDirectories(path.getParent());
    
    if (!Files.exists(path)) {
      Files.writeString(path, newContent);
      return;
    }
    
    String oldContent = Files.readString(path);
    
    if (!oldContent.contains(START) || !oldContent.contains(END)) {
      // Archivo 100% generado → overwrite
      Files.writeString(path, newContent);
      return;
    }
    
    String preserved = extract(oldContent);
    String merged = inject(newContent, preserved);
    
    Files.writeString(path, merged);
  }
  
  private static String extract(String content) {
    return content.substring(
        content.indexOf(START),
        content.indexOf(END) + END.length()
    );
  }
  
  private static String inject(String content, String preserved) {
    return content.replaceFirst(
        START + "[\\s\\S]*?" + END,
        preserved
    );
  }
}
