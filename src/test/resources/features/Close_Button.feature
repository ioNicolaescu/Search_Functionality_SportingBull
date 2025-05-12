@CloseButton
Feature: Verify search bar close button functionality

  Background:
    Given User is on the SportingBull homepage

  Scenario: Close button hides the search bar
    When User press the search icon
    And User Press the Close button
    Then The search bar should no longer be visible