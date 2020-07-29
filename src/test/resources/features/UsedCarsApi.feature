@api @usedcars
Feature: JiraId-feature# Used Cars Search via Services
  As a test user
  I want to search for the used cars in trade me sandbox application
  So that I can see for any used cars are available

  @getusedcarcount
  Scenario Outline: Get list of used cars and check if the search result returns any results

    Given Automation for Testid
    And Business details information for tradeMe
    When the user searches for the data in <apiName>
    Then there is at least <listing> in the TradeMe UsedCars category

    Examples:
      | apiName     | listing |
      | getUsedCars | 1       |

  @getusedcarmake
  Scenario Outline: Get list of used cars and check the result has particular make

    Given Automation for Testid
    And Business details information for tradeMe
    When the user searches for the data in <apiName>
    Then there is the model <Make> available in the list of items

    Examples:
      | apiName     | Make |
      | getUsedCars | kia  |

