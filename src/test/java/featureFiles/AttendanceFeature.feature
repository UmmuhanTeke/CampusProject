Feature:Financial Payment Functionality

  Background:
    Given Navigate to campus
    When  Enter username and password and click login button
    Then  User should login successfully

  Scenario:Attendance Excuse Request
    Given The user is on the homepage and clicks the Attendance link
    Then  The user is redirected to the page to report their attendance excuse
    When  The user writes their excuse in the text box
    And   The user attaches a file to support their excuse
    And   The user clicks the submit button to submit their excuse
    Then  The user receives a confirmation that their excuse has been successfully submitted