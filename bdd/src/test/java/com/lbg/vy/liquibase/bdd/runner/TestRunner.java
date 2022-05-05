package com.lbg.vy.liquibase.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features"},
    glue = {"com.lbg.vy.liquibase.bdd.stepdefs"},
    tags = {"@test"},
    plugin = {
      "pretty",
      "html:target/cucumber-reports",
      "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
      "json:target/cucumber.json"
    })
public class TestRunner {}
