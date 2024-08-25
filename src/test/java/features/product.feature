Feature: Test Automation of Core and Derived Products Testcases

 Scenario Outline: Store Men's Product details in .txt file
   Given User triggers URL:"<url>" in Browser
   When User validates presale notification and closes the same
   Then user clicks on "<pageName>" on the Shop Menu
   And User changes max item to "<maxItem>" in men's page
   And user goes to each Page and stores data in text file

   Examples:
   |url|pageName|maxItem|
   |https://www.nba.com/warriors   |Men's|96 Items|