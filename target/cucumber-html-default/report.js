$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/createAccount/CreateAccount.feature");
formatter.feature({
  "name": "As a new user he should be able to create account with Jtv.com",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@createAccount"
    }
  ]
});
formatter.scenarioOutline({
  "name": "User Creates new account with jtv.com",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@createAccount"
    }
  ]
});
formatter.step({
  "name": "the user navigate to the Create Account page",
  "keyword": "Given "
});
formatter.step({
  "name": "the user creates an account with new email address",
  "keyword": "When ",
  "rows": [
    {
      "cells": [
        "\u003cFirst Name\u003e",
        "\u003cLast Name\u003e",
        "\u003cEmail\u003e",
        "\u003cPhone Number\u003e",
        "\u003cPassword\u003e",
        "\u003cConfirm Password\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "the Account should get created successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "First Name",
        "Last Name",
        "Email",
        "Phone Number",
        "Password",
        "Confirm Password"
      ]
    },
    {
      "cells": [
        "Sedhu",
        "Madhavan",
        "msedhu12xyz@gmail.com",
        "6618037747",
        "knoxville",
        "knoxville"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User Creates new account with jtv.com",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@createAccount"
    },
    {
      "name": "@createAccount"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Create Account page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.user_navigates_CreateAccountPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user creates an account with new email address",
  "rows": [
    {
      "cells": [
        "Sedhu",
        "Madhavan",
        "msedhu12xyz@gmail.com",
        "6618037747",
        "knoxville",
        "knoxville"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "CreateAccountSteps.createNewAccount(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account should get created successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateAccountSteps.accountShouldGetCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "User Registers with existing Email address",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@createAccountExistingEmail"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "the user navigate to the Create Account page",
  "keyword": "Given "
});
formatter.step({
  "name": "the user creates an account with existing email address",
  "keyword": "When ",
  "rows": [
    {
      "cells": [
        "\u003cFirst Name\u003e",
        "\u003cLast Name\u003e",
        "\u003cEmail\u003e",
        "\u003cPhone Number\u003e",
        "\u003cPassword\u003e",
        "\u003cConfirm Password\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "Error message \"Email already exists\" appears",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "First Name",
        "Last Name",
        "Email",
        "Phone Number",
        "Password",
        "Confirm Password"
      ]
    },
    {
      "cells": [
        "jtv",
        "user",
        "msedhu@gmail.com",
        "6618037747",
        "knoxville",
        "knoxville"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User Registers with existing Email address",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@createAccount"
    },
    {
      "name": "@createAccountExistingEmail"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Create Account page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.user_navigates_CreateAccountPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user creates an account with existing email address",
  "rows": [
    {
      "cells": [
        "jtv",
        "user",
        "msedhu@gmail.com",
        "6618037747",
        "knoxville",
        "knoxville"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "CreateAccountSteps.userCreatesAccountExistingEmail(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Error message \"Email already exists\" appears",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateAccountSteps.verifyErrorMsg(String)"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Guest cannot create account with existing email address",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@createAccount"
    },
    {
      "name": "@smoke"
    },
    {
      "name": "@createAccountExistingEmail1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user selects an item and Adds to Bag",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageSteps.user_selects_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to Bag screen and creates account with existing email",
  "rows": [
    {
      "cells": [
        "Sedhu",
        "Madhavan",
        "msedhu@gmail.com",
        "6618037747",
        "knoxville",
        "knoxville"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateAccountSteps.userNavigatesToBagCreateAccount(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Error message \"Email already exists\" appears",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateAccountSteps.verifyErrorMsg(String)"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Guest cannot create account with existing email address",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@createAccount"
    },
    {
      "name": "@smoke"
    },
    {
      "name": "@createAccountNewEmail"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user selects an item and Adds to Bag",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageSteps.user_selects_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to Bag screen and creates account with new email",
  "rows": [
    {
      "cells": [
        "jtv",
        "user",
        "msedhuxyz782@gmail.com",
        "6618037747",
        "knoxville",
        "knoxville"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateAccountSteps.createAccountNewEmail(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account should get created and user should move to Shipping page",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateAccountSteps.ValidateAccountCreation()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.uri("features/guestCheckOut/GuestCheckOut.feature");
formatter.feature({
  "name": "As a Guest, user should be able to checkout a product",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Guestcheckout"
    }
  ]
});
formatter.scenarioOutline({
  "name": "User checkouts a product as Guest and place an order",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "the user navigates to the home page",
  "keyword": "Given "
});
formatter.step({
  "name": "the user selects an item and Adds to Bag",
  "keyword": "When "
});
formatter.step({
  "name": "the user navigates to Bag screen and places Guest checkout",
  "keyword": "And "
});
formatter.step({
  "name": "the user enters the Shipping address and continues to Billing",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "\u003cFirst Name\u003e",
        "\u003cLast Name\u003e",
        "\u003cPhone\u003e",
        "\u003cAddress1\u003e",
        "\u003cAddress2\u003e",
        "\u003cCity\u003e",
        "\u003cCountry\u003e",
        "\u003cState\u003e",
        "\u003cZip Code\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "the user enters payment information and email",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Alexandra Hope",
        "4539838659946540",
        "07",
        "2020",
        "123",
        "msm@jtv.com"
      ]
    }
  ]
});
formatter.step({
  "name": "the user reviews and places the Order",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "\u003cFirst Name\u003e",
        "\u003cLast Name\u003e",
        "\u003cPhone\u003e",
        "\u003cAddress1\u003e",
        "\u003cAddress2\u003e",
        "\u003cCity\u003e",
        "\u003cCountry\u003e",
        "\u003cState\u003e",
        "\u003cZip Code\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "the order is successfully placed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "First Name",
        "Last Name",
        "Phone",
        "Address1",
        "Address2",
        "City",
        "Country",
        "State",
        "Zip Code",
        ""
      ]
    },
    {
      "cells": [
        "Sedhu",
        "M",
        "1234567890",
        "1301 Dunwoody Gables Drive",
        "",
        "Dunwoody",
        "United States",
        "GA",
        "30338",
        ""
      ]
    }
  ]
});
formatter.scenario({
  "name": "User checkouts a product as Guest and place an order",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Guestcheckout"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user selects an item and Adds to Bag",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageSteps.user_selects_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to Bag screen and places Guest checkout",
  "keyword": "And "
});
formatter.match({
  "location": "ProductDetailsSteps.userNavigatesToBag_checkout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters the Shipping address and continues to Billing",
  "rows": [
    {
      "cells": [
        "Sedhu",
        "M",
        "1234567890",
        "1301 Dunwoody Gables Drive",
        "",
        "Dunwoody",
        "United States",
        "GA",
        "30338"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ShippingPageSteps.enterShippingAddress_Billing(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters payment information and email",
  "rows": [
    {
      "cells": [
        "Alexandra Hope",
        "4539838659946540",
        "07",
        "2020",
        "123",
        "msm@jtv.com"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "BillingSteps.userFillsCardInfo(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user reviews and places the Order",
  "rows": [
    {
      "cells": [
        "Sedhu",
        "M",
        "1234567890",
        "1301 Dunwoody Gables Drive",
        "",
        "Dunwoody",
        "United States",
        "GA",
        "30338"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ReviewOrderSteps.reviewAndPlaceOrder(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the order is successfully placed",
  "keyword": "Then "
});
formatter.match({
  "location": "OrderReponseSteps.order_successfully_placed()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.uri("features/login/Login.feature");
formatter.feature({
  "name": "Jtv Login",
  "description": "  As a Registered user he should be able to login into Jtv",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User Logins with valid username and password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "the user login with following credentials",
  "rows": [
    {
      "cells": [
        "sedhu.madhavan@jtv.com",
        "reliance"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_login_with_email_and_Password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.login_should_be_successful()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat pageObjects.AccountHomePage.isAccountHomePageOpened(AccountHomePage.java:25)\n\tat stepDefinitions.LoginSteps.login_should_be_successful(LoginSteps.java:39)\n\tat ✽.login should be successful(features/login/Login.feature:13)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.write("Scenario Failed");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User Logins with Invalid username and password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "the user login with following credentials",
  "rows": [
    {
      "cells": [
        "sedhu.madhavan@jtv.com",
        "reliance123"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_login_with_email_and_Password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should not be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.login_shouldnot_be_successful()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.uri("features/paymentMethod/ManagePaymentMethod.feature");
formatter.feature({
  "name": "As a Registered user, he should be able to manage payment methods with Jtv.com",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@managePayment"
    }
  ]
});
formatter.scenario({
  "name": "User should have provision to add new payment details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@managePayment"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user login with following credentials",
  "rows": [
    {
      "cells": [
        "sedhu.madhavan@jtv.com",
        "reliance"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_login_with_email_and_Password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to Payment Methods page",
  "keyword": "And "
});
formatter.match({
  "location": "PaymentMethodsSteps.java:15"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be presented with Payment Details page",
  "keyword": "Then "
});
formatter.match({
  "location": "PaymentMethodsSteps.java:21"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.uri("features/quickBuy/QuickBuy.feature");
formatter.feature({
  "name": "Registered Customers should be able to set up Quick Buy",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@quickbuy"
    }
  ]
});
formatter.scenario({
  "name": "Verify the Quick Buy Page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@quickbuy"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user login with following credentials",
  "rows": [
    {
      "cells": [
        "sedhu.madhavan@jtv.com",
        "reliance"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_login_with_email_and_Password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to the Quick Buy page",
  "keyword": "And "
});
formatter.match({
  "location": "QuickBuySteps.i_navigate_to_the_QuickBuy_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is presented with QuickBuy",
  "keyword": "Then "
});
formatter.match({
  "location": "QuickBuySteps.user_Presented_QuickBuypage()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify adding New Address to Quick Buy",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.step({
  "name": "the user login with following credentials",
  "keyword": "When ",
  "rows": [
    {
      "cells": [
        "sedhu.madhavan@jtv.com",
        "reliance"
      ]
    }
  ]
});
formatter.step({
  "name": "the user navigates to the Quick Buy page",
  "keyword": "And "
});
formatter.step({
  "name": "the user adds new address and save",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "First Name",
        "\u003cFirst Name\u003e"
      ]
    },
    {
      "cells": [
        "Last Name",
        "\u003cLast Name\u003e"
      ]
    },
    {
      "cells": [
        "Address One",
        "\u003cAddress One\u003e"
      ]
    },
    {
      "cells": [
        "Address Two",
        "\u003cAddress Two\u003e"
      ]
    },
    {
      "cells": [
        "City",
        "\u003cCity\u003e"
      ]
    },
    {
      "cells": [
        "Country",
        "\u003cCountry\u003e"
      ]
    },
    {
      "cells": [
        "State",
        "\u003cState\u003e"
      ]
    },
    {
      "cells": [
        "Zip code",
        "\u003cZip code\u003e"
      ]
    },
    {
      "cells": [
        "Default Address",
        "\u003cDefault Address\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "the Address should get saved",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "\u003cFirst Name\u003e",
        "\u003cLast Name\u003e",
        "\u003cAddress One\u003e",
        "\u003cAddress Two\u003e",
        "\u003cCity\u003e",
        "\u003cCountry\u003e",
        "\u003cState\u003e",
        "\u003cZip code\u003e",
        "\u003cDefault Address\u003e"
      ]
    }
  ]
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "First Name",
        "Last Name",
        "Address One",
        "Address Two",
        "City",
        "Country",
        "State",
        "Zip code",
        "Default Address"
      ]
    },
    {
      "cells": [
        "Sedhu",
        "M",
        "1305 Dunwoody Gables Dr",
        "",
        "Dunwoody",
        "United States",
        "GA - Georgia",
        "30338",
        "True"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify adding New Address to Quick Buy",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@quickbuy"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user login with following credentials",
  "rows": [
    {
      "cells": [
        "sedhu.madhavan@jtv.com",
        "reliance"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_login_with_email_and_Password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to the Quick Buy page",
  "keyword": "And "
});
formatter.match({
  "location": "QuickBuySteps.i_navigate_to_the_QuickBuy_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds new address and save",
  "rows": [
    {
      "cells": [
        "First Name",
        "Sedhu"
      ]
    },
    {
      "cells": [
        "Last Name",
        "M"
      ]
    },
    {
      "cells": [
        "Address One",
        "1305 Dunwoody Gables Dr"
      ]
    },
    {
      "cells": [
        "Address Two",
        ""
      ]
    },
    {
      "cells": [
        "City",
        "Dunwoody"
      ]
    },
    {
      "cells": [
        "Country",
        "United States"
      ]
    },
    {
      "cells": [
        "State",
        "GA - Georgia"
      ]
    },
    {
      "cells": [
        "Zip code",
        "30338"
      ]
    },
    {
      "cells": [
        "Default Address",
        "True"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "QuickBuySteps.user_addSave_newaddresses(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Address should get saved",
  "rows": [
    {
      "cells": [
        "Sedhu",
        "M",
        "1305 Dunwoody Gables Dr",
        "",
        "Dunwoody",
        "United States",
        "GA - Georgia",
        "30338",
        "True"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "QuickBuySteps.address_should_get_saved(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify placing a quick buy order",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@quickbuy"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user login with following credentials",
  "rows": [
    {
      "cells": [
        "msedhu@gmail.com",
        "reliance"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_login_with_email_and_Password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects a product",
  "rows": [
    {
      "cells": [
        "Watches",
        "Women\u0027s Watches"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ProductDetailsSteps.userSelectsProduct(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user places quickbuy order",
  "keyword": "And "
});
formatter.match({
  "location": "QuickBuySteps.java:26"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is taken to Secure Checkout page",
  "keyword": "Then "
});
formatter.match({
  "location": "BillingSteps.java:20"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "quickbuy order should be placed successfully",
  "keyword": "And "
});
formatter.match({
  "location": "BillingSteps.java:27"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.uri("features/registeredCustomerBroadcast/SearchPageDisplay.feature");
formatter.feature({
  "name": "As a Customer user should be able to Search items",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@searchpage"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User selects Shop by Type to shop Ring",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@searchpage"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user login with following credentials",
  "rows": [
    {
      "cells": [
        "sedhu.madhavan@jtv.com",
        "reliance"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_login_with_email_and_Password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to the home page",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should see Search field with the text \"What are you looking for?\"",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.verify_searchfield_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User Search items to view the search results",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@searchpage"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "the user login with following credentials",
  "rows": [
    {
      "cells": [
        "sedhu.madhavan@jtv.com",
        "reliance"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_login_with_email_and_Password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to the home page",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user Search with the text \"Ring\"",
  "keyword": "And "
});
formatter.match({
  "location": "SearchResultsSteps.userSearchItems(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Breadcrumb should display \"Your search results for\"",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchResultsSteps.verify_Breadcrumb(String)"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
formatter.uri("features/registeredCustomerCheckout/CustomerShoppingBag.feature");
formatter.feature({
  "name": "Registered User be able to add and view shopping bag",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@customerShoppingBag"
    }
  ]
});
formatter.scenario({
  "name": "Registered User to view empty shopping bag",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@customerShoppingBag"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user navigate to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_navigate_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user login with following credentials",
  "rows": [
    {
      "cells": [
        "sedhu.madhavan@jtv.com",
        "reliance"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_login_with_email_and_Password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to Shopping bag screen",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingBagSteps.navigateToShoppingBagPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be displayed \"Your Shopping Bag is empty\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingBagSteps.verifyShoppingBagScreen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "option to continue shopping",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingBagSteps.continueShopping()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Scenario Passed");
formatter.after({
  "status": "passed"
});
});