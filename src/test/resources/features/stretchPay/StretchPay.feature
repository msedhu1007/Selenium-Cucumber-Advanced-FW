@stretchPay
Feature: Registered User be able to place stretch pay orders

  @smoke @stretchpaytotalDue
  Scenario: Registered User to place an stretch pay order
    Given the user logs in to the application with following credentials
      | msedhu@gmail.com | reliance |
    When the user navigates to the Home page
    And the user selects a Stretch pay item and Adds to Bag
    And user navigates to Shopping bag screen and checksout
    And the user enters the Shipping address and continues to Billing
      | Bob | Allen | 1434567980 | 9600 Parkside Dr |  | Knoxville | United States | TN | 37922 |
    And the user enters card details and places order
      | Bob Allen | 4916855657472322 | 11 | 2022 | 578 |
    Then Order summary has the Total Due today calculated correctly


  @smoke
  Scenario: Guest user should not be able to place stretch pay orders
    Given the user navigates to the home page
    When the user selects a Stretch pay item and Adds to Bag
    And the user navigates to Bag screen and places Guest checkout
    Then the user is informed to sign in to proceed with StretchPay


  @smoke123
  Scenario: Registered User in READY FOR REVIEW status unable to place stretch pay orders
    Given the user logs in to the application with following credentials
      | willsmith@jtvtest.com | reliance |
    When the user navigates to the Home page
    And the user selects a Stretch pay item and Adds to Bag
    And user navigates to Shopping bag screen and checksout
    And the user enters the Shipping address and continues to Billing
      | Bob | Allen | 6613038924 | 9600 Parkside Dr |  | Knoxville | United States | TN | 37922 |
    And the user enters card details and places order
      | Bob Allen | 4916855657472322 | 11 | 2022 | 578 |
    Then Stretch Pay order should not go through successfully