package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.loader.YamlLoader;
import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApplicationGenerator {
  
  public static void main(String[] args) throws Exception {
    
    var url = ApplicationGenerator.class
        .getClassLoader()
        .getResource("templates/domain/Entity.jte");
    
    System.out.println("RESOURCE = " + url);
    
    
    Path input = Paths.get("src/main/resources/input/entity.yaml");
    //Path templates = Paths.get("src/main/resources/templates");
    Path output = Paths.get("generated-src");
    
    ProjectDefinition project = YamlLoader.load(input);
    
    //TemplateRenderer renderer = new TemplateRenderer(templates);
    TemplateRenderer renderer = new TemplateRenderer();
    DomainGenerator domainGenerator = new DomainGenerator(renderer);
    
    domainGenerator.generate(project, output);
    
    System.out.println("✔ Código generado correctamente");
  }
}
