@quickview
Feature: All users should be able to Quick view of the products

  @smoke
  Scenario: Registered user be able to Quick view products
    Given the user navigate to the Login page
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And user selects a ring product
      | Rings | White Diamond Rings |
    And the user selects a product quick view
    Then the Quick view page with image, available size, quantity, price should be displayed
