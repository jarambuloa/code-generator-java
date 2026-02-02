@param String basePackage
@param com.jarambuloa.codegeneratorjava.model.EntityDefinition entity

package ${basePackage}.adapters.in.rest;

import ${basePackage}.adapters.in.rest.dto.Create${entity.getName()}Request;
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
class ${entity.getName()}ControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_create_${entity.getName().toLowerCase()}() throws Exception {
        Create${entity.getName()}Request request = new Create${entity.getName()}Request();

        mockMvc.perform(post("/${entity.getName().toLowerCase()}s")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
