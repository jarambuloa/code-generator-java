@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.application.service;

import ${basePackage}.application.port.out.${entity.getName()}RepositoryPort;
import ${basePackage}.domain.model.${entity.getName()};
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class Create${entity.getName()}ServiceTest {

    @Mock
    private ${entity.getName()}RepositoryPort repository;

    @InjectMocks
    private Create${entity.getName()}Service service;

    @Test
    void should_create_${entity.getName().toLowerCase()}_when_valid_input() {
        ${entity.getName()} entity = new ${entity.getName()}(
@for (int i = 0; i < entity.getFields().size(); i++)
            null${i < entity.getFields().size() - 1 ? "," : ""}
@endfor
        );

        when(repository.save(any())).thenReturn(entity);

        ${entity.getName()} result = service.create(entity);

        assertThat(result).isNotNull();
        verify(repository).save(entity);
    }
}
