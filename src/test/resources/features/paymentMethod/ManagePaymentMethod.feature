@managePayment
Feature: As a Registered user, he should be able to manage payment methods with Jtv.com

  Scenario: User should have provision to add new payment details
    Given the user navigate to the Login page
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And the user navigates to Payment Methods page
    Then user should be presented with Payment Details page



  @smoke
  Scenario Outline: Authorization declined on entering Invalid card number
    Given the user navigates to the home page
    When the user selects an item and Adds to Bag
    And the user navigates to Bag screen and places Guest checkout
    And the user enters the Shipping address and continues to Billing
      | <First Name> | <Last Name> | <Phone> | <Address1> | <Address2> | <City> | <Country> | <State> | <Zip Code> |
    And the user enters payment information and email
      | Alexandra Hope | 4457001900000009 | 09 | 2020 | 123 | msm@jtv.com |
    And the user reviews and places the Order
      | <First Name> | <Last Name> | <Phone> | <Address1> | <Address2> | <City> | <Country> | <State> | <Zip Code> |
    Then the order is not successfully placed with the message Authorization Declined

    Examples:
      | First Name | Last Name | Phone      | Address1                   | Address2 | City     | Country       | State | Zip Code |  |
      | Sedhu      | M         | 1234567890 | 1301 Dunwoody Gables Drive |          | Dunwoody | United States | GA    |    30338 |  |

