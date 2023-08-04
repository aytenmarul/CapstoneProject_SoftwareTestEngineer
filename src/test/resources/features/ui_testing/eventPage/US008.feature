
Feature: US035 As a user I should be able to login my account by valid input


  @UI
  Scenario: As a user login account by valid input
    Given User goes to "https://urbanicfarm.com"
    When As a User clicks login link
    Then As a User types valid email in email text box
    And As a user click exit icon for displayed pop up
    And User clicks the Sell-Share-Trade link
    And As a user clicks myEvent page on the account page
    And As a user clicks create new events button
    And As a user type title on the new event page

