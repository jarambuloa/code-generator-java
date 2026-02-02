package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.loader.YamlLoader;
import com.jarambuloa.codegeneratorjava.model.EntityDefinition;
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
    Path output = Paths.get("generated-src");
    
    ProjectDefinition project = YamlLoader.load(input);
    
    TemplateRenderer renderer = new TemplateRenderer();
    
    // 1️⃣ Domain
    //new DomainGenerator(renderer).generate(project, output);
    
    // ✅ Instancias reales
        DomainGenerator domainGenerator = new DomainGenerator(renderer);
        PortOutGenerator portOutGenerator = new PortOutGenerator(renderer);
        UseCaseGenerator useCaseGenerator = new UseCaseGenerator(renderer);
        AdapterOutGenerator adapterOutGenerator = new AdapterOutGenerator(renderer);
        AdapterInGenerator adapterInGenerator = new AdapterInGenerator(renderer);
        TestGenerator testGenerator = new TestGenerator(renderer);

        // ✅ Loop multi-entidad
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
    
    
    System.out.println("✔ Código generado correctamente");
  }
}
