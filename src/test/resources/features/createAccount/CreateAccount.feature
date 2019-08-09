@createAccount
Feature: As a new user he should be able to create account with Jtv.com

  @createAccount
  Scenario Outline: User Creates new account with jtv.com
    Given the user navigate to the Create Account page
    When the user creates an account with new email address
      | <First Name> | <Last Name> | <Email> | <Phone Number> | <Password> | <Confirm Password> |
    Then the Account should get created successfully

    Examples: 
      | First Name | Last Name | Email                 | Phone Number | Password  | Confirm Password |
      | Sedhu      | Madhavan  | msedhu12xyz@gmail.com |   6618037747 | knoxville | knoxville        |

  @createAccountExistingEmail @smoke
  Scenario Outline: User Registers with existing Email address
    Given the user navigate to the Create Account page
    When the user creates an account with existing email address
      | <First Name> | <Last Name> | <Email> | <Phone Number> | <Password> | <Confirm Password> |
    Then Error message "Email already exists" appears

    Examples: 
      | First Name | Last Name | Email            | Phone Number | Password  | Confirm Password |
      | jtv        | user      | msedhu@gmail.com |   6618037747 | knoxville | knoxville        |

  @smoke @createAccountExistingEmail1
  Scenario: Guest cannot create account with existing email address
    Given the user navigates to the home page
    When the user selects an item and Adds to Bag
    And the user navigates to Bag screen and creates account with existing email
      | Sedhu | Madhavan | msedhu@gmail.com | 6618037747 | knoxville | knoxville |
    Then Error message "Email already exists" appears

  @smoke @createAccountNewEmail
  Scenario: Guest cannot create account with existing email address
    Given the user navigates to the home page
    When the user selects an item and Adds to Bag
    And the user navigates to Bag screen and creates account with new email
      | jtv | user | msedhuxyz782@gmail.com | 6618037747 | knoxville | knoxville |
    Then the Account should get created and user should move to Shipping page
