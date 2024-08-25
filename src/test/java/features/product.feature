Feature: Test Automation of Core and Derived Products Testcases

  @Test1
 Scenario Outline: Store Men's Product details in .txt file
   Given User triggers URL:"<url>" in Browser
   When User validates presale notification and closes the same
   Then user clicks on "<pageName>" on the Shop Menu
   And User changes max item to "<maxItem>" in men's page
   And user goes to each Page and stores data in text file

   Examples:
   |url|pageName|maxItem|
   |https://www.nba.com/warriors   |Men's|96 Items|

    @Test2
 Scenario Outline: Validate total videos feed count in Core Product
   Given User triggers URL:"<url>" in Browser
   When User validates presale notification and closes the same
   Then User goes to newsfeed page
   And User notes video count for more than three days
   Examples:
     |url|
     |https://www.nba.com/warriors   |


  @DerivedProduct2
  Scenario Outline: Validate total Hyperlink count in Derived Product
    Given User triggers URL:"<url>" in Browser
    When User goes to page bottom
    Then Check duplicates in hyperlinks

    Examples:
      |url|
      |https://www.nba.com/bulls/   |

