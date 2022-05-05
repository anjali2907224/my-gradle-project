package com.lbg.vy.liquibase.bdd.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.google.common.truth.Truth.assertThat;
import static com.lbg.vy.liquibase.bdd.stepdefs.SpannerCon.UseSpannerConnection;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LiquibaseStepDef {

    @Given("I Get the Table Name from spanner")
    public void iGetTheTableData() throws Exception {
        try (Statement statement = UseSpannerConnection().createStatement()) {
            try (ResultSet rs =
                         statement.executeQuery(
                                 "SELECT name, description FROM TestService where name='applicationHostname'")) {
                while (rs.next()) {
                    System.out.printf("%s %s%n", rs.getString(1), rs.getString(2));
                    assertEquals("applicationHostname", rs.getString(1));
                    assertEquals("Active", rs.getString(2));
                }

            }
        }

    }

    @Given("I Get the New Table Name from spanner")
    public void iGetNewTheTableData() throws Exception {
        try (Statement statement = UseSpannerConnection().createStatement()) {
            try (ResultSet rs =
                         statement.executeQuery(
                                 "SELECT name, description FROM TestService where name='applicationHostname")) {
                while (rs.next()) {
                    System.out.printf("%s %s%n", rs.getString(1), rs.getString(2));
                    assertEquals("applicationHostname", rs.getString(1));
                    assertEquals("Active", rs.getString(2));
                }

            }
        }

    }

    @Given("Spanner Table Created by liquibase changeset")
    public void iCheckSpannr() throws Exception {
        try (Statement statement = UseSpannerConnection().createStatement()) {
            try (ResultSet rs =
                         statement.executeQuery(
                                 "SELECT TABLE_NAME FROM information_schema.tables WHERE table_name='Demo'")) {

                while (rs.next()) {
                    System.out.printf("%s%n", rs.getString(1));
                    assertEquals("Demo", rs.getString(1));
                }
            }
        }
    }

    @Then("Verify Table exists in Spanner")
    public void dOVerifyTableCheckSpanner() throws SQLException {
        try (Statement statement = UseSpannerConnection().createStatement()) {
            try (ResultSet rs =
                         statement.executeQuery(
                                 "SELECT TABLE_NAME FROM information_schema.tables WHERE table_name='Demo'")) {

                while (rs.next()) {
                    System.out.printf("%s%n", rs.getString(1));
                    assertEquals("Demo", rs.getString(1));
                }
            }
        }
    }

    @Then("Verify data exists in Table")
    public void dOVerifyDataExistCheckSpanner() throws Exception {
        try (Statement statement = UseSpannerConnection().createStatement()) {
            try (ResultSet rs =
                         statement.executeQuery(
                                 "SELECT name FROM Demo WHERE description='Down'")) {

                while (rs.next()) {
                    System.out.printf("%s%n", rs.getString(1));
                    assertEquals("applicationHostname", rs.getString(1));
                }
            }
        }
    }

    @Then("Verify data updated in Table")
    public void dOVerifyDataUpdateCheckSpanner() throws Exception {
        try (Statement statement = UseSpannerConnection().createStatement()) {
            try (ResultSet rs =
                         statement.executeQuery(
                                 "SELECT name FROM BDDTest WHERE name='default'")) {

                while (rs.next()) {
                    System.out.printf("%s%n", rs.getString(1));
                    assertEquals("BDD", rs.getString(1));
                }
            }
        }
    }

    @Then("Verify rows deleted in Table")
    public void dOVerifyDataDeleteCheckSpanner() throws Exception {
        try (Statement statement = UseSpannerConnection().createStatement()) {
            try (ResultSet rs =
                         statement.executeQuery(
                                 "SELECT COUNT(*) FROM BDDTest WHERE name='DoNotUse'")) {
                while (rs.next()) {
                    System.out.printf("%s%n", rs.getString(1));
                    assertThat(rs.getString(1)).isEqualTo(0L);
                }
            }
        }
    }

    @Then("Verify table deleted in spanner")
    public void dOVerifyDataCheckSpanner() throws Exception {
        try (Statement statement = UseSpannerConnection().createStatement()) {
            try (ResultSet rs =
                         statement.executeQuery(
                                 "SELECT TABLE_NAME FROM information_schema.tables WHERE table_name='BDDTest'")) {
                while (rs.next()) {
                    System.out.printf("%s%n", rs.getString(1));
                    assertThat(rs.getString(1)).isEqualTo(0L);
                }
            }
        }

    }

}

