
Feature: US035 As a user I should be able to login my account by valid input


  @UI
  Scenario: As a user login account by valid input
   Given User goes to "https://test.urbanicfarm.com"
    When As a User clicks login link
   Then As a User types valid email in email text box
  Then As a User types valid password in password text box
    Then As a User clicks the login button
    And As a user clicks "https://test.urbanicfarm.com/account/events-i-organize" a