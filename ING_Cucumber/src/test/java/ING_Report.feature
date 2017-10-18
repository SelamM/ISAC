Feature: Checking the functionality of report tab as internal user.

  Scenario: Checking the Budget amount
    Given I loged in as ISAC user
    And I Click on ING
    When I click on Report tab
    And I Select school
    Then I Should see the budget Information for the school
    And when I clcik on create Report tab
    Then I should have the option to select report type
    And request a report
