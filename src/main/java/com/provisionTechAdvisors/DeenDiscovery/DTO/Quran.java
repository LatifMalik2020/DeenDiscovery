package com.provisionTechAdvisors.DeenDiscovery.DTO;
import com.provisionTechAdvisors.DeenDiscovery.model.Suraah;


import java.util.List;

public class Quran {
    private List<Suraah> surahs;

    // Constructor
    public Quran(List<Suraah> surahs) {
        this.surahs = surahs;
    }

    // Get a specific Surah by its number
    public Suraah getSurah(int number) {
        return surahs.stream().filter(surah -> surah.getNumber() == number).findFirst().orElse(null);
    }

    // Get all Surahs
    public List<Suraah> getSurahs() {
        return surahs;
    }

    // Set Surahs
    public void setSurahs(List<Suraah> surahs) {
        this.surahs = surahs;
    }
}
