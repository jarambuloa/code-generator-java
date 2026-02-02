package com.jarambuloa.codegeneratorjava.template;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import gg.jte.resolve.ResourceCodeResolver;

import java.util.Map;

public class TemplateRenderer {
  
  private final TemplateEngine engine;
  
  public TemplateRenderer() {
    this.engine = TemplateEngine.create(
        new ResourceCodeResolver("templates"),
        ContentType.Plain
    );
  }
  
  public String render(String template, Map<String, Object> model) {
    StringOutput output = new StringOutput();
    engine.render(template, model, output);
    return output.toString();
  }
}
