Feature: Search Flight and Book a One Way Trip on SpiceJet

  Background: 
    Given Here I am in the SpiceJet website
    And I click the proceed to pay button

  Scenario: Search for one way trips and book a flight with passenger form fill, seat selection, Successful card payment
    for a flight ticket

    When I search for one way flights
    And I select a flight for my trip
    And I fill in the passenger form
    And I select my seat preference
    When I enter my card details as follows:
    
      | Card Number         | Month | Year | CVV | Holder Name |
      | 4263 9826 4026 9299 |    02 |   26 | 837 | Anandh      |
    
    Then I should see a confirmation message
    And my ticket should be booked successfully
     