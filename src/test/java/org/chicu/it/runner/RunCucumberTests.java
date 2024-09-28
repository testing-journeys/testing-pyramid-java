package org.chicu.it.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber.json, html:target/cucumber.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.chicu.it, org.chicu.it.stepdefs")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @WIP")
public class RunCucumberTests {
}
