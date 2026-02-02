package com.jarambuloa.codegeneratorjava.generator;

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
  
  public void generate(ProjectDefinition project, Path outputDir) throws IOException {
    
    var model = Map.of(
        "basePackage", project.getBasePackage(),
        "entity", project.getEntity()
    );
    
    String basePath = project.getBasePackage().replace(".", "/")
        + "/adapters/out/persistence/jpa/";
    
    // JPA Entity
    FileWriterService.write(
        outputDir.resolve(basePath + "entity/" + project.getEntity().getName() + "JpaEntity.java"),
        renderer.render("adapterout/JpaEntity.jte", model)
    );
    
    // JPA Repository
    FileWriterService.write(
        outputDir.resolve(basePath + "repository/" + project.getEntity().getName() + "JpaRepository.java"),
        renderer.render("adapterout/JpaRepository.jte", model)
    );
    
    // Adapter
    FileWriterService.write(
        outputDir.resolve(basePath + project.getEntity().getName() + "JpaAdapter.java"),
        renderer.render("adapterout/JpaAdapter.jte", model)
    );
  }
}
