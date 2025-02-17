package com.mattbroph.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

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

    /** The user's id */
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "LakeStatus")
    private boolean lakeStatus;

    // TODO NEW LINE HERE - MAY NEED TO UPDATE CASCADING

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
     * @param lakeStatus whether or not the lake is active
     */
    public Lake(String lakeName, User user, boolean lakeStatus) {
        this.lakeName = lakeName;
        this.user = user;
        this.lakeStatus = lakeStatus;
    }

    /**
     * TODO NOT SURE IF THIS IS NEED BUT WAS IN USER EXAMPLE
     */
    public void addJournal(Journal journal) {
        journals.add(journal);
        journal.setLake(this);
    }

    /**
     * TODO NOT SURE IF THIS IS NEED BUT WAS IN USER EXAMPLE
     */
     public void removeJournal(Journal journal) {
        journals.remove(journal);
        journal.setLake(null);
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
    public User getUserId() {
        return user;
    }

    /**
     * Sets user
     *
     * @param user the user
     */
    public void setUserId(User user) {
        this.user = user;
    }

    /**
     * Is lake status boolean.
     *
     * @return the boolean
     */
    public boolean isLakeStatus() {
        return lakeStatus;
    }

    /**
     * Sets lake status.
     *
     * @param lakeStatus the lake status
     */
    public void setLakeStatus(boolean lakeStatus) {
        this.lakeStatus = lakeStatus;
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





