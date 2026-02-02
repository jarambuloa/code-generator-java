@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.domain.model;

public class ${entity.getName()} {

@for (var field : entity.getFields())
    private ${field.getType()} ${field.getName()};
@endfor

    public ${entity.getName()}(
@for (int i = 0; i < entity.getFields().size(); i++)
        ${entity.getFields().get(i).getType()} ${entity.getFields().get(i).getName()}${i < entity.getFields().size() - 1 ? "," : ""}
@endfor
    ) {
@for (var field : entity.getFields())
        this.${field.getName()} = ${field.getName()};
@endfor
    }
}
