@stretchPay
Feature: Registered User be able to place stretch pay orders

  @smoke
  Scenario: Registered User to place an stretch pay order
    Given the user logs in to the application with following credentials
      | msedhu@gmail.com | reliance |
    When the user navigates to the Home page
    And the user selects a Stretch pay item and Adds to Bag
    And user navigates to Shopping bag screen
    And the user checkout with card details and places order
      | Bob Allen | 4916855657472322 | 11 | 2022 | 578 |
    Then Order summary has the Total Due today calculated correctly


  @smoke
  Scenario: Guest user should not be able to place stretch pay orders
    Given the user navigates to the home page
    When the user selects a Stretch pay item and Adds to Bag
    And the user navigates to Bag screen and places Guest checkout
    Then the user is informed to sign in to proceed with StretchPay



