@Smoke
  Feature: check login functionality



  @TC_001
  Scenario: login Page
   Given user navigates to OrangeHRM home page
    When user logs in by entering username and password
    And user clicks on Admin Tab
    And user navigates to System User and enters User Details
    |UserName|UserRole |EmployeeName     |Status |
    |Admin   |Admin    |aaaaa Tester     |Enabled|
    Then user Search for user details
    And user capture the screenshot in local
    # And user validates record found
    Then user closes the browser