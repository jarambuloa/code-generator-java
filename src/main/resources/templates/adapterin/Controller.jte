@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.adapters.in.rest;

import ${basePackage}.application.port.in.Create${entity.getName()}UseCase;
import ${basePackage}.adapters.in.rest.dto.Create${entity.getName()}Request;
import ${basePackage}.domain.model.${entity.getName()};

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/${entity.getName().toLowerCase()}s")
public class ${entity.getName()}Controller {

    private final Create${entity.getName()}UseCase createUseCase;

    public ${entity.getName()}Controller(Create${entity.getName()}UseCase createUseCase) {
        this.createUseCase = createUseCase;
    }

    @PostMapping
    public ResponseEntity<${entity.getName()}> create(
            @RequestBody Create${entity.getName()}Request request) {

        ${entity.getName()} created = createUseCase.create(
                new ${entity.getName()}(
@for (int i = 0; i < entity.getFields().size(); i++)
                    request.get${entity.getFields().get(i).getName().substring(0,1).toUpperCase()}${entity.getFields().get(i).getName().substring(1)}()${i < entity.getFields().size() - 1 ? "," : ""}
@endfor
                )
        );

        return ResponseEntity.ok(created);
    }
}
