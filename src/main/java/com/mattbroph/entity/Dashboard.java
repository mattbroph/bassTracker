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
