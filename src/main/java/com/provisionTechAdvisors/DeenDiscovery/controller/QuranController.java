package com.provisionTechAdvisors.DeenDiscovery.controller;



import com.provisionTechAdvisors.DeenDiscovery.service.QuranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quran")
public class QuranController {
        @Autowired
        private QuranService quranService;

        @GetMapping
        public Object getQuranData() {
            return quranService.fetchQuranData();
        }
}