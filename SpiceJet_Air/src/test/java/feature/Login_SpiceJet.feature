Feature: Login to SpiceJet Application

  Background: 
    Given the user is on the SpiceJet login page
    When the user click the login button
    And the user clicks the login button

  Scenario: Valid user login
    And the user enters valid mailid "devanandh2902@gmail.com" and password "Batman12@#"
    And the user clicks the login button
    Then the user should be successfully logged in
    
  Scenario: Invalid user login
    When the user enters invalid emailid "deva@gmail.com" and password "Batman"
    Then the user should see an error message