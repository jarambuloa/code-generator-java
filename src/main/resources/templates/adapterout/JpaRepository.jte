@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.adapters.out.persistence.jpa.repository;

import ${basePackage}.adapters.out.persistence.jpa.entity.${entity.getName()}JpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ${entity.getName()}JpaRepository
        extends JpaRepository<${entity.getName()}JpaEntity, ${entity.getIdType()}> {
}
