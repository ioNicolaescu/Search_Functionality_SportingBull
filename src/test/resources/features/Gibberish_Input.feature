Feature: Verify no result message is shown for gibberish input
  Background: 
    Given User is on the SportingBull homepage
  
  Scenario: Gibberish input returns no result message
    When User press the search icon
    And User enters "asdkjfh" in the search bar
    Then User should see a "There are no results that match your search. Try again." message displayed