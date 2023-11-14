Feature: SpiceJet Sign-Up

  # A successful sign-up scenario.
  Scenario: Successful Sign-Up
    Given I am on the SpiceJet sign-up page
    When I enter a valid email address
    And I enter a valid password
    And I confirm the password
    And I provide other required details
    And I click the sign-up button
    And I should be successfully registered
    Then Browser closed
 # A scenario for signing up with an invalid email and invalid password
  Scenario: Sign-Up with Invalid Email
    Given I am on the SpiceJet sign-up page
    When I enter an invalid email address
    And I enter a invalid password
    And I conform the password
    And I given other required details invalid
    And I click the sign-up 
    And I should see an error message
    Then Browser was closed