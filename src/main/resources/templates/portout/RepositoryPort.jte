@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.application.port.out;

import ${basePackage}.domain.model.${entity.getName()};

import java.util.Optional;

public interface ${entity.getName()}RepositoryPort {

    Optional<${entity.getName()}> findById(${entity.getIdType()} id);

    ${entity.getName()} save(${entity.getName()} entity);

    boolean existsById(${entity.getIdType()} id);

    void deleteById(${entity.getIdType()} id);
}
