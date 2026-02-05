package com.jarambuloa.codegeneratorjava.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class EntityDefinition {
  
  private String name;
  
  @NotBlank(message = "table es obligatorio")
  private String table;
  
  @NotBlank(message = "idType es obligatorio")
  private String idType;
  
  @NotEmpty(message = "La entidad debe tener al menos un field")
  @Valid
  private List<FieldDefinition> fields;
  
  // 🔹 GETTERS
  public String getName() {
    return name;
  }
  
  public String getTable() {
    return table;
  }
  
  public String getIdType() {
    return idType;
  }
  
  public List<FieldDefinition> getFields() {
    return fields;
  }
  
  // 🔹 SETTERS (🔥 OBLIGATORIOS PARA YAML)
  public void setName(String name) {
    this.name = name;
  }
  
  public void setTable(String table) {
    this.table = table;
  }
  
  public void setIdType(String idType) {
    this.idType = idType;
  }
  
  public void setFields(List<FieldDefinition> fields) {
    this.fields = fields;
  }
  
  // 🔹 LÓGICA DE DOMINIO
  public List<FieldDefinition> getRequiredFields() {
    return fields.stream()
        .filter(FieldDefinition::isRequired)
        .toList();
  }
}
