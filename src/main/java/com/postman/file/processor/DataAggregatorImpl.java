package com.postman.file.processor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAggregatorImpl implements DataAggregator{
    Connection connection;

    public DataAggregatorImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void aggregateByNameAndThenStore() throws InterruptedException {
        String aggregate_statement = "insert into product_aggregation (`product_name`, `count`) " +
                " select name, count(*) as count from product p group by name " +
                "ON DUPLICATE KEY UPDATE `product_name` = VALUES(product_name), count = count;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(aggregate_statement);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            System.out.println("Some error occurred and storing the results" + throwables);
            System.out.println("retrying the aggregation");
            Thread.sleep(10000);
            aggregateByNameAndThenStore();
        }
    }
}
