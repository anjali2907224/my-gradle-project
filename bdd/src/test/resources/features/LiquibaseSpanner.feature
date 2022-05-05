Feature: Liquibase Spanner Verify on GCP


  Scenario: Spanner Real Sanity Check
    Given I Get the Table Name from spanner

  Scenario: Spanner Real Sanity Check
    Given I Get the New Table Name from spanner

  Scenario: Verify DDL Table is created in Spanner
    Given Spanner Table Created by liquibase changeset
    Then  Verify Table exists in Spanner

  Scenario: Verify DDL Table is Rename in Spanner
    Given Spanner Table Created by liquibase changeset
    Then  Verify Rename Table exists in Spanner

  Scenario: Verify DDL Table is Alter in Spanner
    Given Spanner Table Created by liquibase changeset
    Then  Verify Alter Table exists in Spanner

  Scenario: Verify DML INSERT in Spanner
    Given Spanner Table Created by liquibase changeset
    Then  Verify data exists in Table

  Scenario: Verify DML UPDATE in Spanner
    Given Spanner Table Created by liquibase changeset
    Then  Verify data updated in Table

  Scenario: Verify DML DELETE rows in Spanner
    Given Spanner Table Created by liquibase changeset
    Then  Verify rows deleted in Table

  Scenario: Verify DML MERGE table in Spanner
    Given Spanner Table Created by liquibase changeset
    Then  Verify Merge Table exists in Spanner

  Scenario: Verify DROP Foriegn Keys in table
    Given Spanner Table Created by liquibase changeset
    Then  Verify Merge Table exists in Spanner

