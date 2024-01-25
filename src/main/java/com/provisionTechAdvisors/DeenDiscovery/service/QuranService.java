package com.provisionTechAdvisors.DeenDiscovery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class QuranService {

    private static final String QURAN_API_URL = "https://api.alquran.cloud/v1/quran/quran-uthmani";

    @Autowired
    private RestTemplate restTemplate;




        public Object fetchQuranData() {
            return restTemplate.getForObject(QURAN_API_URL, Object.class);
        }
//
//    public void fetchAndSaveQuranData() {
//        QuranDTO quranDTO = restTemplate.getForObject(QURAN_API_URL, QuranDTO.class);
//
//        if (quranDTO != null) {
//            List<SurahDTO> surahs = convertToSurahEntities(quranDTO.getData().getSurahs());
//            quranRepository.saveAll(surahs);
//        }
//    }
//
//    private List<Suraah> convertToSurahEntities(List<SurahDTO> surahDTOs) {
//        List<Suraah> surahs = new ArrayList<>();
//        for (SurahDTO surahDTO : surahDTOs) {
//            Suraah surah = new Suraah();
//            surah.setNumber(surahDTO.getNumber());
//            surah.setName(surahDTO.getName());
//            surah.setEnglishName(surahDTO.getEnglishName());
//            surah.setEnglishNameTranslation(surahDTO.getEnglishNameTranslation());
//            surah.setRevelationType(surahDTO.getRevelationType());
//            surah.setAyahs(convertToAyahEntities(surahDTO.getNumberOfAyahs()));
//            surahs.add(surah);
//        }
//        return surahs;
//    }
//
//    private List<Ayah> convertToAyahEntities(List<AyahDTO> ayahDTOs) {
//        List<Ayah> ayahs = new ArrayList<>();
//        for (AyahDTO ayahDTO : ayahDTOs) {
//            Ayah ayah = new Ayah();
//            ayah.setNumber(ayahDTO.getNumber());
//            ayah.setText(ayahDTO.getText());
//            ayahs.add(ayah);
//        }
//        return ayahs;
//    }
}
