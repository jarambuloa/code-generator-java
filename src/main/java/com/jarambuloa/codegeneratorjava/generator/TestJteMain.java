package com.jarambuloa.codegeneratorjava.generator;

import com.jarambuloa.codegeneratorjava.template.TemplateRenderer;

import java.util.Map;

public class TestJteMain {
  
  public static void main(String[] args) {
    TemplateRenderer renderer = new TemplateRenderer();
    
    String result = renderer.render(
        "test/simple.jte",
        Map.of(
            "data", Map.of(
                "Usuario", "x",
                "Producto", "y"
            )
        )
    );
    
    System.out.println(result);
  }
}
