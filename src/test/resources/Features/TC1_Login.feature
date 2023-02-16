@Login
Feature: Verifying Adactin Hotel Login Details

  Scenario Outline: Verifying Adactin Hotel Login Valid
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login success message "Hello Anifadsp!"

    Examples: 
      | userName | password  |
      | Anifadsp | Anifa@786 |

  Scenario Outline: Verifying Adactin Hotel Login Valid and Enter
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>" with enter
    Then User should verify after Login success message "Hello Anifadsp!"

    Examples: 
      | userName | password  |
      | Anifadsp | Anifa@786 |

  Scenario Outline: Verifying Adactin Hotel Login
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login with Invalid Credential error message contains "Invalid Login details or Your Password might have expired. "

    Examples: 
      | userName | password    |
      | AnifaDSP | Anifa@78600 |
