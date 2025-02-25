package com.mattbroph.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * The weather type
 */
@Entity(name = "Weather")
@Table(name = "weather")
public class Weather {

    /** The unique Weather ID */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "WeatherID")
    private int id;

    /** The weather type */
    @Column(name = "WeatherType")
    private String weatherType;

    @OneToMany(mappedBy = "weather", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Journal> journals = new ArrayList<>();

    /**
     * Empty constructor for instantiating a weather object
     */
    public Weather() {
    }

    /**
     * Instantiates a new Weather.
     *
     * @param weatherType the weather type
     */
    public Weather(String weatherType) {
        this.weatherType = weatherType;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets weather type.
     *
     * @return the weather type
     */
    public String getWeatherType() {
        return weatherType;
    }

    /**
     * Sets weather type.
     *
     * @param weatherType the weather type
     */
    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    /**
     * Gets journals.
     *
     * @return the journals
     */
    public List<Journal> getJournals() {
        return journals;
    }

    /**
     * Sets journals.
     *
     * @param journals the journals
     */
    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", weatherType='" + weatherType + '\'' +
                '}';
    }
}
