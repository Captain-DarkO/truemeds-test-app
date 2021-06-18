package com.truemeds.testanurag.service;

/**
 * Batch service to perform batch reduce operations
 */
public interface BatchService {

    /**
     * Reads input data from DB, cleans the data and stores result in output table
     */
    void doCleanup();
}
