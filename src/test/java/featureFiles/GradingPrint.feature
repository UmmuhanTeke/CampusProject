Feature: Course Grade and Transcript Printing

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Print and download grades or transcripts
    Given The user clicks on the Grading button
    Then The user views a Print icon and clicks on the Download button
    And The user views PDF Document page and clicks on the Download button