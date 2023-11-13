package com.provisionTechAdvisors.DeenDiscovery.service;

import com.provisionTechAdvisors.DeenDiscovery.model.PrayerTime;
import com.provisionTechAdvisors.DeenDiscovery.repository.PrayerTimeRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrayerTimeService {

    private final PrayerTimeRepository prayerTimeRepository;

    public PrayerTimeService(PrayerTimeRepository prayerTimeRepository) {
        this.prayerTimeRepository = prayerTimeRepository;
    }


    @Transactional(readOnly = true)
    public List<PrayerTime> findAllPrayerTimes() {
        return prayerTimeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<PrayerTime> findPrayerTimeById(Long id) {
        return prayerTimeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<PrayerTime> findPrayerTimeByCity(String city) {
        return prayerTimeRepository.findByCity(city);
    }

    @Transactional
    public PrayerTime createPrayerTime(PrayerTime prayerTime) {
        return prayerTimeRepository.save(prayerTime);
    }

    @Transactional
    public Optional<PrayerTime> updatePrayerTime(Long id, PrayerTime newPrayerTime) {
        return prayerTimeRepository.findById(id)
                .map(prayerTime -> {
                    prayerTime.setCity(newPrayerTime.getCity());
                    prayerTime.setFajr(newPrayerTime.getFajr());
                    prayerTime.setDhuhr(newPrayerTime.getDhuhr());
                    prayerTime.setAsr(newPrayerTime.getAsr());
                    prayerTime.setMaghrib(newPrayerTime.getMaghrib());
                    prayerTime.setIsha(newPrayerTime.getIsha());
                    return prayerTimeRepository.save(prayerTime);
                });
    }

    @Transactional
    public boolean deletePrayerTime(Long id) {
        return prayerTimeRepository.findById(id)
                .map(prayerTime -> {
                    prayerTimeRepository.delete(prayerTime);
                    return true;
                }).orElse(false);
    }
}
