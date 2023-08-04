
Feature: Login Failure with Invalid Email and Password
#  @UI
#
#  Background: Going to URL
#    Given User goes to "https://test.urbanicfarm.com/"


  Scenario Outline: Login Failure with Invalid Information
    Given User goes to "https://test.urbanicfarm.com/"
    When the user enters "<email>" and "<password>" and clicks on the login button
    Then the user should see an error message indicating login failure
#    And the user should not be redirected to the dashboard page

    Examples:
      | email | password |
      | invaid@email.com  | wrongpassword123   |
      | rmznkrc21@gmail.com|   wrongpassword123 |
      | invlid@email.com  | VHt*zzt*wQNu6XS    |
      | invalid@email.com  | 12345   |
      |  invalid@email.com|  abcdef     |
      | rmznkrc21@gmail.com|   wrongpassword |



