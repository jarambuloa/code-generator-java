package com.jarambuloa.codegeneratorjava.model;

import java.util.Map;

public class ProjectDefinition {
  
  @NotBlank(message = "basePackage es obligatorio")
  private String basePackage;
  
  @NotBlank(message = "serviceName es obligatorio")
  private String serviceName;
  
  @NotEmpty(message = "Debe existir al menos una entidad")
  @Valid
  private Map<String, EntityDefinition> entities;
  
  // --- getters ---
  public String getBasePackage() {
    return basePackage;
  }
  
  public String getServiceName() {
    return serviceName;
  }
  
  public Map<String, EntityDefinition> getEntities() {
    return entities;
  }
  
  // --- setters (OBLIGATORIOS para SnakeYAML) ---
  public void setBasePackage(String basePackage) {
    this.basePackage = basePackage;
  }
  
  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }
  
  public void setEntities(Map<String, EntityDefinition> entities) {
    this.entities = entities;
  }
}
