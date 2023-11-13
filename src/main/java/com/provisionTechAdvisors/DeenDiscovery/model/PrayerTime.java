package com.provisionTechAdvisors.DeenDiscovery.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "prayer_times")
public class PrayerTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "prayer_date")
    private LocalDate date;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private LocalTime fajr;

    @Column(nullable = false)
    private LocalTime dhuhr;

    @Column(nullable = false)
    private LocalTime asr;

    @Column(nullable = false)
    private LocalTime maghrib;

    @Column(nullable = false)
    private LocalTime isha;

    // Standard getters and setters

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalTime getFajr() {
        return fajr;
    }

    public void setFajr(LocalTime fajr) {
        this.fajr = fajr;
    }

    public LocalTime getDhuhr() {
        return dhuhr;
    }

    public void setDhuhr(LocalTime dhuhr) {
        this.dhuhr = dhuhr;
    }

    public LocalTime getAsr() {
        return asr;
    }

    public void setAsr(LocalTime asr) {
        this.asr = asr;
    }

    public LocalTime getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(LocalTime maghrib) {
        this.maghrib = maghrib;
    }

    public LocalTime getIsha() {
        return isha;
    }

    public void setIsha(LocalTime isha) {
        this.isha = isha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrayerTime that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getFajr(), that.getFajr()) && Objects.equals(getDhuhr(), that.getDhuhr()) && Objects.equals(getAsr(), that.getAsr()) && Objects.equals(getMaghrib(), that.getMaghrib()) && Objects.equals(getIsha(), that.getIsha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCity(), getFajr(), getDhuhr(), getAsr(), getMaghrib(), getIsha());
    }

    @Override
    public String toString() {
        return "PrayerTime{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", fajr=" + fajr +
                ", dhuhr=" + dhuhr +
                ", asr=" + asr +
                ", maghrib=" + maghrib +
                ", isha=" + isha +
                '}';
    }
}
