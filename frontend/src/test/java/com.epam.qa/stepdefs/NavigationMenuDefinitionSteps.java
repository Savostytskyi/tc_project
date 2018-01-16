package com.epam.qa.stepdefs;

import com.codeborne.selenide.Condition;
import cucumber.api.java8.En;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NavigationMenuDefinitionSteps implements En {

    public NavigationMenuDefinitionSteps() {

        Given("I am on Home page", () ->
            open("https://www.amazon.com"));

        When("I select 'Gift Cards' menu item", () ->
            $("a[tabindex='50']").click());

        Then("Gift Cards page opened", () ->
            $("img[alt='Gift Cards']").shouldBe(Condition.visible));

    }
}
