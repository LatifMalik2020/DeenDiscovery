package com.provisionTechAdvisors.DeenDiscovery.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuranDTO {

    @JsonProperty("data")
    private QuranData data;

    // Getters and Setters

    public QuranData getData() {
        return data;
    }

    public void setData(QuranData data) {
        this.data = data;
    }

    public static class QuranData {
        @JsonProperty("surahs")
        private List<SurahDTO> surahs;

        // Getters and Setters

        public List<SurahDTO> getSurahs() {
            return surahs;
        }

        public void setSurahs(List<SurahDTO> surahs) {
            this.surahs = surahs;
        }
    }
}