package org.chicu.it.stepdefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.chicu.model.Employee;
import org.chicu.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeStepDefs {

    private List<Employee> actualEmployees = Collections.emptyList();

    // not black-box approach
    @Autowired
    private EmployeeRepository employeeRepository;

    @DataTableType
    public Employee employeeDataType(Map<String, String> entry) {
        return new Employee(
                Long.valueOf(entry.get("id")),
                entry.get("username"),
                entry.get("details"));
    }

    @Given("the operator has {string} role")
    public void theOperatorHasUserRole(String role) {
    }

    @And("the system has the following employees available")
    public void theSystemHasTheFollowingEmployeesAvailable(List<Employee> availableEmployees) {
        employeeRepository.saveAll(availableEmployees);
    }

    @When("the operator retrieves all existing employees")
    public void theOperatorRetrievesAllExistingEmployees() {
        actualEmployees =
                given().baseUri("http://localhost:8081")
                        .when().get("/api/v1/employees")
                        .then().statusCode(200)
                        .extract().response().as(new TypeRef<>() {
                });
    }

    @Then("the following employees are returned")
    public void theFollowingEmployeesAreReturned(List<Employee> expectedEmployees) {
        assertEquals(expectedEmployees, actualEmployees,
                "Retrieved employees are different than ones expected");
    }
}
