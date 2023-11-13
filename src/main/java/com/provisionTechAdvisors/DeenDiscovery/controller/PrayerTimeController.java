package com.provisionTechAdvisors.DeenDiscovery.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.provisionTechAdvisors.DeenDiscovery.DTO.ApiResponse;
import com.provisionTechAdvisors.DeenDiscovery.controller.util.LocationInfo;
import com.provisionTechAdvisors.DeenDiscovery.controller.util.LocationInfoProvider;
import com.provisionTechAdvisors.DeenDiscovery.model.PrayerTime;
import com.provisionTechAdvisors.DeenDiscovery.service.AladhanAPIService;
import com.provisionTechAdvisors.DeenDiscovery.service.LocationService;
import com.provisionTechAdvisors.DeenDiscovery.service.PrayerTimeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/prayertimes")
public class PrayerTimeController {

    private final AladhanAPIService aladhanAPIService;
    private final LocationService locationService;

    @Autowired
    public PrayerTimeController(AladhanAPIService aladhanAPIService, LocationService locationService) {
        this.aladhanAPIService = aladhanAPIService;
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<?> getPrayerTimesForLocation(HttpServletRequest request) {
        try {
            String ip = extractClientIp(request);
            // Check if IP is local or private and handle accordingly
            if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1") || ip.startsWith("192.168") || ip.startsWith("10.")) {
                // Handle local/private IP address (perhaps use a default location or return a specific message)
                return ResponseEntity.badRequest().body(new ApiResponse(false, "Local or private IP address cannot be used for location lookup."));
            }
            LocationInfo locationInfo = locationService.getLocationInfo(request);
            ApiResponse apiResponse = aladhanAPIService.getPrayerTimes(locationInfo.getCity(), locationInfo.getCountry());
            return ResponseEntity.ok(apiResponse);
        } catch (IOException | GeoIp2Exception e) {
            // Handle exceptions here, such as returning an error response entity
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "Error fetching location info: " + e.getMessage()));
        }
    }


    private String extractClientIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0]; // this will return the client's IP
    }
}

//    private String extractClientIp(HttpServletRequest request) {
//        String ip = request.getHeader("X-Forwarded-For");
//        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        // If none of the headers are present, fallback to the remote IP address
//        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//
//        // In case of multiple IP addresses, pick the first one (client IP should be the first)
//        if (ip != null && ip.contains(",")) {
//            ip = ip.split(",")[0];
//        }
//
//        return ip;
//    }

//}


//    @GetMapping
//    public ResponseEntity<List<PrayerTime>> getAllPrayerTimes() {
//        List<PrayerTime> prayerTimes = prayerTimeService.findAllPrayerTimes();
//        return ResponseEntity.ok(prayerTimes);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PrayerTime> getPrayerTimeById(@PathVariable Long id) {
//        return prayerTimeService.findPrayerTimeById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

//    @GetMapping("/city/{city}")
//    public ResponseEntity<PrayerTime> getPrayerTimeByCity(@PathVariable String city) {
//        return prayerTimeService.findPrayerTimeByCity(city)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

//    @PostMapping
//    public ResponseEntity<PrayerTime> createPrayerTime(@RequestBody PrayerTime prayerTime) {
//        PrayerTime createdPrayerTime = prayerTimeService.createPrayerTime(prayerTime);
//        return ResponseEntity.ok(createdPrayerTime);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<PrayerTime> updatePrayerTime(@PathVariable Long id, @RequestBody PrayerTime prayerTime) {
//        return prayerTimeService.updatePrayerTime(id, prayerTime)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePrayerTime(@PathVariable Long id) {
//        boolean isDeleted = prayerTimeService.deletePrayerTime(id);
//        if (isDeleted) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}