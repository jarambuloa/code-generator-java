package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.model.EntityDefinition;
import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;
import com.jarambuloa.codegeneratorjava.writer.FileWriterService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class AdapterInGenerator {
  
  private final TemplateRenderer renderer;
  
  public AdapterInGenerator(TemplateRenderer renderer) {
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
    
    String basePath = project.getBasePackage().replace(".", "/")
        + "/adapters/in/rest/";
    
    FileWriterService.write(
        outputDir.resolve(basePath + "dto/Create" + entityName + "Request.java"),
        renderer.render("adapterin/CreateRequest.jte", model)
    );
    
    FileWriterService.write(
        outputDir.resolve(basePath + entityName + "Controller.java"),
        renderer.render("adapterin/Controller.jte", model)
    );
  }
}
