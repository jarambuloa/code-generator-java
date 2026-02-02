package com.jarambuloa.codegeneratorjava.model;

public class ProjectDefinition {
  
  private String basePackage;
  private EntityDefinition entity;
  
  public String getBasePackage() {
    return basePackage;
  }
  
  public void setBasePackage(String basePackage) {
    this.basePackage = basePackage;
  }
  
  public EntityDefinition getEntity() {
    return entity;
  }
  
  public void setEntity(EntityDefinition entity) {
    this.entity = entity;
  }
}
