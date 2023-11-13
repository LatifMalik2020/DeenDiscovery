package com.provisionTechAdvisors.DeenDiscovery.controller.util;

import com.provisionTechAdvisors.DeenDiscovery.DTO.SurahDTO;
import com.provisionTechAdvisors.DeenDiscovery.model.Surah;

public class SurahMapper {
    public static Surah toEntity(SurahDTO dto) {
        Surah surah = new Surah();
        surah.setNumber(dto.getNumber());
        surah.setName(dto.getName());
        // Set other fields...
        return surah;
    }
}