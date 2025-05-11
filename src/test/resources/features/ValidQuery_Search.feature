Feature: Search Functionality

  Background:
    Given User is on the SportingBull homepage

  Scenario: TC001 - Valid query returns appropriate results
    When User enters "Juventus" in the search bar
    Then search results related to "Juventus" should be displayed