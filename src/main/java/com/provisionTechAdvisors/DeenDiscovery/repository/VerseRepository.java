package com.provisionTechAdvisors.DeenDiscovery.repository;

import com.provisionTechAdvisors.DeenDiscovery.model.Verse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerseRepository extends JpaRepository<Verse, Long> {
    // Example custom query to find verses by Surah number
    List<Verse> findBySurahNumber(int surahNumber);
}