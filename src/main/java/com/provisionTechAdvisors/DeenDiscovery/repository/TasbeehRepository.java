package com.provisionTechAdvisors.DeenDiscovery.repository;

import com.provisionTechAdvisors.DeenDiscovery.model.Tasbeeh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasbeehRepository extends JpaRepository<Tasbeeh, Long> {
    // Example custom query to find Tasbeeh records by dhikr
    List<Tasbeeh> findByDhikr(String dhikr);
}