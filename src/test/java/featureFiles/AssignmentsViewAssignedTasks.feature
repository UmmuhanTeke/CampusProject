Feature: View assigned tasks

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: The user hovers over Assignments link and views task count
    When The user hovers over the Assignments link
    Then The number of assigned tasks should be displayed

  Scenario: The user clicks to Assignments link and view all assigned tasks
    When The user clicks on the Assignment button
    Then The user clicks on the Semester link and select All
    Then The user hovers over the Assignments link
    Then The user should see all assigned tasks on the page