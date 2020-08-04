package com.postman.file.processor;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static HikariConfig config = new HikariConfig("db.properties");
    private static HikariDataSource ds;

    static {
//        config.setJdbcUrl( "jdbc:mysql://localhost:3306/postman" );
//        config.setUsername( "root" );
//        config.setPassword( "root" );
//        config.addDataSourceProperty( "cachePrepStmts" , "true" );
//        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
//        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
//        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        ds = new HikariDataSource( config );
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}