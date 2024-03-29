package com.provisionTechAdvisors.DeenDiscovery.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "verses")
public class Ayah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surah_id")
    private Suraah surah;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false, length = 1000)
    private String text;

    // Getters
    public Long getId() { return id; }
    public Suraah getSurah() { return surah; }
    public Integer getNumber() { return number; }
    public String getText() { return text; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setSurah(Suraah surah) { this.surah = surah; }
    public void setNumber(Integer number) { this.number = number; }
    public void setText(String text) { this.text = text; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ayah verse)) return false;
        return Objects.equals(getId(), verse.getId()) && Objects.equals(getSurah(), verse.getSurah()) && Objects.equals(getNumber(), verse.getNumber()) && Objects.equals(getText(), verse.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSurah(), getNumber(), getText());
    }

    @Override
    public String toString() {
        return "Verse{" +
                "id=" + id +
                ", surah=" + surah +
                ", number=" + number +
                ", text='" + text + '\'' +
                '}';
    }
}
