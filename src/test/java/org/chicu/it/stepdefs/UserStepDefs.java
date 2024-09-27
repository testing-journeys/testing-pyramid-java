package org.chicu.it.stepdefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.chicu.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserStepDefs {

    private List<User> actualUsers = Collections.emptyList();

    @DataTableType
    public User userDataType(Map<String, String> entry) {
        return new User(
                entry.get("username"),
                entry.get("details"));
    }

    @Given("the operator has {string} role")
    public void theOperatorHasUserRole(String role) {
        System.out.println(role);
    }

    @And("the system has the following users available")
    public void theSystemHasTheFollowingUsersAvailable(List<User> availableUsers) {
        System.out.println(availableUsers);
    }

    @When("the operator retrieves all existing users")
    public void theOperatorRetrievesAllExistingUsers() {
        actualUsers =
                given().baseUri("http://localhost:8081")
                        .when().get("/api/v1/users")
                        .then().statusCode(200)
                        .extract().response().as(new TypeRef<>() {
                });
    }

    @Then("the following users are returned")
    public void theFollowingUsersAreReturned(List<User> expectedUsers) {
        assertEquals(expectedUsers, actualUsers,
                "Retrieved user are different than ones expected");
    }
}
