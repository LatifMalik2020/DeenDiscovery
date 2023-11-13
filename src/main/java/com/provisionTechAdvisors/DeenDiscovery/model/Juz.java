package com.provisionTechAdvisors.DeenDiscovery.model;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "juz")
public class Juz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String index;

    @ElementCollection
    @MapKeyColumn(name = "verse_start_end")
    @Column(name = "verse")
    @CollectionTable(name = "juz_details", joinColumns = @JoinColumn(name = "juz_id"))
    private Map<String, String> verse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Map<String, String> getVerse() {
        return verse;
    }

    public void setVerse(Map<String, String> verse) {
        this.verse = verse;
    }
}
