package com.provisionTechAdvisors.DeenDiscovery.controller.util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; // Required for JSON parsing
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
@Component
public class LocationInfoProvider {
    private static final String MAXMIND_API_URL = "https://geoip.maxmind.com/geoip/v2.1/city/";

    private final String apiKey;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public LocationInfoProvider(String apiKey) {
        this.apiKey = apiKey;
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public LocationInfo getLocationInfoByIPAddress(String ipAddress) {
        // Construct the URL with the IP address and API key
        String apiUrl = MAXMIND_API_URL + ipAddress;

        // Set up headers with your MaxMind API key
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        // Create an HTTP request entity with headers
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // Send an HTTP GET request to the MaxMind API
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, requestEntity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                // Parse the JSON response into a LocationInfo object
                LocationInfo locationInfo = objectMapper.readValue(response.getBody(), LocationInfo.class);
                return locationInfo;
            } catch (IOException e) {
                e.printStackTrace(); // Handle JSON parsing exception
            }
        }

        return null; // Return null in case of error or if location info is not found
    }
}
