package com.epam.qa.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:features/menu",
        glue = {"com.epam.qa.stepdefs"})
public class FrontendTestRunner extends AbstractTestNGCucumberTests {
}
