package com.WCC.assignment.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostalCodeServiceTest {

    @Autowired
    private PostalCodeService postalCodeService;

    @Autowired
    private DistanceCalculator distanceCalculator;

    @Test
    void testCalculateDistance() {
        assertEquals(214.3, distanceCalculator.calculateDistance(52.4964133, 52.0189774, -1.7817039, 1.2699895), 1.0);
        assertEquals(193.6, distanceCalculator.calculateDistance(54.9677908, 53.4349803, -1.4844933, -2.8958012), 1.0);
    }

    @Test
    void testGetCoordinates() {
        String postalCode1 = "B34";
        String postalCode2 = "NE32";

        double[] coords1 = postalCodeService.getCoordinates(postalCode1);
        double[] coords2 = postalCodeService.getCoordinates(postalCode2);

        assertNotNull(coords1, "Coordinates should not be null");
        assertEquals(52.4964133, coords1[0], 0.0001, "Latitude should match");
        assertEquals(-1.7817039, coords1[1], 0.0001, "Longitude should match");

        assertNotNull(coords2, "Coordinates should not be null");
        assertEquals(54.9677908, coords2[0], 0.0001, "Latitude should match");
        assertEquals(-1.4844933, coords2[1], 0.0001, "Longitude should match");
    }
}