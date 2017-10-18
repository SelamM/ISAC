Feature: Checking the file extraction tab as internal user

  Scenario: Extracting file
    Given I loged in
    And Click on ING
    When I click on File extraction tab
    And I select School
    And I click on Creat new file extraction
    Then I should have the option to select report types
    And request report
