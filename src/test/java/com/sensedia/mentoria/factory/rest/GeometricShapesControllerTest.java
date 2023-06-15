package com.sensedia.mentoria.factory.rest;

import com.sensedia.mentoria.factory.dto.Area;
import com.sensedia.mentoria.factory.request.CalculateAreaRequest;
import com.sensedia.mentoria.factory.service.PostRequestService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(GeometricShapesController.class)
public class GeometricShapesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("webClient")
    private PostRequestService service;

    @Test
    public void testCalculateArea() throws Exception {
        // Mock do objeto de resposta
        Area area = new Area( 25.0);

        Mockito.when(service.makeRequest(Mockito.any(CalculateAreaRequest.class))).thenReturn(area);

        // Corpo da requisição
        String requestBody = "{\"shape\":{\"type\":\"SQUARE\",\"side\":5.0}}";

        // Executar a requisição POST e verificar o resultado
        mockMvc.perform(MockMvcRequestBuilders.post("/mentoria-java-2/shape-area")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.area").value(25.0));
    }
}