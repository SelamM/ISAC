Feature: Checking the Search Icon In student list page

  Scenario: looking in to students search detail by cliking on the icon
    Given I logged in as ISAC user
    When I Click on ING tab
    And I Clicked on Student tab
    And I Selected a school
    When I click On Search Icon
    Then I should be on student detail eligiblity page
    And when I click on Eligiblity
    Then I should see selected student eligiblity detail
    And when I click on School changes
    Then I should see the school changes for the selected student
    And when I click on Student Update
    Then I should see the updates
