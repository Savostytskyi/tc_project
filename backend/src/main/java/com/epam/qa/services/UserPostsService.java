package com.epam.qa.services;

import com.epam.http.annotations.ContentType;
import com.epam.http.annotations.GET;
import com.epam.http.annotations.POST;
import com.epam.http.annotations.ServiceDomain;
import com.epam.http.requests.RestMethod;
import com.epam.qa.entities.UserPost;
import lombok.Getter;

import static io.restassured.http.ContentType.JSON;

@Getter
@ServiceDomain(value = "https://jsonplaceholder.typicode.com")
public class UserPostsService {

    @ContentType(JSON)
    @GET("/posts")
    private RestMethod<UserPost> userPosts;

    @ContentType(JSON)
    @GET("/posts/%s")
    private RestMethod<UserPost> userPost;

    @ContentType(JSON)
    @POST("/posts")
    private RestMethod<UserPost> addPost;

}
