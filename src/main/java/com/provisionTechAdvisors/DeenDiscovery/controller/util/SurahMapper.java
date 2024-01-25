package com.provisionTechAdvisors.DeenDiscovery.controller.util;

import com.provisionTechAdvisors.DeenDiscovery.DTO.SurahDTO;
import com.provisionTechAdvisors.DeenDiscovery.model.Suraah;


public class SurahMapper {
    public static Suraah toEntity(SurahDTO dto) {
        Suraah surah = new Suraah();
        surah.setNumber(dto.getNumber());
        surah.setName(dto.getName());
        // Set other fields...
        return surah;
    }
}