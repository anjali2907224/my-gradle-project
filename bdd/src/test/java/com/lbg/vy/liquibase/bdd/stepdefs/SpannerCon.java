package com.lbg.vy.liquibase.bdd.stepdefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SpannerCon {
    public static Connection UseSpannerConnection() throws SQLException {
        final String projectId = "sbs-ctl-bld-01-54a6";
        final String instanceId = "sbs-ctl-bld-01-spi-euwe2-tlng";
        final String databaseId = "feature-flag-unleash-spd";


        final String connectionUrl = String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                projectId, instanceId, databaseId);

        Connection connection = DriverManager.getConnection(connectionUrl);

        return connection;
    }
}
