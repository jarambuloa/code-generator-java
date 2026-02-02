package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.model.EntityDefinition;
import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;
import com.jarambuloa.codegeneratorjava.writer.FileWriterService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class UseCaseGenerator {
  
  private final TemplateRenderer renderer;
  
  public UseCaseGenerator(TemplateRenderer renderer) {
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
    
    // Port IN
    FileWriterService.write(
        outputDir.resolve(
            project.getBasePackage().replace(".", "/")
                + "/application/port/in/Create"
                + entityName
                + "UseCase.java"
        ),
        renderer.render("usecase/CreateUseCase.jte", model)
    );
    
    // Service
    FileWriterService.write(
        outputDir.resolve(
            project.getBasePackage().replace(".", "/")
                + "/application/service/Create"
                + entityName
                + "Service.java"
        ),
        renderer.render("usecase/CreateService.jte", model)
    );
  }
}