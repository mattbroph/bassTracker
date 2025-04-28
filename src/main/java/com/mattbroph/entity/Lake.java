package com.mattbroph.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Lake object
 */
 @Entity
 @Table(name = "lake")
public class Lake {

    /** The unique Lake ID */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "LakeID")
    private int id;

    /** The name of the lake */
    @Column(name = "LakeName")
    @Size(max = 50, min = 1, message = "Invalid lake name. Size should be between 1 and 50 characters.")
    @NotEmpty(message = "Please enter a lake name")
    private String lakeName;

    /** The user's id */
    @ManyToOne
    @JoinColumn(name = "UserID")
    @NotNull(message = "User must be provided")
    private User user;

    /** Whether the user has marked a lake active or inactive */
    @Column(name = "isActive")
    private boolean isActive;

    /** The list of journals that reference the lake */
    @OneToMany(mappedBy = "lake", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Journal> journals = new ArrayList<>();

    /**
     * Empty constructor for instantiating new lake
     */
    public Lake() {
    }

    /**
     * Instantiates a new Lake with instance variables.
     *
     * @param lakeName the lake name
     * @param user   the user
     * @param isActive whether the lake is active or inactive
     */
    public Lake(String lakeName, User user, boolean isActive) {
        this.lakeName = lakeName;
        this.user = user;
        this.isActive = isActive;
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
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Is lake status boolean.
     *
     * @return the boolean
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Sets lake status.
     *
     * @param isActive the lake status
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Gets journals
     * @return the journals
     */
    public List<Journal> getJournals() {
        return journals;
    }

    /**
     * Sets journals
     * @param journals the journals
     */
    public void setJournals(List<Journal> journals) {
        this.journals = journals;
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
                ", user= " + user +
                '}';
    }
}





