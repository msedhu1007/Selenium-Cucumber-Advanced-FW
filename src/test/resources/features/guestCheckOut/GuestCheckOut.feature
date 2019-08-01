@Guestcheckout
Feature: As a Guest, user should be able to checkout a product

  @smoke
  Scenario Outline: User checkouts a product as Guest and place an order
    Given the user navigates to the home page
    When the user selects an item and Adds to Bag
    And the user navigates to Bag screen and places Guest checkout
    And the user enters the Shipping address and continues to Billing
      | <First Name> | <Last Name> | <Phone> | <Address1> | <Address2> | <City> | <Country> | <State> | <Zip Code> |
    And the user enters payment information and email
      | Alexandra Hope | 4539838659946540 | 07 | 2020 | 123 | msm@jtv.com |
    And the user reviews and places the Order
      | <First Name> | <Last Name> | <Phone> | <Address1> | <Address2> | <City> | <Country> | <State> | <Zip Code> |
    Then the order is successfully placed

    Examples: 
      | First Name | Last Name | Phone      | Address1                   | Address2 | City     | Country       | State | Zip Code |  |
      | Sedhu      | M         | 1234567890 | 1301 Dunwoody Gables Drive |          | Dunwoody | United States | GA    |    30338 |  |
