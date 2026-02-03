@param String basePackage
@param String entityName

package ${basePackage}.adapters.in.rest.api;

import ${basePackage}.adapters.in.rest.dto.Create${entityName}Request;
import ${basePackage}.domain.model.${entityName};

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("${basePackage}")
public interface ${entityName}Api {

    @PostMapping("/${entityName.toLowerCase()}s")
    ResponseEntity<${entityName}> create${entityName}(
            @RequestBody Create${entityName}Request request
    );
}
