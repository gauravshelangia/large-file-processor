package com.postman.file.processor;

public interface DataAggregator {

    /*
    * fetch aggregate result and store them in separate table.
    */
    void aggregateByNameAndThenStore() throws InterruptedException;
}
