Feature: US001 test top of homepage functiolanity work without any a bug ;
 Are the Blog, Farmers Market, Explore,About Us,Contact Us, Login, Register modules eanabled ?

  Background:
    Given User goes to "https://test.urbanicfarm.com/"

  @UI
  Scenario: TC001 Urbanic farm logo and titles are displayed
    Given User verifies Urbanic Farm Logo is visible
    And User verifies "Support the local food movement" link is displayed
    And User verifies "<headers>" is visible
      | Blog                            |
      |Farmers Market                   |
      | Explore                         |
      | About Us                        |
      | Contact Us                      |
      | Login                           |
      | Register                        |
  @UI

  Scenario: TC002 Blog is enabled and revelant page
    Given User verifies Blog Link is clickable and clicks
    Then User verifies relevant Blog Page with url
  @UI

  Scenario: TC003 Explore enabled and revelant page
    When user clicks to explore button
#    Then user verifies relevant page is "https://test.urbanicfarm.com/"
  @UI
  Scenario: TC004 About Us enabled and revelant page
    When user clicks to About Us button
#    Then user verifies relevant page is "https://test.urbanicfarm.com/about"
   @UI
  Scenario: TC005 To check if Contact Us link is enabled to Contact Us page when it clicked
    And User checks the Contact Us button is clickable
    Then User clicks Contact Us button
    Then User verifies if Contact Us page is visible

  @UI
  Scenario: TC006 To check if Login link is clickable and passing to Login page when it clicked
    Then User clicks Login button
    And User checks the Login button is clickable
    Then User verifies if Login page is visible

  @UI

  Scenario: TC007 Backyard gardeners and farmers join the Movement For Free! The "register now" button at the bottom should be clickable
    Then User assert register now button is clickable
    When User clicks on register now button
    Then User verified the url is "https://test.urbanicfarm.com/auth/register"


