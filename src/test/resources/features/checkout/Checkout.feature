@checkout
Feature: As a Guest, user should be able to checkout a product

  @smoke
  Scenario: Registered User checkouts a product and place an order with P.O.Box address
    Given the user navigate to the Login page
    When the user login with following credentials
      | sedhu.madhavan@jtv.com| reliance |
    And the user navigates to the home page
    And the user selects an item and Adds to Bag
    And the user navigates to Bag screen




