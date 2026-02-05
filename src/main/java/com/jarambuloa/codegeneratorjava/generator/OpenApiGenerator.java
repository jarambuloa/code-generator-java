package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;
import com.jarambuloa.codegeneratorjava.writer.FileWriterService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class OpenApiGenerator {
  
  private final TemplateRenderer renderer;
  
  public OpenApiGenerator(TemplateRenderer renderer) {
    this.renderer = renderer;
  }
  
  public void generate(ProjectDefinition project, Path outputDir)
      throws IOException {
    
    Map<String, Object> model = Map.of(
        "project", project
    );
    
    FileWriterService.write(
        outputDir.resolve("generated/openapi.yaml"),
        renderer.render("openapi/openapi.jte", model)
    );
  }
}
