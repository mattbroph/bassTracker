package com.mattbroph.service;

import com.mattbroph.entity.Journal;
import com.mattbroph.entity.ProfileStats;
import java.util.List;


/**
 * Calculates profile statistics from the user and their journals
 */
public class ProfileStatsCalculator {

    /**
     * Calculates profile statistics and assigns values to instance variables
     *
     * @param profileStats holds the users total stats
     */
    public void calculateStatistics(ProfileStats profileStats) {

        // Get the list journals to evaluate
        List<Journal> journals = profileStats.getJournals();

        // Run the calculations for each journal
        for (Journal journal : journals) {

            calculateTotalBassCounts(profileStats, journal);
            calculateTotalHours(profileStats, journal);

        }
        // Calculate the catch rate after total hours and total bass count is determined
        calculateCatchRate(profileStats);

     }

     
    /**
     * Calculates the total bass counts for the user by adding each journal's
     * count to the total.
     *
     * @param profileStats holds the users total stats
     * @param journal the journal
     */
    private void calculateTotalBassCounts(ProfileStats profileStats,
            Journal journal) {

        // Get the current count and add the journal's count
        int smallMouth1416 =  profileStats.getCurrentSmallMouth1416ForUser()
                + journal.getSmallMouth1416();

        int smallMouth1619 = profileStats.getCurrentSmallMouth1619ForUser()
                + journal.getSmallMouth1619();

        int smallMouth19Plus = profileStats.getCurrentSmallMouth19PlusForUser()
                + journal.getSmallMouth19Plus();

        int largeMouth1416 =  profileStats.getCurrentLargeMouth1416ForUser()
                + journal.getLargeMouth1416();

        int largeMouth1619 = profileStats.getCurrentLargeMouth1619ForUser()
                + journal.getLargeMouth1619();

        int largeMouth19Plus = profileStats.getCurrentLargeMouth19PlusForUser()
                + journal.getLargeMouth19Plus();

        int totalBass = profileStats.getCurrentTotalBassCountForUser()
                + journal.getTotalBassCount();

        // Set the instance variables values in the ProfileStats object
        profileStats.setCurrentSmallMouth1416ForUser(smallMouth1416);
        profileStats.setCurrentSmallMouth1619ForUser(smallMouth1619);
        profileStats.setCurrentSmallMouth19PlusForUser(smallMouth19Plus);
        profileStats.setCurrentLargeMouth1416ForUser(largeMouth1416);
        profileStats.setCurrentLargeMouth1619ForUser(largeMouth1619);
        profileStats.setCurrentLargeMouth19PlusForUser(largeMouth19Plus);
        profileStats.setCurrentTotalBassCountForUser(totalBass);
    }

    /**
     * Calculates the total hours the user has fished
     *
     * @param profileStats holds the users total stats
     * @param journal the journal
     */
    private void calculateTotalHours(ProfileStats profileStats,
             Journal journal) {

        // Get the current hours count and add the journal's count
         double totalHours = profileStats.getCurrentTotalHoursForUser()
                + journal.getHours();

         // Set the instance variable value in the ProfileStats object
        profileStats.setCurrentTotalHoursForUser(totalHours);
     }

    /**
     * Calculates the total catch rate for the user and rounds it to 2 decimals
     *
     * @param profileStats holds the users total stats
     */
    private void calculateCatchRate(ProfileStats profileStats) {

        // Get the current bass count and hours for the user
        double bassCount = profileStats.getCurrentTotalBassCountForUser();
        double hours = profileStats.getCurrentTotalHoursForUser();

        // Divide bassCount by hours
         double currentCatchRateForUser
                = Math.round((bassCount / hours) * 100.0) / 100.0;

        // Set the instance variable value in the Dashboard class
        profileStats.setCurrentCatchRateForUser(currentCatchRateForUser);
     }

}