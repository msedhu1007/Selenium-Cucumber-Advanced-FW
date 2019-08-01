@preferredAccount
Feature: Registered User should be able to apply for Preferred Account option

  Scenario: Guest user should not have Preferred Account option
    Given the user navigates to the home page
    When the user selects an item and Adds to Bag
    And the user navigates to Bag screen and places Guest checkout
    And the user enters the Shipping address and continues to Billing
      | Bill | Gates | 354-803-1144 | 7273 Chesterton Ln |  | Indianapolis | United States | IN | 46237 |
    Then the user Preferred Account option is not available for user