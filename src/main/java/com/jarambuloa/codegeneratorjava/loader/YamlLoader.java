package com.jarambuloa.codegeneratorjava.loader;

import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.LoaderOptions;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class YamlLoader {
  
  public static ProjectDefinition load(Path path) throws Exception {
    
    LoaderOptions options = new LoaderOptions();
    Constructor constructor = new Constructor(ProjectDefinition.class, options);
    Yaml yaml = new Yaml(constructor);
    
    try (InputStream in = Files.newInputStream(path)) {
      return yaml.load(in);
    }
  }
}
