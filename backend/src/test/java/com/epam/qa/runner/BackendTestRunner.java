package com.epam.qa.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:features",
        glue = {"com/epam/qa/stepdefs/"},
        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"})
public class BackendTestRunner extends AbstractTestNGCucumberTests {

}
