package com.sensedia.mentoria.factory.service;
import com.sensedia.mentoria.factory.dto.Area;
import com.sensedia.mentoria.factory.dto.GeometricShapes;
import com.sensedia.mentoria.factory.request.CalculateAreaRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateServiceImpl implements PostRequestService{
    RestTemplate restTemplate = new RestTemplate();
    String apiUrl = "http://localhost:8080/mentoria-java/example/factory";


    @Override
    public Area makeRequest(CalculateAreaRequest reqBody) {
        // Criar o objeto de cabeçalhos
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Criar a entidade HTTP com cabeçalhos e corpo
        HttpEntity<CalculateAreaRequest> requestEntity = new HttpEntity<>(reqBody, headers);

        // Enviar a solicitação POST
        ResponseEntity<Area> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Area.class);
        return response.getBody();
    }
}
