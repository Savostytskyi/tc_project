package com.epam.qa.website.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.qa.annotations.Section;
import com.epam.qa.website.sections.Header;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class GiftCardPage {

    @Section
    private Header header;

    private SelenideElement giftCardPageTitle = $("img[alt='Gift Cards']");
    private SelenideElement sectionTitleTitle = $("img[alt='Shop by Occasion']");

}
