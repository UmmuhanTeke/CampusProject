Feature:Homework Submission

  Background:
    Given Navigate to Campus
    When  The user types username and password and click login button
    Then  The user verifies login successfully

  Scenario:Submit homework and manage drafts
    Given The user clicks on the Assignment button
    When  The user clicks on the Submit button
    Then  The user displays a text editor and types text
    And   The user types the message text and uploads the file by clicking on the Attach Files button
    And   The user clicks on the Save as Draft button
    Then  The user displays a Success message
    When  The user clicks on the Submit button
    And   The user displays Confirm message and clicks on the Yes button
    Then  The user displays a Success message

  Scenario: New submission button
    Given The user is directed to homework Detail page
    When  The user clicks on the New Submission button
    Then  The user verifies a text editor