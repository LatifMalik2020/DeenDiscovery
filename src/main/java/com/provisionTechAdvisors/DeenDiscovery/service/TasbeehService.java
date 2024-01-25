package com.provisionTechAdvisors.DeenDiscovery.service;

import com.provisionTechAdvisors.DeenDiscovery.model.Tasbeeh;
import com.provisionTechAdvisors.DeenDiscovery.repository.TasbeehRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TasbeehService {

    private final TasbeehRepository tasbeehRepository;

    public TasbeehService(TasbeehRepository tasbeehRepository) {
        this.tasbeehRepository = tasbeehRepository;
    }

    @Transactional(readOnly = true)
    public List<Tasbeeh> findAllTasbeeh() {
        return tasbeehRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Tasbeeh> findTasbeehById(Long id) {
        return tasbeehRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Tasbeeh> findTasbeehByDhikr(String dhikr) {
        return tasbeehRepository.findByDhikr(dhikr);
    }

    @Transactional
    public Tasbeeh createTasbeeh(Tasbeeh tasbeeh) {
        // This could be a create or update operation depending on whether the Tasbeeh object has an ID
        return tasbeehRepository.save(tasbeeh);
    }

    @Transactional
    public boolean deleteTasbeeh(Long id) {
        tasbeehRepository.deleteById(id);
        return false;
    }
    public Optional<Tasbeeh> updateTasbeeh(Long id, Tasbeeh tasbeehDetails) {
        return tasbeehRepository.findById(id)
                .map(existingTasbeeh -> {
                    // Map the details from the provided Tasbeeh object to the existing one
                    existingTasbeeh.setDhikr(tasbeehDetails.getDhikr());
                    existingTasbeeh.setCount(tasbeehDetails.getCount());
                    // Save the updated Tasbeeh object to the database
                    return tasbeehRepository.save(existingTasbeeh);
                });
    }

}