package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.loader.YamlLoader;
import com.jarambuloa.codegeneratorjava.model.EntityDefinition;
import com.jarambuloa.codegeneratorjava.model.ProjectDefinition;
import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;
import com.jarambuloa.codegeneratorjava.validation.DslValidator;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApplicationGenerator {
  
  public static void main(String[] args) throws Exception {
    
    Path input = Paths.get("src/main/resources/input/entity.yaml");
    Path output = Paths.get("build");
    
    // 1️⃣ Cargar DSL
    ProjectDefinition project = YamlLoader.load(input);
    
    // 2️⃣ Validar DSL
    DslValidator.validate(project);
    
    // 🔧 Normalizar entidades: inyectar name desde la key
    project.getEntities().forEach((key, entity) -> {
      if (entity.getName() == null || entity.getName().isBlank()) {
        entity.setName(key);
      }
    });
    
    
    
    // 3️⃣ Infra común
    TemplateRenderer renderer = new TemplateRenderer();
    
    // 🔥 4️⃣ INSTANCIAR AQUÍ (UNA SOLA VEZ)
    OpenApiGenerator openApiGenerator = new OpenApiGenerator(renderer);
    
    DomainGenerator domainGenerator = new DomainGenerator(renderer);
    PortOutGenerator portOutGenerator = new PortOutGenerator(renderer);
    UseCaseGenerator useCaseGenerator = new UseCaseGenerator(renderer);
    AdapterOutGenerator adapterOutGenerator = new AdapterOutGenerator(renderer);
    AdapterInGenerator adapterInGenerator = new AdapterInGenerator(renderer);
    TestGenerator testGenerator = new TestGenerator(renderer);
    
    // 5️⃣ Generación multi-entidad
    for (var entry : project.getEntities().entrySet()) {
      String entityName = entry.getKey();
      var entity = entry.getValue();
      
      domainGenerator.generate(project, entityName, entity, output);
      portOutGenerator.generate(project, entityName, entity, output);
      useCaseGenerator.generate(project, entityName, entity, output);
      adapterOutGenerator.generate(project, entityName, entity, output);
      adapterInGenerator.generate(project, entityName, entity, output);
      testGenerator.generate(project, entityName, entity, output);
    }
    
    project.getEntities().forEach((k, v) -> {
      System.out.println("KEY = " + k);
      System.out.println("ENTITY.NAME = " + v.getName());
    });
    
    // 🔥 6️⃣ OPENAPI (UNA VEZ POR PROYECTO)
    openApiGenerator.generate(project, output);
    
    System.out.println("✔ Código generado correctamente");
  }
}
