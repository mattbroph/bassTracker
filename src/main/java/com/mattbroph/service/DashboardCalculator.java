package com.mattbroph.service;

import com.mattbroph.entity.Dashboard;
import com.mattbroph.entity.Journal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Calculates dashboard statistics from the user, journals and bass goals
 */
public class DashboardCalculator {

    /**
     * Calculates dashboard statistics and assigns values to instance variables
     */
    public void calculateStatistics(Dashboard dashboard, int userBassGoal) {

        // Get the list journals to evaluate
        List<Journal> journals = dashboard.getJournals();
        // Get the trip and catch history tree maps
        Map<Integer, Integer> tripHistory = dashboard.getTripHistory();
        Map<Integer, Integer> catchHistory = dashboard.getCatchHistory();

        // Load the maps with all the months of the year
        loadTripHistory(tripHistory);
        loadCatchHistory(catchHistory);

        // Run the calculations for each journal
        for (Journal journal : journals) {

            calculateCurrentBassCountsForYear(dashboard, journal);
            calculateTotalHours(dashboard, journal);
            calculateTripHistory(dashboard, journal);
            calculateCatchHistory(dashboard, journal);
        }

        // Calculate the catch rate after total hours and total bass count is determined
        calculateCatchRate(dashboard);
        // Calculate the monthly bass goals
        calculateMonthlyBassGoal(dashboard, userBassGoal);

        // Set the trip history after all processing is complete
        dashboard.setTripHistory(tripHistory);
        // Set the total amount of trips for the trip history chart
        int totalTrips = journals.size();
        dashboard.setCurrentTripTotalForYear(totalTrips);
     }


    /**
     * Calculates the monthly bass goal catch count for the catch history
     * chart on the dashboard
     */
    private void calculateMonthlyBassGoal(Dashboard dashboard, int userBassGoal) {

        final int monthsPerYear = 12;
        int monthlyCatchGoal = userBassGoal / monthsPerYear;

        dashboard.setMonthlyCatchGoal(monthlyCatchGoal);

    }

    /**
     * Totals up the catch history per month
     */
    private void calculateCatchHistory(Dashboard dashboard, Journal journal) {

        int journalBassCount;
        int bassCountByMonth;

        // Get the now loaded trip history map
        Map<Integer, Integer> catchHistory = dashboard.getCatchHistory();

        // Count how many total fish in the journal
        // Determine the journal month and add it to that map

        // Get the journals date
        LocalDate journalDate = journal.getJournalDate();
        // Derive the month from the local date
        int journalMonth = journalDate.getMonthValue();
        // Sum up the total bass for this journal entry
        journalBassCount = journal.getTotalBassCount();
        // Get the current fish count for the month and this journals count to it
        bassCountByMonth = catchHistory.get(journalMonth) + journalBassCount;
        // Update the map with the new count
        catchHistory.put(journalMonth, bassCountByMonth);
    }

    /**
     * Totals up the trip history per month
     */
    private void calculateTripHistory(Dashboard dashboard, Journal journal) {

        int monthCount;

        // Get the now loaded trip history map
        Map<Integer, Integer> tripHistory = dashboard.getTripHistory();

        // Add a count of one to each month that a journal entry occurred by:

        // Get the journals date
        LocalDate journalDate = journal.getJournalDate();
        // Derive the month from the local date
        int journalMonth = journalDate.getMonthValue();
        // Get the current month count and add 1 to it
        monthCount = tripHistory.get(journalMonth) + 1;
        // Update the map with the new count
        tripHistory.put(journalMonth, monthCount);

    }


    /**
     * Loads the catch history tree map with each month of the year and starts
     * each count at 0
     */
    private void loadCatchHistory(Map<Integer, Integer> catchHistory) {

        int numberOfMonths = 12;

        // 1-12 is the month - which will be returned by localDate.getMonth()
        for (int index = 1; index <= numberOfMonths; index++) {

            catchHistory.put(index, 0);
        }
    }


    /**
    * Loads the trip history tree map with each month of the year and starts
    * each count at 0
    */
    private void loadTripHistory(Map<Integer, Integer> tripHistory) {

        int numberOfMonths = 12;

        // 1-12 is the month - which will be returned by localDate.getMonth()
        for (int index = 1; index <= numberOfMonths; index++) {

            tripHistory.put(index, 0);
        }
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