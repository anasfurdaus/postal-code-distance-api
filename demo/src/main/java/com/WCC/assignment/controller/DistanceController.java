package com.WCC.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.WCC.assignment.service.DistanceCalculator;
import com.WCC.assignment.service.PostalCodeService;

import java.util.*;

@RestController
@RequestMapping("/distance")
public class DistanceController {
    
    @Autowired
    private PostalCodeService postalCodeService;
    
    @Autowired
    private DistanceCalculator distanceCalculator;

    @GetMapping("/{postalCode1}/{postalCode2}")
    public Map<String, Object> getDistance(@PathVariable String postalCode1, @PathVariable String postalCode2){
        System.out.println("Received request for postal codes: " + postalCode1 + ", " + postalCode2); // Debug line
        double[] coords1 = postalCodeService.getCoordinates(postalCode1);
        double[] coords2 = postalCodeService.getCoordinates(postalCode2);

        if (coords1 == null || coords2 == null) {
            return Map.of("error", "Invalid postal code(s)");
        }

        double distance = distanceCalculator.calculateDistance(coords1[0], coords2[0], coords1[1], coords2[1]);

        Map<String, Object> postalCode1Map = new LinkedHashMap<>();
        postalCode1Map.put("postalCode", postalCode1);
        postalCode1Map.put("latitude", coords1[0]);
        postalCode1Map.put("longitude", coords1[1]);

        Map<String, Object> postalCode2Map = new LinkedHashMap<>();
        postalCode2Map.put("postalCode", postalCode2);
        postalCode2Map.put("latitude", coords2[0]);
        postalCode2Map.put("longitude", coords2[1]);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("postalCode1", postalCode1Map);
        response.put("postalCode2", postalCode2Map);
        response.put("distance", distance);
        response.put("unit", "km");

        return response;
    }
}