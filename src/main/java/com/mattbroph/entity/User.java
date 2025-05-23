package com.mattbroph.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * The user that is logged into the application
 */
@Entity(name = "User")
@Table(name = "appuser")
public class User {

    /** The unique User ID */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "UserID")
    private int id;

    /** The user email */
    @Column(name = "UserEmail")
    @NotNull(message = "Email must be provided")
    @Size(min = 1, max = 50, message = "Email must be between 1 and 50 characters")
    private String userEmail;

    /** The user's first name */
    @Column(name = "FirstName")
    @NotNull(message = "First name must be provided")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String firstName;

    /** The user's last name */
    @Column(name = "LastName")
    @NotNull(message = "Last name must be provided")
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
    private String lastName;

    /** The user's profile picture */
    @Column(name = "ProfilePicture")
    @Size(min = 0, max = 255, message = "Photo url must be between 0 and 255 characters")
    private String profilePicture;

    /** List of the users lakes */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Lake> lakes = new ArrayList<>();

    /** List of the users journals */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Journal> journals = new ArrayList<>();

    /** List of the users bass goals */
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
     * @param userEmail       the user email
     * @param firstName      the user's first name
     * @param lastName       the user's last name
     */
    public User(String userEmail, String firstName, String lastName) {
        this();
        this.userEmail = userEmail;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Instantiates a new User with all instance variables.
     *
     * @param userEmail       the user email
     * @param firstName      the user's first name
     * @param lastName       the user's last name
     * @param profilePicture the user's profile picture
     */
    public User(String userEmail, String firstName, String lastName, String profilePicture) {
        this.userEmail = userEmail;
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
     * Gets user email.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user email.
     *
     * @param userEmail the user email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    @Override
    public String toString() {
        return "User{" +
                "profilePicture='" + profilePicture + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", id=" + id +
                '}';
    }
}
