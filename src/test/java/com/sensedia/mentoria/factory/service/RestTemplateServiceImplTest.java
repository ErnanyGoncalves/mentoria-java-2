package com.sensedia.mentoria.factory.service;

import com.sensedia.mentoria.factory.dto.Area;
import com.sensedia.mentoria.factory.dto.Square;
import com.sensedia.mentoria.factory.request.CalculateAreaRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;




@ExtendWith(MockitoExtension.class)
public class RestTemplateServiceImplTest {


    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ResponseEntity<Area> responseEntity;

    @InjectMocks
    private RestTemplateServiceImpl restTemplateService;



    @Test
    public void testPostRequest() {
        ReflectionTestUtils.setField(restTemplateService, "apiUrl", "http://localhost:8080");
        // Crie um objeto CalculateAreaRequest fictício para o teste
        Square geomShape = new Square();
        geomShape.setSide(5);
        CalculateAreaRequest reqBody = new CalculateAreaRequest(geomShape);

        // Crie um objeto Area fictício para simular a resposta
        Area expectedArea = new Area(25);

        // Simule o comportamento do restTemplate.exchange()
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(Area.class)
        )).thenReturn(responseEntity);

        // Simule o comportamento do responseEntity.getBody()
        when(responseEntity.getBody()).thenReturn(expectedArea);

        // Faça a chamada ao método makeRequest()
        Area resultArea = restTemplateService.makeRequest(reqBody);

        // Verifique se o resultado é o esperado
        assertEquals(expectedArea, resultArea);

    }
}
