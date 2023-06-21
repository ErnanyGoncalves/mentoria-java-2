package com.sensedia.mentoria.factory.service;

import com.sensedia.mentoria.factory.dto.Area;
import com.sensedia.mentoria.factory.dto.Square;
import com.sensedia.mentoria.factory.request.CalculateAreaRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class WebClientServiceImplTest {

    @Mock
    WebClient webClient;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpecMock;

    @Mock
    private WebClient.RequestBodySpec requestBodySpecMock;

    @Mock
    private WebClient.ResponseSpec responseSpecMock;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    Mono<Area> areaMock = Mockito.mock(Mono.class);

    @InjectMocks
    private WebClientServiceImpl webClientService;


    @Test
    public void testPostRequest() {
        ReflectionTestUtils.setField(webClientService, "apiUrl", "http://localhost:8080");
        Square geomShape = new Square();
        geomShape.setSide(5);
        CalculateAreaRequest reqBody = new CalculateAreaRequest(geomShape);
        Area a = new Area(5);

        when(webClient.post()).thenReturn(requestBodyUriSpecMock);
        when(requestBodyUriSpecMock.uri(anyString())).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.contentType(any())).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.body(any())).thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(
                ArgumentMatchers.<Class<Area>>notNull())).thenReturn(areaMock);
        when(areaMock.block()).thenReturn(a);

        Area areaResponse = webClientService.makeRequest(reqBody);

        assertNotNull(areaResponse);
        assertEquals(5, areaResponse.getArea());

    }


}
