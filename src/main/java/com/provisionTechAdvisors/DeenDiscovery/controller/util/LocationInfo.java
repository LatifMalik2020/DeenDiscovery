package com.provisionTechAdvisors.DeenDiscovery.controller.util;

public class LocationInfo {
    private final String city;
    private final String country;

    public LocationInfo(String city, String country) {
        this.city = city;
        this.country = country;
    }


    // Add a constructor that accepts latitude and longitude as strings and parses them

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

}