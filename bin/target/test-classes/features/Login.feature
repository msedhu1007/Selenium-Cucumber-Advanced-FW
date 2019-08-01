Feature:  Jtv Login
  As a user I should able to login into Jtv

  Scenario Outline: I Login with valid username and password
    Given I navigate to the Login page
    When I login with <email address> and <password>
    Then login should be successful
    Examples:
      | email address          | password |
      | sedhu.madhavan@jtv.com | Password |
      | msedhu@gmail.com       | reliance |


