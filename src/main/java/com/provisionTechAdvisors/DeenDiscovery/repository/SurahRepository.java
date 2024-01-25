package com.provisionTechAdvisors.DeenDiscovery.repository;

import com.provisionTechAdvisors.DeenDiscovery.DTO.SurahDTO;
import com.provisionTechAdvisors.DeenDiscovery.model.Suraah;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurahRepository extends JpaRepository<Suraah, String> {

}
    // Custom queries if needed