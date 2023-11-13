package com.provisionTechAdvisors.DeenDiscovery.service;

import com.provisionTechAdvisors.DeenDiscovery.DTO.AyahDTO;
import com.provisionTechAdvisors.DeenDiscovery.DTO.SurahApiResponse;
import com.provisionTechAdvisors.DeenDiscovery.DTO.SurahDTO;
import com.provisionTechAdvisors.DeenDiscovery.controller.util.SurahMapper;
import com.provisionTechAdvisors.DeenDiscovery.model.Surah;
import com.provisionTechAdvisors.DeenDiscovery.repository.SurahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
public class SurahService {
    @Autowired
    private SurahRepository surahRepository;

    private final RestTemplate restTemplate;
    private final String quranApiBaseUrl = "http://api.alquran.cloud/v1"; // Al-Quran Cloud API base URL

    public SurahService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<SurahDTO> getAllSurahs() {
        String url = quranApiBaseUrl + "/surah"; // Endpoint for fetching Surahs
        ResponseEntity<SurahApiResponse> response = restTemplate.getForEntity(url, SurahApiResponse.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody().getData();
        } else {
            // Handle error or throw an exception
            return Collections.emptyList();
        }
    }

    public void saveSurahsFromApi() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://api.alquran.cloud/v1/surah";
        ResponseEntity<SurahDTO> response = restTemplate.getForEntity(apiUrl, SurahDTO.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            SurahDTO surahResponse = response.getBody();
            if (surahResponse != null) {
                List<SurahDTO> surahs = surahResponse.getData();
                for (SurahDTO surahDTO : surahs) {
                    Surah surah = SurahMapper.toEntity(surahDTO);
                    surahRepository.save(surah);
                }
            }
        }
    }

    public Surah getSurahByIndex(String index) throws Exception {
        return surahRepository.findById(String.valueOf(index)).orElseThrow(() -> new Exception("Surah not found"));
    }

    // Additional  mmethods, such as ss getting a specific Surah or Ayah, can be added here
    // ...
    public SurahDTO getSurah(int surahNumber) {
        String url = quranApiBaseUrl + "/surah/" + surahNumber;
        ResponseEntity<SurahDTO> response = restTemplate.getForEntity(url, SurahDTO.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody();
        } else {
            // Handle error or throw an excepton
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Surah not found");
        }
    }
    public AyahDTO getAyah(int surahNumber, int ayahNumber) {
        String url = quranApiBaseUrl + "/surah/" + surahNumber + "/ayah/" + ayahNumber;
        ResponseEntity<AyahDTO> response = restTemplate.getForEntity(url, AyahDTO.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody();
        } else {
            // Handle error or throw an exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ayah not found");
        }
    }


}
