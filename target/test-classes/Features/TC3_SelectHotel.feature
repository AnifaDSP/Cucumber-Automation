@SelectHotel
Feature: Verifying Adactin Select Hotel Details

  Scenario Outline: Verifying Adactin Select Hotel Details Select By All Feild
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login success message "Hello Anifadsp!"
    And User should enter all the feild "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after Search success message "Select Hotel"
    And User should select a hotel
    Then User should verify after Continue success message "Book A Hotel"

    Examples: 
      | userName | password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Anifadsp | Anifa@786 | Sydney   | Hotel Creek | Deluxe    | 2 - Two         | 05/01/2023    | 08/01/2023     | 1 - One         | 1 - One           |

  Scenario Outline: Verifying Adactin Select Hotel Details Without Select Any Feild
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login success message "Hello Anifadsp!"
    And User should enter all the feild "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after Search success message "Select Hotel"
    And User should not select any feild and click Continue
    Then User should verify after Continue error message "Please Select a Hotel"

    Examples: 
      | userName | password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Anifadsp | Anifa@786 | Sydney   | Hotel Creek | Deluxe    | 2 - Two         | 05/01/2023    | 08/01/2023     | 1 - One         | 1 - One           |
