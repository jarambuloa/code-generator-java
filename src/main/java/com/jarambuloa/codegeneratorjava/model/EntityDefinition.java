package com.jarambuloa.codegeneratorjava.model;

import java.util.List;

public class EntityDefinition {
  
  private String name;
  private String table;
  private String idType;
  private List<FieldDefinition> fields;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getTable() {
    return table;
  }
  
  public void setTable(String table) {
    this.table = table;
  }
  
  public String getIdType() {
    return idType;
  }
  
  public void setIdType(String idType) {
    this.idType = idType;
  }
  
  public List<FieldDefinition> getFields() {
    return fields;
  }
  
  public void setFields(List<FieldDefinition> fields) {
    this.fields = fields;
  }
}
