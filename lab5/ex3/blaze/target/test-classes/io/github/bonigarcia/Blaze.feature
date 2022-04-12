Feature: BlazeDemo flight purchase

  Scenario: Successful purchase
    When I navigate to "https://blazedemo.com/"
    And I select a flight from "Boston" to "New York"
    And I click Find Flights
    And I click Choose This Flight
    And I write "Benny Lenny" as my "inputName"
    And I write "123 Main Avenue" as my "address"
    And I write "Brooklyn" as my "city"
    And I write "NY" as my "state"
    And I write "12345" as my "zipCode"
    And I select "American Express" as my "cardType"
    And I write "987654321" as my "creditCardNumber"
    And I write "06" as my "creditCardMonth"
    And I write "2025" as my "creditCardYear"
    And I write "Benny Lenny" as my "nameOnCard"
    And I click Purchase Flight
    Then I should see my receipt