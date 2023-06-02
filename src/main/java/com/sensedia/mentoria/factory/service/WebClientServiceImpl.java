package com.sensedia.mentoria.factory.service;

import com.sensedia.mentoria.factory.dto.Area;
import com.sensedia.mentoria.factory.request.CalculateAreaRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service("webClient")
public class WebClientServiceImpl implements PostRequestService {
    WebClient webClient = WebClient.create();
    String apiUrl = "http://localhost:8080/mentoria-java/example/factory";
    @Override
    public Area makeRequest(CalculateAreaRequest reqBody) {
        // Enviar a solicitação POST
        return webClient.post()
                .uri(apiUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(reqBody))
                .retrieve()
                .bodyToMono(Area.class)
                .block();
    }
}
