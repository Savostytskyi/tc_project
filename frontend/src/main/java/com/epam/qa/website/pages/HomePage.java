package com.epam.qa.website.pages;

import com.epam.qa.annotations.Section;
import com.epam.qa.website.sections.Header;
import lombok.Getter;

@Getter
public class HomePage {

    @Section
    private Header header;
}
