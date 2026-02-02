package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;
import com.jarambuloa.codegeneratorjava.writer.FileWriterService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class DomainGenerator {
  
  private final TemplateRenderer renderer;
  
  public DomainGenerator(TemplateRenderer renderer) {
    this.renderer = renderer;
  }
  
  public void generate(ProjectDefinition project, Path outputDir)
      throws IOException {
    
    Map<String, Object> model = Map.of(
        "basePackage", project.getBasePackage(),
        "entity", project.getEntity()
    );
    
    String content = renderer.render(
        "domain/Entity.jte",
        model
    );
    
    Path file = outputDir.resolve(
        project.getBasePackage().replace(".", "/")
            + "/domain/model/"
            + project.getEntity().getName()
            + ".java"
    );
    
    FileWriterService.write(file, content);
  }
}

