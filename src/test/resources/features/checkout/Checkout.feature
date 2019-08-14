@checkout
Feature: As a Guest, user should be able to checkout a product

  @smoke
  Scenario: Registered User checkouts a product and place an order with P.O.Box address
    Given the user navigate to the Login page
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And the user navigates to the home page
    And the user selects an item and Adds to Bag
    And the user navigates to Bag screen


  @smoke @bulkyitem
  Scenario: Shipping charge applied to Large or Bulk item on checkout
    Given the user navigate to the Login page
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And the user navigates to the Home page
    And the user selects a bulky item "JWB90" and Adds to bag
    And the user enters the Shipping address and continues to Billing
      | Bob | Allen | 1434567980 | 414 N Forest Park Blvd |  | Knoxville | United States | TN | 37919 |
    And user pays with credit card details and places order
      | Bob Willis | 5416380048117454 | 05 | 2020 | 568 |
    Then the order should be placed and shipping cost should be added



