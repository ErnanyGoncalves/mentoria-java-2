package com.sensedia.mentoria.factory.service;

import com.sensedia.mentoria.factory.dto.Area;
import com.sensedia.mentoria.factory.dto.GeometricShapes;
import com.sensedia.mentoria.factory.request.CalculateAreaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface PostRequestService {
    public Area makeRequest(CalculateAreaRequest reqBody);
}
