Feature: This is to verify place is getting added

  Scenario Outline: Verify if Place is getting added successfully
    Given User prepares addPlace payload with "<name>","<address>","<language>"
    When User sends POST method
    Then API call is success with status code 200
    And the "status" should be "OK"
    And the "scope" should be "APP"

    Examples:
    |name      |address                     | language  |
    |Ahouse    |29, side layout, cohen 09   |  English  |
    |Bhouse    |30, side layout, cohen 09   |  English  |
    |Chouse    |31, side layout, cohen 09   |  English  |
