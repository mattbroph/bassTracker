package com.mattbroph.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Lake.
 */
 @Entity
 @Table(name = "Lake")
public class Lake {

    /** The unique Lake ID */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "LakeID")
    private int id;

    /** The name of the lake */
    @Column(name = "LakeName")
    private String lakeName;

    /** The user's id (TODO - id will be hardcoded until week 5 when learning one to many table relationships) */
    @Column(name = "UserID")
    private int userId;


    /**
     * Empty constructor for instantiating new lake
     */
    public Lake() {
    }

    /**
     * Instantiates a new Lake with instance variables.
     *
     * @param lakeName the lake name
     * @param userId   the user id
     */
    public Lake(String lakeName, int userId) {
        this.lakeName = lakeName;
        this.userId = userId;
    }

    /**
     * Gets lake id.
     *
     * @return the lake id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets lake id.
     *
     * @param id the lake id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets lake name.
     *
     * @return the lake name
     */
    public String getLakeName() {
        return lakeName;
    }

    /**
     * Sets lake name.
     *
     * @param lakeName the lake name
     */
    public void setLakeName(String lakeName) {
        this.lakeName = lakeName;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets all the instance variables for debugging
     * @return the lake instance variables
     */
    @Override
    public String toString() {
        return "Lake{" +
                "id= " + id +
                ", lakeName= '" + lakeName + '\'' +
                ", userId= " + userId +
                '}';
    }
}





