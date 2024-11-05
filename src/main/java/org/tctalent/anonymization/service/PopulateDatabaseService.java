package org.tctalent.anonymization.service;

/**
 * Service which populates the database from data fetched over time from the TC server.
 *
 * @author John Cameron
 */
public interface PopulateDatabaseService {

    /**
     * Populates the database with anonymous records fetched from TC Server.
     *
     * @param percentageCPU a number from 1 to 100
     */
    void populateDatabase(int percentageCPU);

}
