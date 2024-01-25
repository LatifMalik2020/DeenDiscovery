package com.provisionTechAdvisors.DeenDiscovery.controller;

import com.provisionTechAdvisors.DeenDiscovery.DTO.AyahDTO;
import com.provisionTechAdvisors.DeenDiscovery.DTO.SurahDTO;
import com.provisionTechAdvisors.DeenDiscovery.model.Suraah;

import com.provisionTechAdvisors.DeenDiscovery.service.SurahService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/surahs")
public class SurahController {

    private final SurahService surahService;

    public SurahController(SurahService surahService) {
        this.surahService = surahService;
    }

    @GetMapping("/allsurahs")
    public ResponseEntity<List<SurahDTO>> getAllSurahs() {
        List<SurahDTO> surahs = surahService.getAllSurahs();
        surahService.saveSurahsFromApi();
        return ResponseEntity.ok(surahs);
    }
    @GetMapping("/{index}")
    public ResponseEntity<Suraah> getSurah(@PathVariable String index) throws Exception {
        Suraah surah = surahService.getSurahByIndex(index);
        return ResponseEntity.ok(surah);
    }

//    @GetMapping("/{surahNumber}")
//    public ResponseEntity<SurahDTO> getSurah(@PathVariable int surahNumber) {
//        SurahDTO surah = surahService.getSurah(surahNumber);
//        return ResponseEntity.ok(surah);
//    }

    @GetMapping("/{surahNumber}/ayah/{ayahNumber}")
    public ResponseEntity<AyahDTO> getAyah(@PathVariable int surahNumber, @PathVariable int ayahNumber) {
        AyahDTO ayah = surahService.getAyah(surahNumber, ayahNumber);
        return ResponseEntity.ok(ayah);
    }

// ... rest of the SurahController class

}
