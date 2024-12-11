Feature: Profile Settings and Theme Update

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Update profile theme and save changes
    Given The user clicks on the Profile and selects the Settings link in the Profile menu
    When  The user clicks on the Default Theme dropdown and selects a new theme
    Then  The user clicks on the save button and displays Success message