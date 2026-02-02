package com.jarambuloa.codegeneratorjava.generator;

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
  
  public void generate(ProjectDefinition project, Path outputDir) throws IOException {
    
    var model = Map.of(
        "basePackage", project.getBasePackage(),
        "entity", project.getEntity()
    );
    
    // Port IN
    String useCase = renderer.render(
        "usecase/CreateUseCase.jte",
        model
    );
    
    Path useCaseFile = outputDir.resolve(
        project.getBasePackage().replace(".", "/")
            + "/application/port/in/Create"
            + project.getEntity().getName()
            + "UseCase.java"
    );
    
    FileWriterService.write(useCaseFile, useCase);
    
    // Service implementation
    String service = renderer.render(
        "usecase/CreateService.jte",
        model
    );
    
    Path serviceFile = outputDir.resolve(
        project.getBasePackage().replace(".", "/")
            + "/application/service/Create"
            + project.getEntity().getName()
            + "Service.java"
    );
    
    FileWriterService.write(serviceFile, service);
  }
}
