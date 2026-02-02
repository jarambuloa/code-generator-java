@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.adapters.in.rest.dto;

public class Create${entity.getName()}Request {

@for (var field : entity.getFields())
    private ${field.getType()} ${field.getName()};
@endfor

    public Create${entity.getName()}Request() {
    }

@for (var field : entity.getFields())
    public ${field.getType()} get${field.getName().substring(0,1).toUpperCase()}${field.getName().substring(1)}() {
        return ${field.getName()};
    }

    public void set${field.getName().substring(0,1).toUpperCase()}${field.getName().substring(1)}(${field.getType()} ${field.getName()}) {
        this.${field.getName()} = ${field.getName()};
    }
@endfor
}
