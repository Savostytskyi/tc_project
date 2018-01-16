package com.epam.qa.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(exclude={"title", "body"})
public class UserPost {

    private String userId;
    private String id;
    private String title;
    private String body;

}
