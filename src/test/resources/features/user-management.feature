@UserManagement
Feature: User Management

  This feature is about user management

  @PROJ-123
  Scenario: Get All Users

  System operators should be able to retrieve existing users

    Given the operator has 'user_management' role
    And the system has the following users available
      | username | details        |
      | user-1   | user-1 details |
      | user-2   | user-2 details |
    When the operator retrieves all existing users
    Then the following users are returned
      | username | details        |
      | user-1   | user-1 details |
      | user-2   | user-2 details |
