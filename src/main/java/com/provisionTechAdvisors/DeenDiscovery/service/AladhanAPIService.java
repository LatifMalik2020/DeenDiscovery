package com.provisionTechAdvisors.DeenDiscovery.service;

import com.provisionTechAdvisors.DeenDiscovery.DTO.ApiResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AladhanAPIService {

    private static final String ALADHAN_API_URL = "http://api.aladhan.com/v1/";

    private final RestTemplate restTemplate;

    @Autowired
    public AladhanAPIService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ApiResponse getPrayerTimes(String city, String country) {
        String url = String.format("http://api.aladhan.com/v1/timingsByCity?city=%s&country=%s", city, country);
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
        return response.getBody();
    }
//    public String getPrayerTimes(double latitude, double longitude, String date, int method, int school) {
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            String apiUrl = ALADHAN_API_URL + "timings/" + date;
//            apiUrl += "?latitude=" + latitude;
//            apiUrl += "&longitude=" + longitude;
//            apiUrl += "&method=" + method;
//            apiUrl += "&school=" + school;
//
//            HttpGet httpGet = new HttpGet(apiUrl);
//            CloseableHttpResponse response = httpClient.execute(httpGet);
//
//            if (response.getStatusLine().getStatusCode() == 200) {
//                return EntityUtils.toString(response.getEntity());
//            } else {
//                // Handle error response
//                return null;
//            }
//        } catch (Exception e) {
//            // Handle exceptions
//            return null;
//        }
//    }
}
