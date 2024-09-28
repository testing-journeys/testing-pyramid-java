## Testing Microservices in Java

### Objective

The purpose of this repo is to serve as a reference when deciding what test levels to use to test a microservice.

### Test Examples

The following testing levels can be observed:

- [Unit Test | POJO | JUnit](src/test/java/org/chicu/model/EmployeeDetailsBuilderTest.java)
- [Unit Test | Spring Beans | Mocking Dependencies | Mockito](src/test/java/org/chicu/service/EmployeeServiceTest.java)
- [Integration Test | Rest Controller - HTTP | MockMvc](src/test/java/org/chicu/controller/EmployeeControllerTest.java)
- [Integration Test | Persistence Layer - DB | JpaTest](src/test/java/org/chicu/repository/EmployeeRepositoryTest.java)
- [Component Test | Service | Cucumber and RestAssured](src/test/resources/features/rest/user-management.feature)
- [End-to-End Test | Service | Cucumber, RestAssured and Selenium](src/test/resources/features/ui/user-management-ui.feature)