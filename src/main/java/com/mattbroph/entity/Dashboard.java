package com.mattbroph.entity;


import java.util.List;

/**
 * Calculates dashboard statistics from the user, journals and bass goals
 */
public class Dashboard {

    /**
     * The user's bass count for the year
     */
    private int currentBassCountForYear;

    /** The user's small mouth 14" - 16" count for the year */
    private int currentSmallMouth1416ForYear;


    /**
     * Calculates the current small mouth size 14" - 16" for the year
     */
     public int getCurrentSmallMouth1416ForYear(){

        currentSmallMouth1416ForYear = 0;

        for (Journal journal : journals) {
            currentSmallMouth1416ForYear += journal.getSmallMouth1416();
        }

        return currentSmallMouth1416ForYear;
     }




    /**
     * The dashboards year list of journals
     */
    private List<Journal> journals;


    public Dashboard() {
    }

    public Dashboard(List<Journal> journals) {
        this.journals = journals;
    }


    public int getCurrentBassCountForYear() {

        currentBassCountForYear = 0;

        for (Journal journal : journals) {
            currentBassCountForYear += journal.getTotalBassCount();
        }
        return currentBassCountForYear;
    }
}
