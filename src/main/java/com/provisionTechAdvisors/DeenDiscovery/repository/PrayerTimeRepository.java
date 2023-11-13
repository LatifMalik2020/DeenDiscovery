package com.provisionTechAdvisors.DeenDiscovery.repository;

import com.provisionTechAdvisors.DeenDiscovery.model.PrayerTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PrayerTimeRepository extends JpaRepository<PrayerTime, Long> {
    // Example custom query to find prayer times by city
    Optional<PrayerTime> findByCity(String city);

    // If you are storing prayer times on a daily basis, you might also have:
    Optional<PrayerTime> findByCityAndDate(String city, LocalDate date);
}