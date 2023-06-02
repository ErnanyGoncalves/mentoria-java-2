package com.sensedia.mentoria.factory.rest;

import com.sensedia.mentoria.factory.dto.Area;
import com.sensedia.mentoria.factory.dto.GeometricShapes;
import com.sensedia.mentoria.factory.request.CalculateAreaRequest;
import com.sensedia.mentoria.factory.service.PostRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mentoria-java-2/shape-area")
public class GeometricShapesController {
    @Autowired
    @Qualifier("webClient")
    PostRequestService service;
    @PostMapping
    public ResponseEntity<Area> calculateArea(@RequestBody CalculateAreaRequest calculateAreaRequest) {

        return ResponseEntity.ok(service.makeRequest(calculateAreaRequest));
    }

}
