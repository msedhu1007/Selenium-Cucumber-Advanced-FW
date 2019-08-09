@paypalCheckout
Feature: Guest User be able to checkout item through paypal

  @smoke
  Scenario Outline: Guest user places order through Paypal account
    Given the user navigates to the home page
    When the user selects an item and Adds to Bag
    And the user navigates to Bag screen and places Guest checkout
    And the user enters the Shipping address and continues to Billing
      | <First Name> | <Last Name> | <Phone> | <Address1> | <Address2> | <City> | <Country> | <State> | <Zip Code> |
    And User places an Paypal Order
    Then the order is successfully placed

    Examples:
      | First Name | Last Name | Phone      | Address1                   | Address2 | City     | Country       | State | Zip Code |  |
      | Sedhu      | M         | 1234567890 | 1301 Dunwoody Gables Drive |          | Dunwoody | United States | GA    |    30338 |  |
