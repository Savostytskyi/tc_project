package com.epam.qa.stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.epam.qa.website.AmazonWebSite;
import cucumber.api.java8.En;

import static com.codeborne.selenide.Selenide.open;

public class NavigationMenuDefinitionSteps implements En {

    public NavigationMenuDefinitionSteps() {

        Given("I am on Home page", () ->
            open(Configuration.baseUrl));

        When("I select 'Gift Cards' menu item", () ->
            AmazonWebSite.homePage.getHeader().goToGiftCardPage());

        Then("Gift Cards page opened", () ->
            AmazonWebSite.giftCardPage.getGiftCardPageTitle().shouldBe(Condition.visible));

    }
}
