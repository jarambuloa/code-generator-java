package com.jarambuloa.codegeneratorjava.model;

import jakarta.validation.constraints.NotBlank;

public class FieldDefinition {
  
  @NotBlank(message = "El nombre del field es obligatorio")
  private String name;
  
  @NotBlank(message = "El tipo del field es obligatorio")
  private String type;
  
  private boolean required;
  
  public String getName() {
    return name;
  }
  
  public String getType() {
    return type;
  }
  
  public boolean isRequired() {
    return required;
  }
  
  // 🔥 SETTERS
  public void setName(String name) {
    this.name = name;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public void setRequired(boolean required) {
    this.required = required;
  }
}
