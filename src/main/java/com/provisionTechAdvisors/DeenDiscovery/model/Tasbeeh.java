package com.provisionTechAdvisors.DeenDiscovery.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tasbeeh_counts")
public class Tasbeeh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dhikr;

    @Column(nullable = false)
    private Integer count;

    // Getters
    public Long getId() { return id; }
    public String getDhikr() { return dhikr; }
    public Integer getCount() { return count; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setDhikr(String dhikr) { this.dhikr = dhikr; }
    public void setCount(Integer count) { this.count = count; }


}


