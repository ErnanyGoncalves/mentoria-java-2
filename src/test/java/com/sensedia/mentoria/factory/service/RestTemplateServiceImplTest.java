package com.sensedia.mentoria.factory.service;

import com.sensedia.mentoria.factory.dto.Area;
import com.sensedia.mentoria.factory.dto.Square;
import com.sensedia.mentoria.factory.request.CalculateAreaRequest;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockserver.model.JsonBody.json;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestPropertySource(properties = {"url.post.shape-area=http://localhost:8080/shape-area"})
public class RestTemplateServiceImplTest {

    @Autowired
    @Value("${url.post.shape-area}")
    private String apiUrl;


    @Test
    public void testPostRequest() {

        ClientAndServer mockServer = ClientAndServer.startClientAndServer(8080);
        Square geomShape = new Square();
        geomShape.setSide(5);
        CalculateAreaRequest reqBody = new CalculateAreaRequest(geomShape);

        try {
            // Configurar a resposta do servidor simulado
            Area expectedArea = new Area(25.0);
            mockServer.when(
                    HttpRequest.request("/shape-area")
                            .withMethod("POST")
                            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                            .withBody(json(reqBody))
            ).respond(
                    HttpResponse.response()
                            .withStatusCode(200)
                            .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                            .withBody(json(expectedArea))
            );

            // Criar um objeto RestTemplate
            RestTemplate restTemplate = new RestTemplate();

            // Criar os cabeçalhos da requisição
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Criar o objeto HttpEntity com os cabeçalhos e parâmetros
            HttpEntity<CalculateAreaRequest> requestEntity = new HttpEntity<>(reqBody, headers);

            // Enviar a requisição POST para o servidor simulado
            ResponseEntity<Area> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Area.class);

            // Verificar o código de status da resposta
            assertEquals(200, response.getStatusCodeValue());

            // Verificar se a solicitação POST foi feita para a URL correta
            URI requestUri = restTemplate.getUriTemplateHandler().expand(apiUrl);
            String requestUrl = requestUri.toString();
            assertEquals(requestUrl, "http://localhost:8080/shape-area"); // Verifique a URL esperada

            // Verificar os cabeçalhos da solicitação
            HttpHeaders requestHeaders = response.getHeaders();
            assertTrue(requestHeaders.containsKey(HttpHeaders.CONTENT_TYPE));
            assertEquals(MediaType.APPLICATION_JSON_VALUE, requestHeaders.getFirst(HttpHeaders.CONTENT_TYPE));

            // Verificar o conteúdo da resposta
            Area responseBody = response.getBody();
            assertEquals(expectedArea, responseBody);
        } finally {
            // Parar o servidor simulado após o teste
            mockServer.stop();
        }

    }
}
