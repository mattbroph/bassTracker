package com.mattbroph.persistance;


import com.mattbroph.entity.Dashboard;
import com.mattbroph.entity.Journal;

import java.util.List;

/**
 * Calculates dashboard statistics from the user, journals and bass goals
 */
public class DashboardCalculator {


    /**
     * Calculates dashboard statistics and assigns values to instance variables
     */
    public void calculateStatistics(Dashboard dashboard) {

        List<Journal> journals = dashboard.getJournals();

        for (Journal journal : journals) {

            calculateCurrentBassCountsForYear(dashboard, journal);
            calculateTotalHours(dashboard, journal);

        }

        calculateCatchRate(dashboard);

     }


    /**
     * Calculates the current bass counts for the year by adding each journal's
     * count to the total.
     *
     * @param journal the journal
     */
    private void calculateCurrentBassCountsForYear(Dashboard dashboard,
            Journal journal) {

        // Get the current count and add the journal's count
        int smallMouth1416 =  dashboard.getCurrentSmallMouth1416ForYear()
                + journal.getSmallMouth1416();

        int smallMouth1619 = dashboard.getCurrentSmallMouth1619ForYear()
                + journal.getSmallMouth1619();

        int smallMouth19Plus = dashboard.getCurrentSmallMouth19PlusForYear()
                + journal.getSmallMouth19Plus();

        int largeMouth1416 =  dashboard.getCurrentLargeMouth1416ForYear()
                + journal.getLargeMouth1416();

        int largeMouth1619 = dashboard.getCurrentLargeMouth1619ForYear()
                + journal.getLargeMouth1619();

        int largeMouth19Plus = dashboard.getCurrentLargeMouth19PlusForYear()
                + journal.getLargeMouth19Plus();

        int totalBass = dashboard.getCurrentTotalBassCountForYear()
                + journal.getTotalBassCount();


        // Set the instance variables values in the Dashboard class
        dashboard.setCurrentSmallMouth1416ForYear(smallMouth1416);
        dashboard.setCurrentSmallMouth1619ForYear(smallMouth1619);
        dashboard.setCurrentSmallMouth19PlusForYear(smallMouth19Plus);
        dashboard.setCurrentLargeMouth1416ForYear(largeMouth1416);
        dashboard.setCurrentLargeMouth1619ForYear(largeMouth1619);
        dashboard.setCurrentLargeMouth19PlusForYear(largeMouth19Plus);
        dashboard.setCurrentTotalBassCountForYear(totalBass);

    }

    /**
     * Calculates the total hours for the year
     *
     * @param dashboard the dashboard
     * @param journal the journal
     */
    private void calculateTotalHours(Dashboard dashboard, Journal journal) {

        // Get the current hours count and add the journal's count
         double totalHours = dashboard.getCurrentTotalHoursForYear()
                + journal.getHours();

         // Set the instance variable value in the Dashboard class
         dashboard.setCurrentTotalHoursForYear(totalHours);

     }

    /**
     * Calculates the catch rate for the year and rounds it to 2 decimals
     */
    private void calculateCatchRate(Dashboard dashboard) {

        // Get the current bass count and hours for the year
        double bassCount = dashboard.getCurrentTotalBassCountForYear();
        double hours = dashboard.getCurrentTotalHoursForYear();

        // Divide bassCount by hours
         double currentCatchRateForYear
                = Math.round((bassCount / hours) * 100.0) / 100.0;

        // Set the instance variable value in the Dashboard class
        dashboard.setCurrentCatchRateForYear(currentCatchRateForYear);

     }

}