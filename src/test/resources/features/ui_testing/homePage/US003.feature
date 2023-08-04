
Feature: US002 As a user should be able to perform various operations on homepage.
  verify Bottom of homepage functionalities are enabled and displayed
  Background:
    Given User goes to "https://test.urbanicfarm.com"
    And User scrolls down the home page


  @UI
  Scenario: US017_TC01
    And  User click Discover Local link
    Then User verifies relevant pages url

  @UI
  Scenario: US018/ Get The App should be clickable and visible
    And User clicks on the Get The App
    Then User verifies Get The App visible


  @UI
  Scenario: US019 Clickable and visible
    When User clicks on Sell-Share-Trade under the Features bottom
    Then User verifies "Sell-Share-Trade" visible


  @UI
  Scenario: TC001_About Us should be clickable and relevant page should be visible
    And the user clicks the "About Us".
    Then the user verifies the About us is enabled.
    Then the user verifies the page is "https://test.urbanicfarm.com/about".
    And the user navigate to current.

  @UI
  Scenario: TC001 Privacy Policy should be enabled and relevant page should be displayed
    And the user clicks the Privacy Policy.
    Then the user verifies the Privacy Policy is enabled.
    Then the user verifies the page is "https://test.urbanicfarm.com/privacy-policy".
    And the user navigate to current.
    @UI
  Scenario: TC001_ Terms Of Service should be enabled and relevant page should be displayed
    And the user clicks the Terms Of Service.
    Then the user verifies the Terms Of Service is enabled.
    Then the user verifies the page is "https://test.urbanicfarm.com/terms-of-service".
    When the user navigate to current.


  @UI

  Scenario:
    When User verifies that Address is visible
    Then user verifies the contents of current address

  @UI

  Scenario: US_025, TC001_User should be able to perform various operations on homepage
    And user clicks on phone
    Then user verifies that pop-up is visible


  @UI
  Scenario: US027_TC_001_Facebook icon should be enabled and relevant page should be displayed
    Then User checks the Facebook button is clickable
    Then User clicks the Facebook button




  @UI
  Scenario: TC001_LinkedIn icon should be enabled and relevant page should be displayed
    Then User checks the LinkedIn button is clickable
    Then User clicks the LinkedIn button
