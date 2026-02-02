@param String basePackage
@param String entityName
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.adapters.in.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ${entityName}ControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_create_${entityName.toLowerCase()}() throws Exception {

        var request = new Create${entityName}Request(
@for (int i = 0; i < entity.getFields().size(); i++)
            null${i < entity.getFields().size() - 1 ? "," : ""}
@endfor
        );

        mockMvc.perform(
                post("/${entityName.toLowerCase()}s")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isCreated());
    }
}
