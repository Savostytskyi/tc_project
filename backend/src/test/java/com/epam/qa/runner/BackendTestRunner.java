package com.epam.qa.runner;

import com.epam.qa.config.EnvConfig;
import com.epam.qa.setup.RestServiceInit;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "classpath:features",
        glue = {"com/epam/qa/stepdefs/"},
        plugin = {"pretty", "com.epam.qa.reporter.CucumberReporter"})
public class BackendTestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        RestServiceInit.baseDomain = EnvConfig.get().getApiUrl();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {

    }

}
