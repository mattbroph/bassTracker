package com.mattbroph.entity;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Holds the profile statistics from the user, journals and bass goals
 */
public class ProfileStats {


    /** The user's small mouth 14" - 16" count for the user */
    private int currentSmallMouth1416ForUser;
    /** The user's small mouth 16" - 19" count for the user */
    private int currentSmallMouth1619ForUser;
    /** The user's small mouth 19" plus count for the user */
    private int currentSmallMouth19PlusForUser;
    /** The user's large mouth 14" - 16" count for the user */
    private int currentLargeMouth1416ForUser;
    /** The user's large mouth 16" - 19" count for the user */
    private int currentLargeMouth1619ForUser;
    /** The user's large mouth 19" plus count for the user */
    private int currentLargeMouth19PlusForUser;

    /** The user's bass count for the user */
    private int currentTotalBassCountForUser;   
    /** The user's total hours fished for the user */
    private double currentTotalHoursForUser;
    /** The user's catch rate for the user */
    private double currentCatchRateForUser;    
    /** The user's complete list of journals */
    private List<Journal> journals;

    /**
     * Instantiates a new ProfileStats.
     */
    public ProfileStats() {
    }

    /**
     * Instantiates a new ProfileStats.
     *
     * @param journals the journals
     */
    public ProfileStats(List<Journal> journals) {
        this();
        this.journals = journals;
    }


    /**
     * Gets current small mouth 1416 for user.
     *
     * @return the current small mouth 1416 for user
     */
    public int getCurrentSmallMouth1416ForUser() {
        return currentSmallMouth1416ForUser;
    }

    /**
     * Sets current small mouth 1416 for user.
     *
     * @param currentSmallMouth1416ForUser the current small mouth 1416 for user
     */
    public void setCurrentSmallMouth1416ForUser(int currentSmallMouth1416ForUser) {
        this.currentSmallMouth1416ForUser = currentSmallMouth1416ForUser;
    }

    /**
     * Gets current small mouth 1619 for user.
     *
     * @return the current small mouth 1619 for user
     */
    public int getCurrentSmallMouth1619ForUser() {
        return currentSmallMouth1619ForUser;
    }

    /**
     * Sets current small mouth 1619 for user.
     *
     * @param currentSmallMouth1619ForUser the current small mouth 1619 for user
     */
    public void setCurrentSmallMouth1619ForUser(int currentSmallMouth1619ForUser) {
        this.currentSmallMouth1619ForUser = currentSmallMouth1619ForUser;
    }

    /**
     * Gets current small mouth 19 plus for user.
     *
     * @return the current small mouth 19 plus for user
     */
    public int getCurrentSmallMouth19PlusForUser() {
        return currentSmallMouth19PlusForUser;
    }

    /**
     * Sets current small mouth 19 plus for user.
     *
     * @param currentSmallMouth19PlusForUser the current small mouth 19 plus for user
     */
    public void setCurrentSmallMouth19PlusForUser(int currentSmallMouth19PlusForUser) {
        this.currentSmallMouth19PlusForUser = currentSmallMouth19PlusForUser;
    }

    /**
     * Gets current large mouth 1416 for user.
     *
     * @return the current large mouth 1416 for user
     */
    public int getCurrentLargeMouth1416ForUser() {
        return currentLargeMouth1416ForUser;
    }

    /**
     * Sets current large mouth 1416 for user.
     *
     * @param currentLargeMouth1416ForUser the current large mouth 1416 for user
     */
    public void setCurrentLargeMouth1416ForUser(int currentLargeMouth1416ForUser) {
        this.currentLargeMouth1416ForUser = currentLargeMouth1416ForUser;
    }

    /**
     * Gets current large mouth 1619 for user.
     *
     * @return the current large mouth 1619 for user
     */
    public int getCurrentLargeMouth1619ForUser() {
        return currentLargeMouth1619ForUser;
    }

    /**
     * Sets current large mouth 1619 for user.
     *
     * @param currentLargeMouth1619ForUser the current large mouth 1619 for user
     */
    public void setCurrentLargeMouth1619ForUser(int currentLargeMouth1619ForUser) {
        this.currentLargeMouth1619ForUser = currentLargeMouth1619ForUser;
    }

    /**
     * Gets current large mouth 19 plus for user.
     *
     * @return the current large mouth 19 plus for user
     */
    public int getCurrentLargeMouth19PlusForUser() {
        return currentLargeMouth19PlusForUser;
    }

    /**
     * Sets current large mouth 19 plus for user.
     *
     * @param currentLargeMouth19PlusForUser the current large mouth 19 plus for user
     */
    public void setCurrentLargeMouth19PlusForUser(int currentLargeMouth19PlusForUser) {
        this.currentLargeMouth19PlusForUser = currentLargeMouth19PlusForUser;
    }

    /**
     * Gets current total bass count for user.
     *
     * @return the current total bass count for user
     */
    public int getCurrentTotalBassCountForUser() {
        return currentTotalBassCountForUser;
    }

    /**
     * Sets current total bass count for user.
     *
     * @param currentTotalBassCountForUser the current total bass count for user
     */
    public void setCurrentTotalBassCountForUser(int currentTotalBassCountForUser) {
        this.currentTotalBassCountForUser = currentTotalBassCountForUser;
    }

    /**
     * Gets current total hours for user.
     *
     * @return the current total hours for user
     */
    public double getCurrentTotalHoursForUser() {
        return currentTotalHoursForUser;
    }

    /**
     * Sets current total hours for user.
     *
     * @param currentTotalHoursForUser the current total hours for user
     */
    public void setCurrentTotalHoursForUser(double currentTotalHoursForUser) {
        this.currentTotalHoursForUser = currentTotalHoursForUser;
    }

    /**
     * Gets current catch rate for user.
     *
     * @return the current catch rate for user
     */
    public double getCurrentCatchRateForUser() {
        return currentCatchRateForUser;
    }

    /**
     * Sets current catch rate for user.
     *
     * @param currentCatchRateForUser the current catch rate for user
     */
    public void setCurrentCatchRateForUser(double currentCatchRateForUser) {
        this.currentCatchRateForUser = currentCatchRateForUser;
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
}