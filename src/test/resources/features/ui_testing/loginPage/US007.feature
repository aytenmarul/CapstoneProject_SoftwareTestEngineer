Feature:As a user, I should not be able to type invalid infoin name box
  @UI
  Scenario: As a user, I should be able to check valid and invalid name, surname, email.
    Given user goes to website
    And user clicks on the register button on the navbar
    When user send a to first name on the registration form
    Then firstname text suppose to be red
    When user click on enter
    Then user suppose to see "Please lengthen this text to 2 characters or more (you are currently using 1 character)." text
    When user send a to first name on the registration form
    Then firstname text suppose to be black


