Feature: Going through each student fitler options

  Background: 
    Given I loged in Internal user
    When I Click On ING tab
    And I select academic year
    And I click on student tab
    And I Select a school

  Scenario: Filtering list of student by each filtering options
    Given I click on filter tab to filter
    When I pass a ssn number to ssn field
    Then I should see the list
    When I select term
    Then I should see the list
    When I select selected student only
    Then I should see the list
    When I select eligible student only
    Then I should see the list
    When I select by 10 Year
    Then I should see the list
    When I select by ING units used
    Then I should see the list
    When I select by ISAC default
    Then I should see the list
    When I select by applied late
    Then I should see the list