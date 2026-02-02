@param String basePackage
@param String entityName
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.application.port.in;

import ${basePackage}.domain.model.${entityName};

public interface Create${entityName}UseCase {

    ${entityName} create(${entityName.toLowerCase()});
}
