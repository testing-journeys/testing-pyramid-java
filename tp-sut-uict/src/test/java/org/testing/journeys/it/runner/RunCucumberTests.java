package org.testing.journeys.it.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber.json, html:target/cucumber.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.testing.journeys.it, org.testing.journeys.it.stepdefs")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @WIP")
public class RunCucumberTests {
}
