Feature: Liquibase Spanner Verify on GCP @DEMO

  @demo
  Scenario: Spanner Real Sanity Check
    Given I Get the Table Name from spanner

  @demo
  Scenario: Verify DDL Table is created in Spanner
    Given Spanner Table Created by liquibase changeset
    Then  Verify Table exists in Spanner

  @demo
  Scenario: Verify DML INSERT in Spanner
    Given Spanner Table Created by liquibase changeset
    Then  Verify data exists in Table