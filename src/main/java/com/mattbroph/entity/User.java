package com.mattbroph.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * The user
 */
@Entity(name = "User")
@Table(name = "AppUser")
public class User {

    /** The unique User ID */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "UserID")
    private int id;

    /** The username */
    @Column(name = "UserName")
    private String userName;

    /** The user's first name */
    @Column(name = "FirstName")
    private String firstName;

    /** The user's last name */
    @Column(name = "LastName")
    private String lastName;

    /** The user's profile picture */
    @Column(name = "ProfilePicture")
    private String profilePicture;

    /** List of the users lakes */
    // TODO UDPATE CASCADE TYPE ON ALL OBJECTS!!! NEED TO CONSIDER STUFF
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Lake> lakes = new ArrayList<>();

    /** List of the users journals */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Journal> journals = new ArrayList<>();

    //TODO NEW CODE HERE FOR DASHBOARD
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BassGoal> bassGoal = new ArrayList<>();

    /**
     * Empty constructor for instantiating new user
     */
    public User() {
    }

    /**
     * Instantiates a new User with instance variables.
     *
     * @param userName       the user name
     * @param firstName      the user's first name
     * @param lastName       the user's last name
     * @param profilePicture the user's profile picture
     */
    public User(String userName, String firstName, String lastName, String profilePicture) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
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
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets profile picture.
     *
     * @return the profile picture
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     * Sets profile picture.
     *
     * @param profilePicture the profile picture
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * Gets lakes.
     *
     * @return the lakes
     */
    public List<Lake> getLakes() {
        return lakes;
    }

    /**
     * Sets lakes.
     *
     * @param lakes the lakes
     */
    public void setLakes(List<Lake> lakes) {
        this.lakes = lakes;
    }

    /**
     * Gets journals
     *
     * @return the journals
     */
    public List<Journal> getJournals() {
        return journals;
    }

    /**
     * Sets journals
     *
     * @param journals the journals
     */
    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

    /**
     * Gets bass goal.
     *
     * @return the bass goal
     */
    public List<BassGoal> getBassGoal() {
        return bassGoal;
    }

    /**
     * Sets bass goal.
     *
     * @param bassGoal the bass goal
     */
    public void setBassGoal(List<BassGoal> bassGoal) {
        this.bassGoal = bassGoal;
    }

    // TODO update all toStrings()
    @Override
    public String toString() {
        return "User{" +
                "profilePicture='" + profilePicture + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", userName='" + userName + '\'' +
                ", id=" + id +
//                ", lakes=" + lakes +
                '}';
    }
}
