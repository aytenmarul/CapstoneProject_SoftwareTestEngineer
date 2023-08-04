
Feature: US002 The "Whats Near You, Post Your Goods" heading under the "Reduce waste,strengthen your Community"
  heading should be clickable
  Background:
    Given User goes to "https://test.urbanicfarm.com/"
  @UI
  @US013
  Scenario: TC001  The "Register Now" heading should be clickable
    And user goes to the "Contribution to the Environment and Society" heading
    Then user verifies that the "Register Now" heading is clickable

  @UI
  @US014
  Scenario: TC002 The "Whats Near You,Post Your Goods" heading should be clickable

    And user goes  the "Reduce waste,strengthen your community" heading
    Then user verifies  the "Whats Near You,Post Your Goods" heading is clickable


  @UI
  @US15

  Scenario: TC003 The Go Wefunder button in the Invest in Urbanic Farm header should be clickable
    Then  User assert the go wefunder  button is clickable
    When  User clicks on go wefunder button
    Then  User verified the url is "https://wefunder.com/urbanicfarm"

