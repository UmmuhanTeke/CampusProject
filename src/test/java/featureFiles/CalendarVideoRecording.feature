Feature:Calendar Feature Functionality

  Background:
    Given Navigate to Campus
    When  The user types username and password and click login button
    Then  The user verifies login successfully

  Scenario:Calendar Feature Check
    Given The user is on the Campus homepage
    When  The user clicks on the Calendar button on the top navigation bar
      | calendarButton |

    Given The user is on the Weekly Course Plan page
    Then  The user views the courses they are responsible for
    When  The user clicks on a completed (E) course
    Then  The user views the Recording button to access the course recording and clicks on it
      | recordingButton |

    And   The user accesses the course video
    Then  The user views the Play button in the course video and clicks on it
    And   The user starts watching the video