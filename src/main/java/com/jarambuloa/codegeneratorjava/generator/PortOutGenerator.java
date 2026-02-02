package com.jarambuloa.codegeneratorjava.generator;

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
  
  public void generate(ProjectDefinition project, Path outputDir)
      throws IOException {
    
    var model = Map.of(
        "basePackage", project.getBasePackage(),
        "entity", project.getEntity()
    );
    
    String content = renderer.render(
        "portout/RepositoryPort.jte",
        model
    );
    
    Path file = outputDir.resolve(
        project.getBasePackage().replace(".", "/")
            + "/application/port/out/"
            + project.getEntity().getName()
            + "RepositoryPort.java"
    );
    
    FileWriterService.write(file, content);
  }
}
