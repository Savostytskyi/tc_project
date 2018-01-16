package com.epam.qa.website;

import com.epam.qa.annotations.WebPage;
import com.epam.qa.website.pages.GiftCardPage;
import com.epam.qa.website.pages.HomePage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AmazonWebSite implements WebSite {

    @WebPage(pageName = "Homepage")
    public static HomePage homePage;

    @WebPage(pageName = "Gift Card")
    public static GiftCardPage giftCardPage;

}
