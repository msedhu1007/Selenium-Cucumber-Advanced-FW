@login
Feature: Jtv Login
  As a Registered user he should be able to login into Jtv


Background:
Given the user navigate to the Login page
 
  @smoke
  Scenario: User Logins with valid username and password
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    Then login should be successful

  @smoke
  Scenario: User Logins with Invalid username and password
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance123 |
    Then login should not be successful
