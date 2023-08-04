


Feature: US_088 As a user, I should be able to update an existing address.
  @update
  Scenario: TC_001 I should be able to update an existing address.
    Given User sends post request using "endpoint" for login
    And the user updates the address
    And user gets the status code 200
    Then user vefies address is updated
    Then User verifes updating message


