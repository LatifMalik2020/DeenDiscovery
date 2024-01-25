package com.provisionTechAdvisors.DeenDiscovery.repository;


import com.provisionTechAdvisors.DeenDiscovery.model.Suraah;

import java.util.List;

public interface QuranRepository {
    List<Suraah> getAllSurahs();
    Suraah getSurahByNumber(int number);
}