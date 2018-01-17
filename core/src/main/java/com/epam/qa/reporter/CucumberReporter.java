package com.epam.qa.reporter;

import com.epam.reportportal.cucumber.AbstractReporter;
import com.epam.reportportal.cucumber.Utils;
import com.epam.ta.reportportal.ws.model.StartTestItemRQ;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Step;
import io.reactivex.Maybe;
import lombok.extern.log4j.Log4j;
import rp.com.google.common.base.Supplier;
import rp.com.google.common.base.Suppliers;

import java.util.Calendar;

import static com.epam.reportportal.cucumber.Utils.extractTags;

@Log4j
public class CucumberReporter extends AbstractReporter {

    private static final String SEPARATOR = "-------------------------";

    protected Supplier<Maybe<String>> rootSuiteId = Suppliers.memoize(() -> {
        StartTestItemRQ rq = new StartTestItemRQ();
        rq.setName("Features");
        rq.setStartTime(Calendar.getInstance().getTime());
        rq.setType("STORY");
        return RP.get().startTestItem(rq);
    });

    @Override
    protected void beforeFeature(Feature feature) {
        String[] featurePath = currentFeatureUri.split("/");
        StartTestItemRQ rq = new StartTestItemRQ();
        Maybe<String> root = getRootItemId();
        rq.setDescription(Utils.buildStatementName(feature, null, AbstractReporter.COLON_INFIX, null));
        rq.setName(featurePath[featurePath.length -1]);
        rq.setTags(extractTags(feature.getTags()));
        rq.setStartTime(Calendar.getInstance().getTime());
        rq.setType(getFeatureTestItemType());
        if (null == root) {
            currentFeatureId = RP.get().startTestItem(rq);
        } else {
            currentFeatureId = RP.get().startTestItem(root, rq);
        }

    }

    @Override
    protected void beforeStep(Step step) {
        String decoratedStepName = decorateMessage(Utils.buildStatementName(step, stepPrefix, " ", null));
        String multilineArg = Utils.buildMultilineArgument(step);
        Utils.sendLog(decoratedStepName + multilineArg, "INFO", null);
    }

    @Override
    protected void afterStep(Result result) {
        reportResult(result, decorateMessage("STEP " + result.getStatus().toUpperCase()));
    }

    @Override
    protected void beforeHooks(Boolean isBefore) {
        // noop
    }

    @Override
    protected void afterHooks(Boolean isBefore) {
        // noop
    }

    @Override
    protected void hookFinished(Match match, Result result, Boolean isBefore) {
        reportResult(result, null);
    }

    @Override
    protected String getFeatureTestItemType() {
        return "TEST";
    }

    @Override
    protected String getScenarioTestItemType() {
        return "STEP";
    }


    @Override
    protected Maybe<String> getRootItemId() {
        return rootSuiteId.get();
    }

    @Override
    protected void afterLaunch() {
        Utils.finishTestItem(RP.get(), rootSuiteId.get());
        rootSuiteId = null;

        super.afterLaunch();
    }

    /**
     * Add separators to log item to distinguish from real log messages
     *
     * @param message to decorate
     * @return decorated message
     */
    protected String decorateMessage(String message) {
        return CucumberReporter.SEPARATOR + message + CucumberReporter.SEPARATOR;
    }
}
