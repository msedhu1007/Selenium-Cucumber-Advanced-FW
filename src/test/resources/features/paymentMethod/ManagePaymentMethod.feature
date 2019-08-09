@managePayment
Feature: As a Registered user, he should be able to manage payment methods with Jtv.com

  Scenario: User should have provision to add new payment details
    Given the user navigate to the Login page
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And the user navigates to Payment Methods page
    Then user should be presented with Payment Details page
