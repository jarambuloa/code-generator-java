@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.adapters.out.persistence.jpa;

import ${basePackage}.application.port.out.${entity.getName()}RepositoryPort;
import ${basePackage}.adapters.out.persistence.jpa.entity.${entity.getName()}JpaEntity;
import ${basePackage}.adapters.out.persistence.jpa.repository.${entity.getName()}JpaRepository;
import ${basePackage}.domain.model.${entity.getName()};

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ${entity.getName()}JpaAdapter implements ${entity.getName()}RepositoryPort {

    private final ${entity.getName()}JpaRepository repository;

    public ${entity.getName()}JpaAdapter(${entity.getName()}JpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<${entity.getName()}> findById(${entity.getIdType()} id) {
        return repository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public ${entity.getName()} save(${entity.getName()} entity) {
        ${entity.getName()}JpaEntity saved =
                repository.save(toEntity(entity));
        return toDomain(saved);
    }

    @Override
    public boolean existsById(${entity.getIdType()} id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(${entity.getIdType()} id) {
        repository.deleteById(id);
    }

    private ${entity.getName()}JpaEntity toEntity(${entity.getName()} domain) {
        return new ${entity.getName()}JpaEntity(
@for (int i = 0; i < entity.getFields().size(); i++)
            domain.get${entity.getFields().get(i).getName().substring(0,1).toUpperCase()}${entity.getFields().get(i).getName().substring(1)}()${i < entity.getFields().size() - 1 ? "," : ""}
@endfor
        );
    }

    private ${entity.getName()} toDomain(${entity.getName()}JpaEntity entity) {
        return new ${entity.getName()}(
@for (int i = 0; i < entity.getFields().size(); i++)
            entity.get${entity.getFields().get(i).getName().substring(0,1).toUpperCase()}${entity.getFields().get(i).getName().substring(1)}()${i < entity.getFields().size() - 1 ? "," : ""}
@endfor
        );
    }
}
