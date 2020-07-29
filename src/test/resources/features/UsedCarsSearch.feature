@ui @usedcar
Feature: Jira-Feature# Used Cars Details Search
  As a sandbox test user
  I will search for the used cars in trade me sandbox application
  So that I can see the cars list from the search

  @getusedcarcount
  Scenario Outline: Get list of used cars and check if the search result returns any results in UI

    Given user opens TradeMe application
    When user navigated to the <maintab> menu option
    And she navigates to the <submenu> options
    Then she finds atleast one listing in the submenu options

    Examples:
      | maintab | submenu   |
      | Motors  | Used cars |

  @getcarwithbrand
  Scenario: Get list of used cars to check the specific brand exist in the list

    Given user opens TradeMe application
    When user navigated to the Motors menu option
    And she navigates to the Used cars options
    Then she checks for the used car with brand Kia exist

  @getusedcarsDetails
  Scenario: As a user I have to go used cars details page and validate the list of details are mentioned

    Given user opens TradeMe application
    When user navigated to the Motors menu option
    And she navigates to the Used cars options
    And users navigates to the used cars details page
    Then User can view the following details of the car
      |Number plate|
      | Kilometres           |
      | Body                 |
      | Seats                |
      | Fuel type            |
      | Engine               |
      | Transmission         |
      | History              |
      | Registration expires |
      | WoF expires          |
      | Model detail         |
