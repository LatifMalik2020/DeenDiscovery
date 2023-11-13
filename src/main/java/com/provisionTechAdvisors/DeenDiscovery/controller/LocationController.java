package com.provisionTechAdvisors.DeenDiscovery.controller;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.AsnResponse;
import com.provisionTechAdvisors.DeenDiscovery.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/asn/{ipAddress}")
    public AsnResponse getAsnInfo(@PathVariable String ipAddress) {
        try {
            return locationService.getAsnInfo(ipAddress);
        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
            // You should handle exceptions and return an appropriate error response here.
            return null;
        }
    }
}
