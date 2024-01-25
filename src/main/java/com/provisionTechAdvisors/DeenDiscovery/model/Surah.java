//package com.provisionTechAdvisors.DeenDiscovery.model;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//import java.util.Objects;
//
//@Entity
//@Table(name = "surahs")
//public class Surah {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private Integer number;
//
//    @OneToMany(mappedBy = "surah", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Column(nullable = false)
//    private List<Verse> verses;
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getNumber() {
//        return number;
//    }
//
//    public void setNumber(Integer number) {
//        this.number = number;
//    }
//
//    public List<Verse> getVerses() {
//        return verses;
//    }
//
//    public void setVerses(List<Verse> verses) {
//        this.verses = verses;
//    }
//
//    // Standard toString, equals, and hashCode methods
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Surah surah)) return false;
//        return Objects.equals(getId(), surah.getId()) && Objects.equals(getName(), surah.getName()) && Objects.equals(getNumber(), surah.getNumber()) && Objects.equals(getVerses(), surah.getVerses());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getName(), getNumber(), getVerses());
//    }
//
//    @Override
//    public String toString() {
//        return "Surah{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", number=" + number +
//                ", verses=" + verses +
//                '}';
//    }
//}



