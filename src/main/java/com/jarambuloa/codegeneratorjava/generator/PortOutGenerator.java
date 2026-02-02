package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.model.EntityDefinition;
import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;
import com.jarambuloa.codegeneratorjava.writer.FileWriterService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class PortOutGenerator {
  
  private final TemplateRenderer renderer;
  
  public PortOutGenerator(TemplateRenderer renderer) {
    this.renderer = renderer;
  }
  
  public void generate(
      ProjectDefinition project,
      String entityName,
      EntityDefinition entity,
      Path outputDir
  ) throws IOException {
    
    var model = Map.of(
        "basePackage", project.getBasePackage(),
        "entityName", entityName,
        "entity", entity
    );
    
    Path file = outputDir.resolve(
        project.getBasePackage().replace(".", "/")
            + "/application/port/out/"
            + entityName
            + "RepositoryPort.java"
    );
    
    FileWriterService.write(
        file,
        renderer.render("portout/RepositoryPort.jte", model)
    );
  }
}
