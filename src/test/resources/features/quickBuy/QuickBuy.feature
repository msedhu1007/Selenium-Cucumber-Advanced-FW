@quickbuy
Feature: Registered Customers should be able to set up Quick Buy

  @smoke
  Scenario: Verify the Quick Buy Page
    Given the user navigate to the Login page
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And the user navigates to the Quick Buy page
    Then the user is presented with QuickBuy

  @smoke
  Scenario Outline: Verify adding New Address to Quick Buy
    Given the user navigate to the Login page
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And the user navigates to the Quick Buy page
    And the user adds new address and save
      | First Name      | <First Name>      |
      | Last Name       | <Last Name>       |
      | Address One     | <Address One>     |
      | Address Two     | <Address Two>     |
      | City            | <City>            |
      | Country         | <Country>         |
      | State           | <State>           |
      | Zip code        | <Zip code>        |
      | Default Address | <Default Address> |
    Then the Address should get saved
      | <First Name> | <Last Name> | <Address One> | <Address Two> | <City> | <Country> | <State> | <Zip code> | <Default Address> |

    Examples: 
      | First Name | Last Name | Address One             | Address Two | City     | Country       | State        | Zip code | Default Address |
      | Sedhu      | M         | 1305 Dunwoody Gables Dr |             | Dunwoody | United States | GA - Georgia |    30338 | True            |

  @smoke
  Scenario: Verify placing a quick buy order
    Given the user navigate to the Login page
    When the user login with following credentials
      | msedhu@gmail.com | reliance |
    And the user moves to the Home page
    And user selects a product
      | Watches | Women's Watches |
    And user places quickbuy order
    Then user is taken to Secure Checkout page
    And quickbuy order should be placed successfully
