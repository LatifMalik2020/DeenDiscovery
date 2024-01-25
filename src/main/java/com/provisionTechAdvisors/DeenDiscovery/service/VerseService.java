package com.provisionTechAdvisors.DeenDiscovery.service;
import com.provisionTechAdvisors.DeenDiscovery.model.Ayah;

import com.provisionTechAdvisors.DeenDiscovery.repository.VerseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VerseService {

    private final VerseRepository verseRepository;

    @Autowired
    public VerseService(VerseRepository verseRepository) {
        this.verseRepository = verseRepository;
    }

    public List<Ayah> findAllVerses() {
        return verseRepository.findAll();
    }

    public Optional<Ayah> findVerseById(Long id) {
        return verseRepository.findById(id);
    }

    public Ayah createVerse(Ayah verse) {
        return verseRepository.save(verse);
    }

    public Optional<Ayah> updateVerse(Long id, Ayah verseDetails) {
        return verseRepository.findById(id)
                .map(verse -> {
                    verse.setText(verseDetails.getText());
                    // Update other fields as necessary
                    return verseRepository.save(verse);
                });
    }

    public boolean deleteVerse(Long id) {
        return verseRepository.findById(id)
                .map(verse -> {
                    verseRepository.delete(verse);
                    return true;
                }).orElse(false);
    }
}