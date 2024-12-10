Feature:Financial Payment Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario:Attendance Excuse Request
    Given The user clicks the Attendance link on the homepage
    Then  The user is redirected to the Attendance Excuse page
    When  The user types an excuse and attaches a file
    And   The user submits the excuse
    Then  The user views a confirmation message