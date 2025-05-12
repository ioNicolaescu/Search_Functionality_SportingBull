Feature: Verify input trimming in search functionality

  Background:
    Given User is on the SportingBull homepage

  Scenario: TC007 Search input with leading or trailing spaces returns correct results
    When User press the search icon
    And User enters in the search bar the following
    | Dinamo|
    | Dinamo |
    |Dinamo |
    Then Search result should be the same