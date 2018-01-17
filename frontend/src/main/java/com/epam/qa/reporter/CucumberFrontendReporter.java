package com.epam.qa.reporter;

import com.epam.reportportal.message.ReportPortalMessage;
import gherkin.formatter.model.Result;
import lombok.extern.log4j.Log4j;

import java.io.IOException;

import static com.codeborne.selenide.Screenshots.getLastScreenshot;

@Log4j
public class CucumberFrontendReporter extends CucumberReporter {

    @Override
    protected void afterStep(Result result) {
        reportResult(result, decorateMessage("STEP " + result.getStatus().toUpperCase()));
        if (result.getStatus().toUpperCase().equals("FAILED")) {
            try {
                ReportPortalMessage message = new ReportPortalMessage(getLastScreenshot(), "Screenshot:");
                log.info(message);
            } catch (IOException e) {
                log.warn("Can't find screenshot file...");
            }
        }
    }
}
