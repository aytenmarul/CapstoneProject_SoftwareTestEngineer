Feature: As a user, I should be able to contact to Urbanic Farm
  Scenario:Send a get request and verify the statusCode and server for login
    Given User sends get request using "endpoint" for login
    And  user verifies the status code  200
    And  user verifies the content type is "contentType"
