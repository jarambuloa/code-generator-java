package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.model.EntityDefinition;
import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;
import com.jarambuloa.codegeneratorjava.writer.FileWriterService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class TestGenerator {
  
  private final TemplateRenderer renderer;
  
  public TestGenerator(TemplateRenderer renderer) {
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
    
    String base = project.getBasePackage().replace(".", "/");
    
    FileWriterService.write(
        outputDir.resolve(
            "src/test/java/" + base
                + "/application/service/Create"
                + entityName + "ServiceTest.java"
        ),
        renderer.render("tests/unit/CreateServiceTest.jte", model)
    );
    
    FileWriterService.write(
        outputDir.resolve(
            "src/test/java/" + base
                + "/adapters/in/rest/"
                + entityName + "ControllerIT.java"
        ),
        renderer.render("tests/integration/ControllerIT.jte", model)
    );
  }
}
