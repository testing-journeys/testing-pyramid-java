@EmployeesManagement
Feature: REST - Employees Management

  This feature is about employees management

  Background: Access configuration
    Given the operator has 'employee_management' role

  @PROJ-123
  Scenario: Get All Users

  System operators should be able to retrieve existing employees

    Given the system has the following employees available
      | id | username | details        |
      | 1  | user-1   | user-1 details |
      | 2  | user-2   | user-2 details |
    When the operator retrieves all existing employees
    Then the following employees are returned
      | id | username | details        |
      | 1  | user-1   | user-1 details |
      | 2  | user-2   | user-2 details |
