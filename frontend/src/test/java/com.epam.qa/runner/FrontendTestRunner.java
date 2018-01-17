package com.epam.qa.runner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.epam.qa.website.AmazonWebSite;
import com.epam.qa.config.EnvConfig;
import com.epam.qa.setup.WebSetup;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "classpath:features",
        glue = {"com.epam.qa.stepdefs"},
    plugin = {"pretty", "com.epam.qa.reporter.CucumberFrontendReporter"})
public class FrontendTestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() {
        WebSetup.init(AmazonWebSite.class);
        Configuration.browserSize = "1680x1050";
        Configuration.baseUrl = EnvConfig.get().getWebDomain();
    }

    @AfterSuite
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

}
