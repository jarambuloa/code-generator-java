package com.jarambuloa.codegeneratorjava.generator;

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
  
  public void generate(ProjectDefinition project, Path outputDir) throws IOException {
    
    var model = Map.of(
        "basePackage", project.getBasePackage(),
        "entity", project.getEntity()
    );
    
    String testBase = project.getBasePackage().replace(".", "/");
    
    // Unit test
    FileWriterService.write(
        outputDir.resolve(
            "src/test/java/" + testBase + "/application/service/Create"
                + project.getEntity().getName() + "ServiceTest.java"
        ),
        renderer.render("tests/unit/CreateServiceTest.jte", model)
    );
    
    // Integration test
    FileWriterService.write(
        outputDir.resolve(
            "src/test/java/" + testBase + "/adapters/in/rest/"
                + project.getEntity().getName() + "ControllerIT.java"
        ),
        renderer.render("tests/integration/ControllerIT.jte", model)
    );
  }
}
