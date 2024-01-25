package com.provisionTechAdvisors.DeenDiscovery.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "surahs")
public class Suraah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer number;
    private String englishNameTranslation;
    private String englishName;
    private String revelationType;
    @OneToMany(mappedBy = "surah", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ayah> ayahs;

    // Constructor
    public Suraah(int number, String name, List<Ayah> ayahs) {
        this.number = number;
        this.name = name;
        this.ayahs = ayahs;
    }

    public Suraah() {

    }

    // Get a specific Ayah by its number
    public Ayah getAyah(int number) {
        return ayahs.stream().filter(ayah -> ayah.getNumber() == number).findFirst().orElse(null);
    }

    // Getters and Setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ayah> getAyahs() {
        return ayahs;
    }

    public void setAyahs(List<Ayah> ayahs) {
        this.ayahs = ayahs;
    }

    public void setEnglishName(String englishName) {
        this.englishName= englishName;
    }

    public void setEnglishNameTranslation(String englishNameTranslation) {
        this.englishNameTranslation =englishNameTranslation;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }
}