package com.epam.qa.website.sections;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    private SelenideElement giftCardMenuItem = $("a[tabindex='50']");
    private SelenideElement registryMenuItem = $("a[tabindex='51']");

    public void goToGiftCardPage() {
        giftCardMenuItem.click();
    }

    public void goToRegistryCardPage() {
        registryMenuItem.click();
    }


}
