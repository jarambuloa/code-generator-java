package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.model.EntityDefinition;
import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;
import com.jarambuloa.codegeneratorjava.writer.FileWriterService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class AdapterOutGenerator {
  
  private final TemplateRenderer renderer;
  
  public AdapterOutGenerator(TemplateRenderer renderer) {
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
        + "/adapters/out/persistence/jpa/";
    
    FileWriterService.write(
        outputDir.resolve(basePath + "entity/" + entityName + "JpaEntity.java"),
        renderer.render("adapterout/JpaEntity.jte", model)
    );
    
    FileWriterService.write(
        outputDir.resolve(basePath + "repository/" + entityName + "JpaRepository.java"),
        renderer.render("adapterout/JpaRepository.jte", model)
    );
    
    FileWriterService.write(
        outputDir.resolve(basePath + entityName + "JpaAdapter.java"),
        renderer.render("adapterout/JpaAdapter.jte", model)
    );
  }
}
