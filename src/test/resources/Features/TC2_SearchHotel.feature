@SearchHotel
Feature: Verifying Adactin Search Hotel Details
	
  Scenario Outline: Verifying Adactin Search Hotel Details Select By All Feild
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login success message "Hello Anifadsp!"
    And User should enter all the feild "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after Search success message "Select Hotel"

    Examples: 
      | userName | password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Anifadsp | Anifa@786 | Sydney   | Hotel Creek | Deluxe    | 2 - Two         | 05/01/2023    | 08/01/2023     | 1 - One         | 1 - One           |

	
  Scenario Outline: Verifying Adactin Search Hotel Details By Enter Mandatory Feild
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login success message "Hello Anifadsp!"
    And User should enter only mandatory feild "<Location>","<Number of Rooms>","<Check In Date>","<Check Out Date>" and "<Adults per Room>"
    Then User should verify after Search success message "Select Hotel"

    Examples: 
      | userName | password  | Location | Number of Rooms | Check In Date | Check Out Date | Adults per Room |
      | Anifadsp | Anifa@786 | Sydney   | 2 - Two         | 05/01/2023    | 08/01/2023     | 2 - Two         |

  Scenario Outline: Verifying Adactin Search Hotel Details With CheckIn Date Should Be High
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login success message "Hello Anifadsp!"
    And User should enter all the feild "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after Search with Invalid Credential error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName | password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Anifadsp | Anifa@786 | Sydney   | Hotel Creek | Deluxe    | 2 - Two         | 05/01/2025    | 08/01/2023     | 1 - One         | 1 - One           |

  Scenario Outline: Verifying Adactin Search Hotel Details Without Select Any Feild
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login success message "Hello Anifadsp!"
    And User should not enter any feild
    Then User should verify after Search error message "Please Select a Location"

    Examples: 
      | userName | password  |
      | Anifadsp | Anifa@786 |
