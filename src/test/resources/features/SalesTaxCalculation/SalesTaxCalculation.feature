@salesTax
Feature: Sales Tax computed correctly on placing orders

  @smoke
  Scenario Outline: Sales Tax gets updated on change of Shipping address
    Given the user navigates to the home page
    When the user selects an item and Adds to Bag
    And the user navigates to Bag screen and places Guest checkout
    And the user enters the Shipping address and continues to Billing
      | <First Name> | <Last Name> | <Phone> | <Address1> | <Address2> | <City> | <Country> | <State> | <Zip Code> |
    And the user enters payment information and email
      | Alexandra Hope | 4539838659946540 | 07 | 2020 | 123 | msm@jtv.com |
    And user changes the shipping address
      | <First Name> | <Last Name> | <Phone>| 414 N Forest Park Blvd |  | Knoxville | United States | TN | 37919 |
    Then the Sales Tax gets computed based on the new Shipping address

    Examples:
      | First Name | Last Name | Phone      | Address1                   | Address2 | City     | Country       | State | Zip Code |  |
      | Sedhu      | M         | 1234567890 | 1301 Dunwoody Gables Drive |          | Dunwoody | United States | GA    | 30338    |  |

