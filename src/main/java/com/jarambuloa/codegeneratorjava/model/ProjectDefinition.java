package com.jarambuloa.codegeneratorjava.model;

import java.util.Map;

public class ProjectDefinition {
  
  private String basePackage;
  private String serviceName;
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
