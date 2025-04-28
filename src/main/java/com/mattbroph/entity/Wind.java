package com.mattbroph.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a wind type
 */
@Entity(name = "Wind")
@Table(name = "wind")
public class Wind {

    /** The unique Wind ID */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "WindID")
    private int id;

    /** The wind type */
    @Column(name = "WindType")
    private String windType;

    /** The list of journals that reference the wind type */
    @OneToMany(mappedBy = "wind", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Journal> journals = new ArrayList<>();

    /**
     * Empty constructor for instantiating a wind object
     */
    public Wind() {
    }

    /**
     * Instantiates a new Wind.
     *
     * @param windType the wind type
     */
    public Wind(String windType) {
        this();
        this.windType = windType;
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
     * Gets wind type.
     *
     * @return the wind type
     */
    public String getWindType() {
        return windType;
    }

    /**
     * Sets wind type.
     *
     * @param windType the wind type
     */
    public void setWindType(String windType) {
        this.windType = windType;
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
        return "Wind{" +
                "id=" + id +
                ", windType='" + windType + '\'' +
                '}';
    }
}
