Feature: Logging in as ISAC user and run through ING functionality

  Background: 
    Given I login as ISAC user
    When I click on ING tab

  Scenario: Checking the functionality on the home page
    When i select academic year
    And I put ssn number to the view student list field
    Then I should be in the student detail eligiblity page

  Scenario: Checking all buttons on student eligiblity view page
    Given I clicked on Student tab
    And I selected a school
    When I click on first, next, last and previous buttons
    Then I should be able to navigate through each pages
    When I select number of entrees
    Then I should see the number of student selected
    And when I Click on view report
    Then I should see the report for the selected school
    And when i click on excel report
    Then I should get excel report

  Scenario: Selecting a single student and go through each functionality
    Given I selected a student
    When I clcik on person detail
    Then I should be on the persons detal page
    And when i click on History
    Then I should see the History of the student
    And when I filter the entries
    Then I should only see the selected number of reports
    And when I click on back button
    Then I should be back to the person detail page
    And when I select the view button of associatd program for each year
    Then I should be on person transaction list page
    And Clicking on the person detail should take me back to person detal page
    When I click on Units used
    Then I should see the units used for all academic years
    And when I click on Person detail button
    Then I should be back to the person detail page

  Scenario: Checking funtionality of sort option in Student tab
    Given I want to sort the student list
    When I select the sorting options
    And I click on View
    Then I should be able to see the sorted lists
