@BookHotel
Feature: Verifying Adactin Book Hotel Details


  Scenario Outline: Verifying Adactin Book Hotel Details Enter By All Feild
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login success message "Hello Anifadsp!"
    And User should enter all the feild "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after Search success message "Select Hotel"
    And User should select a hotel
    Then User should verify after Continue success message "Book A Hotel"
    And User should enter all the feild "<First Name>","<Last Name>" and "<Billing Address>"
      | Credit Card No   | Credit Card Type | Expiry Month | Expiry Year | CVV Number |
      | 3456759412483245 | VISA             | December     |        2022 |        254 |
      | 3548457921453246 | Master Card      | November     |        2021 |        202 |
      | 4568579812457895 | American Express | April        |        2017 |        584 |
    Then User should verify After Booking success message "Booking Confirmation" and save the generated Order Id

    Examples: 
      | userName | password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | First Name | Last Name | Billing Address |
      | Anifadsp | Anifa@786 | Sydney   | Hotel Creek | Deluxe    | 2 - Two         | 05/01/2023    | 08/01/2023     | 1 - One         | 1 - One           | Anifa      | Mohamed S | AuibSait Street |

  Scenario Outline: Verifying Adactin Book Hotel Details Without Enter Any Feild
    Given User is an Adactin Page
    When User should Perform Login "<userName>" and "<password>"
    Then User should verify after Login success message "Hello Anifadsp!"
    And User should enter all the feild "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after Search success message "Select Hotel"
    And User should select a hotel
    Then User should verify after Continue success message "Book A Hotel"
    And User should not enter any feild in BookHotel
    Then User should verify after Booking error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName | password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Anifadsp | Anifa@786 | Sydney   | Hotel Creek | Deluxe    | 2 - Two         | 05/01/2023    | 08/01/2023     | 1 - One         | 1 - One           |
