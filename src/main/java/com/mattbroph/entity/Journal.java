package com.mattbroph.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

/**
 * Represents a user's Journal Entry
 */
@Entity
 @Table(name = "Journal")

public class Journal {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "JournalID")
    private int id;

    @Column(name = "UserID")
    private int userID;

    @Column(name = "JournalDate")
    private LocalDate journalDate;

    @Column(name = "LakeID")
    private int lakeID;

    @Column(name = "Hours")
    private int hours;

    @Column(name = "MethodID")
    private int methodID;

    @Column(name = "AirTemp")
    private int airTemp;

    @Column(name = "WeatherID")
    private int weatherID;

    @Column(name = "WindID")
    private int windID;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "ImageURL")
    private String imageURL;

    @Column(name = "SM_14_16")
    private int smallMouth1416;

    @Column(name = "SM_16_19")
    private int smallMouth1619;

    @Column(name = "SM_19_PLUS")
    private int smallMouth19Plus;

    @Column(name = "LM_14_16")
    private int largeMouth1416;

    @Column(name = "LM_16_19")
    private int largeMouth1619;

    @Column(name = "LM_19_PLUS")
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
     * @param userID           the user id
     * @param journalDate      the journal date
     * @param lakeID           the lake id
     * @param hours            the hours
     * @param methodID         the method id
     * @param airTemp          the air temp
     * @param weatherID        the weather id
     * @param windID           the wind id
     * @param comments         the comments
     * @param imageURL         the image url
     * @param smallMouth1416   the small mouth 1416
     * @param smallMouth1619   the small mouth 1619
     * @param smallMouth19Plus the small mouth 19 plus
     * @param largeMouth1416   the large mouth 1416
     * @param largeMouth1619   the large mouth 1619
     * @param largeMouth19Plus the large mouth 19 plus
     */
    public Journal(int userID, LocalDate journalDate, int lakeID,
            int hours, int methodID, int airTemp, int weatherID, int windID,
            String comments, String imageURL, int smallMouth1416, int smallMouth1619,
            int smallMouth19Plus, int largeMouth1416, int largeMouth1619,
            int largeMouth19Plus) {

        this.userID = userID;
        this.journalDate = journalDate;
        this.lakeID = lakeID;
        this.hours = hours;
        this.methodID = methodID;
        this.airTemp = airTemp;
        this.weatherID = weatherID;
        this.windID = windID;
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
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets user id.
     *
     * @param userID the user id
     */
    public void setUserID(int userID) {
        this.userID = userID;
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
     * Gets lake id.
     *
     * @return the lake id
     */
    public int getLakeID() {
        return lakeID;
    }

    /**
     * Sets lake id.
     *
     * @param lakeID the lake id
     */
    public void setLakeID(int lakeID) {
        this.lakeID = lakeID;
    }

    /**
     * Gets hours.
     *
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Sets hours.
     *
     * @param hours the hours
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Gets method id.
     *
     * @return the method id
     */
    public int getMethodID() {
        return methodID;
    }

    /**
     * Sets method id.
     *
     * @param methodID the method id
     */
    public void setMethodID(int methodID) {
        this.methodID = methodID;
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
     * Gets weather id.
     *
     * @return the weather id
     */
    public int getWeatherID() {
        return weatherID;
    }

    /**
     * Sets weather id.
     *
     * @param weatherID the weather id
     */
    public void setWeatherID(int weatherID) {
        this.weatherID = weatherID;
    }

    /**
     * Gets wind id.
     *
     * @return the wind id
     */
    public int getWindID() {
        return windID;
    }

    /**
     * Sets wind id.
     *
     * @param windID the wind id
     */
    public void setWindID(int windID) {
        this.windID = windID;
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
                "id=" + id +
                ", userID=" + userID +
                ", journalDate=" + journalDate +
                ", lakeID=" + lakeID +
                ", hours=" + hours +
                ", methodID=" + methodID +
                ", airTemp=" + airTemp +
                ", weatherID=" + weatherID +
                ", windID=" + windID +
                ", comments='" + comments + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", smallMouth1416=" + smallMouth1416 +
                ", smallMouth1619=" + smallMouth1619 +
                ", smallMouth19Plus=" + smallMouth19Plus +
                ", largeMouth1416=" + largeMouth1416 +
                ", largeMouth1619=" + largeMouth1619 +
                ", largeMouth19Plus=" + largeMouth19Plus +
                '}';
    }
}
