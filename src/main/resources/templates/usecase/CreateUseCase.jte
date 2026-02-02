@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.application.port.in;

import ${basePackage}.domain.model.${entity.getName()};

public interface Create${entity.getName()}UseCase {

    ${entity.getName()} create(${entity.getName()} ${entity.getName().toLowerCase()});
}
