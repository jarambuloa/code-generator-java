@param String basePackage
@param String entityName
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.application.service;

import ${basePackage}.application.port.in.Create${entityName}UseCase;
import ${basePackage}.application.port.out.${entityName}RepositoryPort;
import ${basePackage}.domain.model.${entityName};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Create${entityName}Service implements Create${entityName}UseCase {

    private final ${entityName}RepositoryPort repository;

    public Create${entityName}Service(${entityName}RepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ${entityName} create(${entityName.toLowerCase()}) {
        return repository.save(${entityName.toLowerCase()});
    }
}
