Feature: Search Flight and Book a RoundWay Trip on SpiceJet

  Background: 
    Given I am in SpiceJet Website
    And I click the proceed to pay

  Scenario: Search for Roundway trips and book a flight with passenger form fill, seat selection, Successful card payment
    for a flight ticket

    When I search for Roundway flights
    And I select a flight for the trip
    And I fill the passenger form
    And I select the seat preference
    When I enter the card details as follows:
    
      | Card Number         | Month | Year | CVV | Holder Name |
      | 4263 9826 4026 9255 |    03 |   28 | 987 | Srinivasan  |
    
    Then I see a confirmation message
    And my ticket should be booked successfull
    
  #Scenario: Search for one way trips and book a flight with passenger form fill, seat selection, Failed card payment
    #for a flight ticket due to invalid card details

    #When I search for one way flights
    #And I select a flight for my trip
    #And I fill in the passenger form
    #And I select my seat preference
    #When I enter invalid card details as follows:
      
      #| Card Number    | Expiry Date | CVV | Card Holder Name |
      #| 9876 5432 1098 | 06/24       | 456 | Jane Smith       |
    
    #Then I should see an error message indicating the payment has failed
