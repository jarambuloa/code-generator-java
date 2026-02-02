@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.application.service;

import ${basePackage}.application.port.in.Create${entity.getName()}UseCase;
import ${basePackage}.application.port.out.${entity.getName()}RepositoryPort;
import ${basePackage}.domain.model.${entity.getName()};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Create${entity.getName()}Service implements Create${entity.getName()}UseCase {

    private final ${entity.getName()}RepositoryPort repository;

    public Create${entity.getName()}Service(${entity.getName()}RepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ${entity.getName()} create(${entity.getName()} ${entity.getName().toLowerCase()}) {
        return repository.save(${entity.getName().toLowerCase()});
    }
}
