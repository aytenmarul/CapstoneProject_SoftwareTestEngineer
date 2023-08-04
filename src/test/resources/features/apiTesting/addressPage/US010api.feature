Feature: As a user, I should be able to add an address.

  Background:
    Given User sends post request using "endpoint" for login



  Scenario Outline:
#    Given User sends get request using "endpoint" for login

    When User adds addresses "<Address>","<City>","<isDefault>","<isSellerAddress>","<postal>","<State>","<title>","<emptyBasket>"
    And user gets the status code 200
    Then User verifies the response
    Examples:
      | Address | City        | isDefault | isSellerAddress | postal | State | title  | emptyBasket |
      | US      | Las Vegas   | true      | true            | 1458   | stat  | Home   | false       |
      | US      | Los Angeles | false     | true            | 8453   | stat  | Online | true        |




