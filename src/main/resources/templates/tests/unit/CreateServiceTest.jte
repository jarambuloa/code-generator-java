@param String basePackage
@param String entityName
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.application.service;

import ${basePackage}.application.port.out.${entityName}RepositoryPort;
import ${basePackage}.domain.model.${entityName};

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class Create${entityName}ServiceTest {

    @Mock
    private ${entityName}RepositoryPort repository;

    @InjectMocks
    private Create${entityName}Service service;

    @Test
    void should_create_${entityName.toLowerCase()}_when_valid_input() {

        ${entityName} entity = new ${entityName}(
@for (int i = 0; i < entity.getFields().size(); i++)
            null${i < entity.getFields().size() - 1 ? "," : ""}
@endfor
        );

        when(repository.save(any())).thenReturn(entity);

        ${entityName} result = service.create(entity);

        assertThat(result).isNotNull();
        verify(repository).save(entity);
    }
}
