Feature: Verify search functionality is case-insensitive

  Background:
    Given User is on the SportingBull homepage

  Scenario: TC002 Search functionality is case-insensitive
    When User press the search icon
    And User enters in the search bar the following
      |JUVENTUS|
      |juventus|
      |JuVEnTuS|
    Then Search result should be the same


