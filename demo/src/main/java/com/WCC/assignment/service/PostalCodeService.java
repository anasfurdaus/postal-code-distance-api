package com.WCC.assignment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PostalCodeService {
    private final Map<String, double[]> postalCodeMap = new HashMap<>();

    public PostalCodeService(){
        loadPostalCodes("postcodes.csv");
    }

    private void loadPostalCodes(String filename){
        System.out.println("Loading files..");
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length<4) continue;
                String postalCode = parts[1].trim();
                double lat = Double.parseDouble(parts[2]);
                double lon = Double.parseDouble(parts[3]);
                postalCodeMap.put(postalCode, new double[]{lat,lon});
            }
            System.out.println("Loaded " + postalCodeMap.size() + " postal codes");
        } catch (IOException | NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public double[] getCoordinates(String postalCode){
        return postalCodeMap.get(postalCode);
    }
}
