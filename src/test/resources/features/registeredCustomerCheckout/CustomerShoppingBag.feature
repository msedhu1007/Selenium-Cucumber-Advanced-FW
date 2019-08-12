@customerShoppingBag
Feature: Registered User be able to add and view shopping bag

@smoke 
  Scenario: Registered User should be able to view shopping bag
    Given the user navigate to the Login page
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And user navigates to Shopping bag screen
    Then user should be displayed "Your Shopping Bag"
    And option to continue shopping
