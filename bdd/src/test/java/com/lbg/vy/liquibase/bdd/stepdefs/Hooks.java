package com.lbg.vy.liquibase.bdd.stepdefs;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.io.*;
import java.nio.file.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
  private static final Logger CURL_LOG = LoggerFactory.getLogger("curl");

  String logFolder = "logs";

}
