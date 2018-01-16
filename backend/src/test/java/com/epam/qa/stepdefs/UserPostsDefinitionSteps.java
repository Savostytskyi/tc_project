package com.epam.qa.stepdefs;

import com.epam.http.response.RestResponse;
import com.epam.qa.entities.UserPost;
import com.epam.qa.services.UserPostsService;
import cucumber.api.DataTable;
import cucumber.api.java8.En;

import static com.epam.http.requests.ServiceInit.init;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class UserPostsDefinitionSteps implements En {

    private UserPostsService service = init(UserPostsService.class);
    private RestResponse response;

    public UserPostsDefinitionSteps() {

        Given("User posts service is up and running", () ->
            assertThat(service.getUserPosts().isAlive())
                .as("Service does not respond within 2 seconds")
                .isTrue());

        When("I add user post with parameters:", (DataTable post) ->
            response = service.getAddPost().postData(post.asList(UserPost.class).get(0)));

        When("I request user post by id '(\\d+)'", (Integer postId) ->
            response = service.getUserPost().call(String.valueOf(postId)));

        Then("Response status is (\\d+)", (Integer responseStatus) ->
            assertThat(response.status.code)
                .as("Response status is not equals to expected")
                .isEqualTo(responseStatus));

        Then("I receive user post information:", (DataTable post) ->
            assertThat(response.raResponse().as(UserPost.class))
                .as("User post information is not equals to expected")
                .isEqualTo(post.asList(UserPost.class).get(0)));

    }
}
