package com.mattbroph.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDate;

/**
 * Represents a user's Journal Entry
 */
@Entity
@Table(name = "journal")

public class Journal {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "JournalID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    @NotNull(message = "User must be provided")
    private User user;

    @Column(name = "JournalDate")
    @NotNull(message = "Date must be provided")
    private LocalDate journalDate;

    @ManyToOne
    @JoinColumn(name = "LakeID")
    @NotNull(message = "Lake must be provided")
    private Lake lake;

    @Column(name = "Hours")
    @Min(value = 0, message = "Hours must be between 0 and 24")
    @Max(value = 24, message = "Hours must be between 0 and 24")
    private double hours;

    @ManyToOne
    @NotNull(message = "Method must be provided")
    @JoinColumn(name = "MethodID")
    private Method method;

    @Column(name = "AirTemp")
    @NotNull(message = "Air temp must be provided")
    @Min(value = -100, message = "Temp must be between -100 and 200")
    @Max(value = 200, message = "Temp must be between -100 and 200")
    private int airTemp;

    @ManyToOne
    @NotNull(message = "Weather must be provided")
    @JoinColumn(name = "WeatherID")
    private Weather weather;

    @ManyToOne
    @JoinColumn(name = "WindID")
    @NotNull(message = "Wind must be provided")
    private Wind wind;

    @Column(name = "Comments")
    @Size(max = 1000, message = "Comments should be less than 1000 characters")
    private String comments;

    @Column(name = "ImageURL")
    @Size(min = 0, max = 255, message = "Photo url must be between 0 and 255 characters")
    private String imageURL;

    @Column(name = "SM_14_16")
    @Min(value = 0, message = "SM_14_16 count must be between 0 and 100")
    @Max(value = 100, message = "SM_14_16 count must be between 0 and 100")
    private int smallMouth1416;

    @Column(name = "SM_16_19")
    @Min(value = 0, message = "SM_16_19 count must be between 0 and 100")
    @Max(value = 100, message = "SM_16_19 count must be between 0 and 100")
    private int smallMouth1619;

    @Column(name = "SM_19_PLUS")
    @Min(value = 0, message = "SM_19_PLUS count must be between 0 and 100")
    @Max(value = 100, message = "SM_19_PLUS count must be between 0 and 100")
    private int smallMouth19Plus;

    @Column(name = "LM_14_16")
    @Min(value = 0, message = "LM_14_16 count must be between 0 and 100")
    @Max(value = 100, message = "LM_14_16 count must be between 0 and 100")
    private int largeMouth1416;

    @Column(name = "LM_16_19")
    @Min(value = 0, message = "LM_16_19 count must be between 0 and 100")
    @Max(value = 100, message = "LM_16_19 count must be between 0 and 100")
    private int largeMouth1619;

    @Column(name = "LM_19_PLUS")
    @Min(value = 0, message = "LM_19_PLUS count must be between 0 and 100")
    @Max(value = 100, message = "LM_19_PLUS count must be between 0 and 100")
    private int largeMouth19Plus;

    @Transient
    private int totalBassCount;


    /**
     * Instantiates a new Journal.
     */
    public Journal() {

    }


    /**
     * Instantiates a new Journal.
     *
     * @param user             the user
     * @param journalDate      the journal date
     * @param lake             the lake
     * @param hours            the hours
     * @param method           the method object
     * @param airTemp          the air temp
     * @param weather          the weather object
     * @param wind             the wind object
     * @param comments         the comments
     * @param imageURL         the image url
     * @param smallMouth1416   the small mouth 1416
     * @param smallMouth1619   the small mouth 1619
     * @param smallMouth19Plus the small mouth 19 plus
     * @param largeMouth1416   the large mouth 1416
     * @param largeMouth1619   the large mouth 1619
     * @param largeMouth19Plus the large mouth 19 plus
     */
    public Journal(User user, LocalDate journalDate, Lake lake,
            double hours, Method method, int airTemp, Weather weather, Wind wind,
            String comments, String imageURL, int smallMouth1416, int smallMouth1619,
            int smallMouth19Plus, int largeMouth1416, int largeMouth1619,
            int largeMouth19Plus) {

        this();
        this.user = user;
        this.journalDate = journalDate;
        this.lake = lake;
        this.hours = hours;
        this.method = method;
        this.airTemp = airTemp;
        this.weather = weather;
        this.wind = wind;
        this.comments = comments;
        this.imageURL = imageURL;
        this.smallMouth1416 = smallMouth1416;
        this.smallMouth1619 = smallMouth1619;
        this.smallMouth19Plus = smallMouth19Plus;
        this.largeMouth1416 = largeMouth1416;
        this.largeMouth1619 = largeMouth1619;
        this.largeMouth19Plus = largeMouth19Plus;
    }

    /**
     * Gets journal id.
     *
     * @return the journal id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets journal id.
     *
     * @param id the journal id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user
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
     * Gets journal date.
     *
     * @return the journal date
     */
    public LocalDate getJournalDate() {
        return journalDate;
    }

    /**
     * Sets journal date.
     *
     * @param journalDate the journal date
     */
    public void setJournalDate(LocalDate journalDate) {
        this.journalDate = journalDate;
    }

    /**
     * Gets the lake
     *
     * @return the lake
     */
    public Lake getLake() {
        return lake;
    }

    /**
     * Sets the lake
     *
     * @param lake the lake
     */
    public void setLake(Lake lake) {
        this.lake = lake;
    }

    /**
     * Gets hours.
     *
     * @return the hours
     */
    public double getHours() {
        return hours;
    }

    /**
     * Sets hours.
     *
     * @param hours the hours
     */
    public void setHours(double hours) {
        this.hours = hours;
    }

    /**
     * Gets method id.
     *
     * @return the method id
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Sets method
     *
     * @param method the method
     */
    public void setMethod(Method method) {
        this.method = method;
    }

    /**
     * Gets air temp.
     *
     * @return the air temp
     */
    public int getAirTemp() {
        return airTemp;
    }

    /**
     * Sets air temp.
     *
     * @param airTemp the air temp
     */
    public void setAirTemp(int airTemp) {
        this.airTemp = airTemp;
    }

    /**
     * Gets the weather
     *
     * @return the weather
     */
    public Weather getWeather() {
        return weather;
    }

    /**
     * Sets the weather
     *
     * @param weather the weather
     */
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    /**
     * Gets the wind
     *
     * @return the wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * Sets the wind
     *
     * @param wind the wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * Gets comments.
     *
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets comments.
     *
     * @param comments the comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets image url.
     *
     * @return the image url
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Sets image url.
     *
     * @param imageURL the image url
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Gets small mouth 1416.
     *
     * @return the small mouth 1416
     */
    public int getSmallMouth1416() {
        return smallMouth1416;
    }

    /**
     * Sets small mouth 1416.
     *
     * @param smallMouth1416 the small mouth 1416
     */
    public void setSmallMouth1416(int smallMouth1416) {
        this.smallMouth1416 = smallMouth1416;
    }

    /**
     * Gets small mouth 1619.
     *
     * @return the small mouth 1619
     */
    public int getSmallMouth1619() {
        return smallMouth1619;
    }

    /**
     * Sets small mouth 1619.
     *
     * @param smallMouth1619 the small mouth 1619
     */
    public void setSmallMouth1619(int smallMouth1619) {
        this.smallMouth1619 = smallMouth1619;
    }

    /**
     * Gets small mouth 19 plus.
     *
     * @return the small mouth 19 plus
     */
    public int getSmallMouth19Plus() {
        return smallMouth19Plus;
    }

    /**
     * Sets small mouth 19 plus.
     *
     * @param smallMouth19Plus the small mouth 19 plus
     */
    public void setSmallMouth19Plus(int smallMouth19Plus) {
        this.smallMouth19Plus = smallMouth19Plus;
    }

    /**
     * Gets large mouth 1416.
     *
     * @return the large mouth 1416
     */
    public int getLargeMouth1416() {
        return largeMouth1416;
    }

    /**
     * Sets large mouth 1416.
     *
     * @param largeMouth1416 the large mouth 1416
     */
    public void setLargeMouth1416(int largeMouth1416) {
        this.largeMouth1416 = largeMouth1416;
    }

    /**
     * Gets large mouth 1619.
     *
     * @return the large mouth 1619
     */
    public int getLargeMouth1619() {
        return largeMouth1619;
    }

    /**
     * Sets large mouth 1619.
     *
     * @param largeMouth1619 the large mouth 1619
     */
    public void setLargeMouth1619(int largeMouth1619) {
        this.largeMouth1619 = largeMouth1619;
    }

    /**
     * Gets large mouth 19 plus.
     *
     * @return the large mouth 19 plus
     */
    public int getLargeMouth19Plus() {
        return largeMouth19Plus;
    }

    /**
     * Sets large mouth 19 plus.
     *
     * @param largeMouth19Plus the large mouth 19 plus
     */
    public void setLargeMouth19Plus(int largeMouth19Plus) {
        this.largeMouth19Plus = largeMouth19Plus;
    }

    /**
     * Adds up the total bass count for the journal
     * @return the total bass count
     */
     public int getTotalBassCount() {

        int totalBassCount = largeMouth1416 + largeMouth1619 + largeMouth19Plus
        + smallMouth1416 + smallMouth1619 + smallMouth19Plus;

        return totalBassCount;
     }


    @Override
    public String toString() {
        return "Journal{" +
                "largeMouth19Plus=" + largeMouth19Plus +
                ", largeMouth1619=" + largeMouth1619 +
                ", largeMouth1416=" + largeMouth1416 +
                ", smallMouth19Plus=" + smallMouth19Plus +
                ", smallMouth1619=" + smallMouth1619 +
                ", smallMouth1416=" + smallMouth1416 +
                ", imageURL='" + imageURL + '\'' +
                ", comments='" + comments + '\'' +
                ", airTemp=" + airTemp +
                ", hours=" + hours +
                ", journalDate=" + journalDate +
                ", id=" + id +
                '}';
    }
}
