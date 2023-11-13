package com.provisionTechAdvisors.DeenDiscovery.controller;

import com.provisionTechAdvisors.DeenDiscovery.model.Tasbeeh;
import com.provisionTechAdvisors.DeenDiscovery.service.TasbeehService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasbeeh")
public class TasbeehController {

    private final TasbeehService tasbeehService;

    public TasbeehController(TasbeehService tasbeehService) {
        this.tasbeehService = tasbeehService;
    }

    @GetMapping
    public ResponseEntity<List<Tasbeeh>> getAllTasbeeh() {
        List<Tasbeeh> tasbeehs = tasbeehService.findAllTasbeeh();
        return new ResponseEntity<>(tasbeehs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasbeeh> getTasbeehById(@PathVariable Long id) {
        return tasbeehService.findTasbeehById(id)
                .map(tasbeeh -> new ResponseEntity<>(tasbeeh, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Tasbeeh> createTasbeeh(@RequestBody Tasbeeh tasbeeh) {
        Tasbeeh newTasbeeh = tasbeehService.createTasbeeh(tasbeeh);
        return new ResponseEntity<>(newTasbeeh, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tasbeeh> updateTasbeeh(@PathVariable Long id, @RequestBody Tasbeeh tasbeehDetails) {
        return tasbeehService.updateTasbeeh(id, tasbeehDetails)
                .map(updatedTasbeeh -> new ResponseEntity<>(updatedTasbeeh, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTasbeeh(@PathVariable Long id) {
        boolean isDeleted = tasbeehService.deleteTasbeeh(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
