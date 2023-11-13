package com.provisionTechAdvisors.DeenDiscovery.service;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.AsnResponse;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Country;
import com.provisionTechAdvisors.DeenDiscovery.controller.util.LocationInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class LocationService {

    private  DatabaseReader databaseReader;

    public LocationService() {
        try {
            // Provide the correct path to your GeoLite2-ASN database file
            String databaseFilePath = "src/main/resources/GeoLite2-City.mmdb";
            databaseReader = new DatabaseReader.Builder(new File(databaseFilePath)).build();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    // Other methods in your LocationService class

    public AsnResponse getAsnInfo(String ipAddress) throws IOException, GeoIp2Exception {
        // Use the databaseReader to query ASN information for the given IP address
        return databaseReader.asn(InetAddress.getByName(ipAddress));
    }
    public LocationInfo getLocationInfo(HttpServletRequest request) throws IOException, GeoIp2Exception {
        String clientIpAddress = getClientIpAddress(request);

        InetAddress ipAddress = InetAddress.getByName(clientIpAddress);
        CityResponse response = databaseReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String countryName = response.getCountry().getName();

        return new LocationInfo(cityName, countryName);
    }
    public String getClientIpAddress(HttpServletRequest request) {
        String clientIpAddress = request.getHeader("X-Forwarded-For");
        if (clientIpAddress == null || clientIpAddress.isEmpty() || "unknown".equalsIgnoreCase(clientIpAddress)) {
            clientIpAddress = request.getHeader("Proxy-Client-IP");
        }
        if (clientIpAddress == null || clientIpAddress.isEmpty() || "unknown".equalsIgnoreCase(clientIpAddress)) {
            clientIpAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIpAddress == null || clientIpAddress.isEmpty() || "unknown".equalsIgnoreCase(clientIpAddress)) {
            clientIpAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (clientIpAddress == null || clientIpAddress.isEmpty() || "unknown".equalsIgnoreCase(clientIpAddress)) {
            clientIpAddress = request.getHeader("HTTP_X_FORWARDED");
        }
        if (clientIpAddress == null || clientIpAddress.isEmpty() || "unknown".equalsIgnoreCase(clientIpAddress)) {
            clientIpAddress = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (clientIpAddress == null || clientIpAddress.isEmpty() || "unknown".equalsIgnoreCase(clientIpAddress)) {
            clientIpAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (clientIpAddress == null || clientIpAddress.isEmpty() || "unknown".equalsIgnoreCase(clientIpAddress)) {
            clientIpAddress = request.getHeader("HTTP_FORWARDED_FOR");
        }
        if (clientIpAddress == null || clientIpAddress.isEmpty() || "unknown".equalsIgnoreCase(clientIpAddress)) {
            clientIpAddress = request.getHeader("HTTP_FORWARDED");
        }
        if (clientIpAddress == null || clientIpAddress.isEmpty() || "unknown".equalsIgnoreCase(clientIpAddress)) {
            clientIpAddress = request.getRemoteAddr();
        }
        return clientIpAddress;
    }


}
