@param String basePackage
@param String entityName
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.adapters.in.rest;

import ${basePackage}.application.port.in.Create${entityName}UseCase;
import ${basePackage}.adapters.in.rest.dto.Create${entityName}Request;
import ${basePackage}.domain.model.${entityName};

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/${entityName.toLowerCase()}s")
public class ${entityName}Controller {

    private final Create${entityName}UseCase createUseCase;

    public ${entityName}Controller(Create${entityName}UseCase createUseCase) {
        this.createUseCase = createUseCase;
    }

    @PostMapping
    public ResponseEntity<${entityName}> create(
            @RequestBody Create${entityName}Request request) {

        ${entityName} created = createUseCase.create(
                new ${entityName}(
@for (int i = 0; i < entity.getFields().size(); i++)
                    request.get${entity.getFields().get(i).getName().substring(0,1).toUpperCase()}${entity.getFields().get(i).getName().substring(1)}()${i < entity.getFields().size() - 1 ? "," : ""}
@endfor
                )
        );

        return ResponseEntity.status(201).body(created);
    }
}
