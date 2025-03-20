package com.WCC.assignment.service;

import org.springframework.stereotype.Service;

@Service
public class DistanceCalculator {
    private static final double EARTH_RADIUS = 6371; //Radius in km
    
    public double calculateDistance(double lat1, double lat2, double lon1, double lon2){

        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double a = haversine(lat1Rad,lat2Rad) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * haversine(lon1Rad, lon2Rad);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;

    }

    private double haversine(double angle1, double angle2){
        return Math.pow(Math.sin((angle1-angle2) / 2), 2);
    }
    
}
