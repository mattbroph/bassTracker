package com.mattbroph.entity;


import java.util.List;

/**
 * Calculates dashboard statistics from the user, journals and bass goals
 */
public class Dashboard {

    /**
     * The user's bass count for the year
     */
    private int currentTotalBassCountForYear;

    /** The user's small mouth 14" - 16" count for the year */
    private int currentSmallMouth1416ForYear;

    private int currentSmallMouth1619ForYear;

    private int currentSmallMouth19PlusForYear;

    private int currentLargeMouth1416ForYear;

    private int currentLargeMouth1619ForYear;

    private int currentLargeMouth19PlusForYear;

    private int currentTotalHoursForYear;

    private double currentCatchRateForYear;




    /**
     * The dashboards year list of journals
     */
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
        this.journals = journals;
        calculateStatistics();
    }


    /**
     * Calculates dashboard statistics and assigns values to instance variables
     */
    public void calculateStatistics() {

        resetCounts();

        for (Journal journal : journals) {

            calculateCurrentBassCountsForYear(journal);
            calculateTotalHours(journal);

        }

        calculateCatchRate();

     }


    /**
     * Calculates the current bass counts for the year
     *
     * @param journal the journal
     */
    public void calculateCurrentBassCountsForYear(Journal journal) {

            currentSmallMouth1416ForYear += journal.getSmallMouth1416();
            currentSmallMouth1619ForYear += journal.getSmallMouth1619();
            currentSmallMouth19PlusForYear += journal.getSmallMouth19Plus();
            currentLargeMouth1416ForYear += journal.getLargeMouth1416();
            currentLargeMouth1619ForYear += journal.getLargeMouth1619();
            currentLargeMouth19PlusForYear += journal.getLargeMouth19Plus();
            currentTotalBassCountForYear += journal.getTotalBassCount();
        }

    /**
     * Calculates the total hours for the year
     *
     * @param journal the journal
     */
    public void calculateTotalHours(Journal journal) {

         currentTotalHoursForYear += journal.getHours();

     }

    /**
     * Initializes and resets all counts to 0 prior to calculations
     */
    public void resetCounts() {

         currentSmallMouth1416ForYear = 0;
         currentSmallMouth1619ForYear = 0;
         currentSmallMouth19PlusForYear = 0;
         currentLargeMouth1416ForYear = 0;
         currentLargeMouth1619ForYear = 0;
         currentLargeMouth19PlusForYear = 0;
         currentTotalBassCountForYear = 0;

         currentTotalHoursForYear = 0;

         currentCatchRateForYear = 0;

     }

    /**
     * Calculates the catch rate for the year and rounds it to 2 decimals
     */
    public void calculateCatchRate() {

         currentCatchRateForYear = Math.round(((double)
                 currentTotalBassCountForYear / currentTotalHoursForYear)
                  * 100.0) / 100.0;

     }








    /**
     * Gets current total hours for year.
     *
     * @return the current total hours for year
     */
    public int getCurrentTotalHoursForYear() {
        return currentTotalHoursForYear;
    }

    /**
     * Sets current total hours for year.
     *
     * @param currentTotalHoursForYear the current total hours for year
     */
    public void setCurrentTotalHoursForYear(int currentTotalHoursForYear) {
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