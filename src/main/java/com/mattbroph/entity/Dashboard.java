package com.mattbroph.entity;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Calculates dashboard statistics from the user, journals and bass goals
 */
public class Dashboard {

    /** The user's bass count for the year */
    private int currentTotalBassCountForYear;
    /** The user's small mouth 14" - 16" count for the year */
    private int currentSmallMouth1416ForYear;
    /** The user's small mouth 16" - 19" count for the year */
    private int currentSmallMouth1619ForYear;
    /** The user's small mouth 19" plus count for the year */
    private int currentSmallMouth19PlusForYear;
    /** The user's large mouth 14" - 16" count for the year */
    private int currentLargeMouth1416ForYear;
    /** The user's large mouth 16" - 19" count for the year */
    private int currentLargeMouth1619ForYear;
    /** The user's large mouth 19" plus count for the year */
    private int currentLargeMouth19PlusForYear;
    /** The user's total hours fished for the year */
    private double currentTotalHoursForYear;
    /** The user's catch rate for the year */
    private double currentCatchRateForYear;
    /** The user's fishing trip history for the year */
    private Map<Integer, Integer> tripHistory;
    /** The user's number of times they went fishing for the year */
    private int currentTripTotalForYear;
    /** The user's fishing catch history for the year */
    private Map<Integer, Integer> catchHistory;
    /** The user's monthly catch goal for the year */
    private int monthlyCatchGoal;
    /** The dashboard's year list of journals */
    private List<Journal> journals;


    /**
     * Instantiates a new Dashboard.
     */
    public Dashboard() {
    }

    /**
     * Instantiates a new Dashboard.
     *
     * @param journals the journals
     */
    public Dashboard(List<Journal> journals) {
        this();
        this.journals = journals;
        this.tripHistory = new TreeMap<Integer, Integer>();
        this.catchHistory = new TreeMap<Integer, Integer>();
    }

    /**
     * Gets monthly catch goal.
     *
     * @return the monthly catch goal
     */
    public int getMonthlyCatchGoal() {
        return monthlyCatchGoal;
    }

    /**
     * Sets monthly catch goal.
     *
     * @param monthlyCatchGoal the monthly catch goal
     */
    public void setMonthlyCatchGoal(int monthlyCatchGoal) {
        this.monthlyCatchGoal = monthlyCatchGoal;
    }


    /**
     * Gets catch history.
     *
     * @return the catch history
     */
    public Map<Integer, Integer> getCatchHistory() {
        return catchHistory;
    }

    /**
     * Sets catch history.
     *
     * @param catchHistory the catch history
     */
    public void setCatchHistory(Map<Integer, Integer> catchHistory) {
        this.catchHistory = catchHistory;

    }

    /**
     * Gets current trip total for year.
     *
     * @return the current trip total for year
     */
    public int getCurrentTripTotalForYear() {
        return currentTripTotalForYear;
    }

    /**
     * Sets current trip total for year.
     *
     * @param currentTripTotalForYear the current trip total for year
     */
    public void setCurrentTripTotalForYear(int currentTripTotalForYear) {
        this.currentTripTotalForYear = currentTripTotalForYear;
    }

    /**
     * Gets trip history.
     *
     * @return the trip history
     */
    public Map<Integer, Integer> getTripHistory() {
        return tripHistory;
    }

    /**
     * Sets trip history.
     *
     * @param tripHistory the trip history
     */
    public void setTripHistory(Map<Integer, Integer> tripHistory) {
        this.tripHistory = tripHistory;
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

    /**
     * Gets current total hours for year.
     *
     * @return the current total hours for year
     */
    public double getCurrentTotalHoursForYear() {
        return currentTotalHoursForYear;
    }

    /**
     * Sets current total hours for year.
     *
     * @param currentTotalHoursForYear the current total hours for year
     */
    public void setCurrentTotalHoursForYear(double currentTotalHoursForYear) {
        this.currentTotalHoursForYear = currentTotalHoursForYear;
    }

    /**
     * Gets current catch rate for year.
     *
     * @return the current catch rate for year
     */
    public double getCurrentCatchRateForYear() {
        return currentCatchRateForYear;
    }

    /**
     * Sets current catch rate for year.
     *
     * @param currentCatchRateForYear the current catch rate for year
     */
    public void setCurrentCatchRateForYear(double currentCatchRateForYear) {
        this.currentCatchRateForYear = currentCatchRateForYear;
    }

    /**
     * Gets current total bass count for year.
     *
     * @return the current total bass count for year
     */
    public int getCurrentTotalBassCountForYear() {
        return currentTotalBassCountForYear;
    }

    /**
     * Sets current total bass count for year.
     *
     * @param currentTotalBassCountForYear the current total bass count for year
     */
    public void setCurrentTotalBassCountForYear(int currentTotalBassCountForYear) {
        this.currentTotalBassCountForYear = currentTotalBassCountForYear;
    }

    /**
     * Gets current small mouth 1416 for year.
     *
     * @return the current small mouth 1416 for year
     */
    public int getCurrentSmallMouth1416ForYear() {
        return currentSmallMouth1416ForYear;
    }

    /**
     * Sets current small mouth 1416 for year.
     *
     * @param currentSmallMouth1416ForYear the current small mouth 1416 for year
     */
    public void setCurrentSmallMouth1416ForYear(int currentSmallMouth1416ForYear) {
        this.currentSmallMouth1416ForYear = currentSmallMouth1416ForYear;
    }

    /**
     * Gets current small mouth 1619 for year.
     *
     * @return the current small mouth 1619 for year
     */
    public int getCurrentSmallMouth1619ForYear() {
        return currentSmallMouth1619ForYear;
    }

    /**
     * Sets current small mouth 1619 for year.
     *
     * @param currentSmallMouth1619ForYear the current small mouth 1619 for year
     */
    public void setCurrentSmallMouth1619ForYear(int currentSmallMouth1619ForYear) {
        this.currentSmallMouth1619ForYear = currentSmallMouth1619ForYear;
    }

    /**
     * Gets current small mouth 19 plus for year.
     *
     * @return the current small mouth 19 plus for year
     */
    public int getCurrentSmallMouth19PlusForYear() {
        return currentSmallMouth19PlusForYear;
    }

    /**
     * Sets current small mouth 19 plus for year.
     *
     * @param currentSmallMouth19PlusForYear the current small mouth 19 plus for year
     */
    public void setCurrentSmallMouth19PlusForYear(int currentSmallMouth19PlusForYear) {
        this.currentSmallMouth19PlusForYear = currentSmallMouth19PlusForYear;
    }

    /**
     * Gets current large mouth 1416 for year.
     *
     * @return the current large mouth 1416 for year
     */
    public int getCurrentLargeMouth1416ForYear() {
        return currentLargeMouth1416ForYear;
    }

    /**
     * Sets current large mouth 1416 for year.
     *
     * @param currentLargeMouth1416ForYear the current large mouth 1416 for year
     */
    public void setCurrentLargeMouth1416ForYear(int currentLargeMouth1416ForYear) {
        this.currentLargeMouth1416ForYear = currentLargeMouth1416ForYear;
    }

    /**
     * Gets current large mouth 1619 for year.
     *
     * @return the current large mouth 1619 for year
     */
    public int getCurrentLargeMouth1619ForYear() {
        return currentLargeMouth1619ForYear;
    }

    /**
     * Sets current large mouth 1619 for year.
     *
     * @param currentLargeMouth1619ForYear the current large mouth 1619 for year
     */
    public void setCurrentLargeMouth1619ForYear(int currentLargeMouth1619ForYear) {
        this.currentLargeMouth1619ForYear = currentLargeMouth1619ForYear;
    }

    /**
     * Gets current large mouth 19 plus for year.
     *
     * @return the current large mouth 19 plus for year
     */
    public int getCurrentLargeMouth19PlusForYear() {
        return currentLargeMouth19PlusForYear;
    }

    /**
     * Sets current large mouth 19 plus for year.
     *
     * @param currentLargeMouth19PlusForYear the current large mouth 19 plus for year
     */
    public void setCurrentLargeMouth19PlusForYear(int currentLargeMouth19PlusForYear) {
        this.currentLargeMouth19PlusForYear = currentLargeMouth19PlusForYear;
    }
}