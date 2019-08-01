@searchpage
Feature: As a Customer user should be able to Search items

Background:
Given the user navigate to the Login page
    
@regression
  Scenario: User selects Shop by Type to shop Ring  
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And the user navigates to the home page
    Then the user should see Search field with the text "What are you looking for?"

@smoke
  Scenario: User Search items to view the search results
    When the user login with following credentials
      | sedhu.madhavan@jtv.com | reliance |
    And the user navigates to the home page
    And the user Search with the text "Ring"
    Then Breadcrumb should display "Your search results for"
    
    
