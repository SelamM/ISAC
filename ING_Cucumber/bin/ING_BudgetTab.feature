Feature: Checking the budget tab as internal user

  Scenario: Checking the Budget amount
    Given I login as Internal user
    And I click on ING
    When I click on budget tab
    And I select school
    Then I shold see the budget Information for the school
