package com.provisionTechAdvisors.DeenDiscovery.repository;


import com.provisionTechAdvisors.DeenDiscovery.model.Ayah;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerseRepository extends JpaRepository<Ayah, Long> {
    // Example custom query to find verses by Surah number
    List<Ayah> findBySurahNumber(int surahNumber);
}