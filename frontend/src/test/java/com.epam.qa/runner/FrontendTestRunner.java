package com.epam.qa.runner;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "classpath:features",
        glue = {"com.epam.qa.stepdefs"})
public class FrontendTestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
    }

}
