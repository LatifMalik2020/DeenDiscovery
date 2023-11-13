package com.provisionTechAdvisors.DeenDiscovery.service;
import com.provisionTechAdvisors.DeenDiscovery.model.Verse;
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

    public List<Verse> findAllVerses() {
        return verseRepository.findAll();
    }

    public Optional<Verse> findVerseById(Long id) {
        return verseRepository.findById(id);
    }

    public Verse createVerse(Verse verse) {
        return verseRepository.save(verse);
    }

    public Optional<Verse> updateVerse(Long id, Verse verseDetails) {
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