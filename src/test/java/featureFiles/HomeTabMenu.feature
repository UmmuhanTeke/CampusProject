Feature:Tab Menu Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario:Clicking the Tab Menu Links
    When The user verifies Header menu by clicking on the Header menu links
      | coursesButton     |
      | calendarButton    |
      | attendanceButton  |
      | assignmentsButton |
      | gradingButton     |

    And The user clicks on the Hamburger menu and Hamburger submenu
    Then The user verifies items in the upper right corner
      | notificationsIcon |
      | newMessageIcon    |
