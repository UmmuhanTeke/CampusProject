Feature:Tab Menu Functionality

  Background:
  Scenario: Login with invalid username and password
    Given Navigate to Campus
    When The user types invalid username and password
    And The user clicks on the login button
    Then The user verifies warning message

  Scenario:Clicking the Tab Menu Links
    Given The user displays the TAB menu on the home page
    Then  The user should be able to view the Tab menu
    When  The user clicks on the Tab Menu button
          | coursesMenu     |
          | calendarMenu |
          | attendanceMenu |
          | assignmentsMenu |
          | gradingMenu |
          | hamburgerMenuButton |
          | announcementsBtn |
          | messagesBtn |
          | studentProfileMenu |
    When The user clicks to the corresponding pages
    Then The user clicks on the Hamburger menu and accesses the sub menu
    And  The user hovers over on the Messaging,Finance,Education,Attendance,Video Conference and Surveys buttons
    And  The user should experience the hover effect on each submenu option
    When The user clicks on the Announcements and Messages
    Then The user is successfully redirected to Announcements and Messages
    And  The user clicks to the Student Profile page and hovers over the following buttons
    And  The user should be on the Student Profile page an d the buttons should be responsive
    When The user clicks on Sign Out and logs out of the site
    Then The user clicks on Sign Out and successfully logs out of the site