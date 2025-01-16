package org.chicu.it.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.chicu.model.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeUIStepDefs {

    private List<Employee> actualEmployees = new ArrayList<>();

    private WebDriver driver;

    @Before("@UI")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

    }

    @After("@UI")
    public void tearDown() {
        driver.close();
    }

    @When("the operator retrieves all existing employees through UI")
    public void theOperatorRetrievesAllExistingEmployees() {
        driver.get("http://localhost:8081/ui/v1/employees");
        WebElement tableBody = driver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String username = columns.get(0).getText();
            String details = columns.get(1).getText();
            actualEmployees.add(new Employee(username, details));
        }
    }

    @Then("the following employees are returned through UI")
    public void theFollowingEmployeesAreReturned(List<Employee> expectedEmployees) {
        assertEquals(expectedEmployees, actualEmployees,
                "Retrieved employees are different than ones expected");
    }
}
