package com.jarambuloa.codegeneratorjava.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

public class DslValidator {
  
  private static final Validator validator;
  
  static {
    ValidatorFactory factory = Validation.byDefaultProvider()
        .configure()
        .messageInterpolator(new ParameterMessageInterpolator())
        .buildValidatorFactory();
    
    validator = factory.getValidator();
  }
  
  public static <T> void validate(T object) {
    
    Set<ConstraintViolation<T>> violations = validator.validate(object);
    
    if (!violations.isEmpty()) {
      StringBuilder sb = new StringBuilder("\n❌ Errores en el DSL:\n\n");
      
      for (ConstraintViolation<T> v : violations) {
        sb.append(" - ")
            .append(v.getPropertyPath())
            .append(": ")
            .append(v.getMessage())
            .append("\n");
      }
      
      throw new IllegalStateException(sb.toString());
    }
  }
}
