Feature: Place an order from Amazon

 
  Scenario: Place an order from Amazon 
    Given User launches Amazon website
    Then Verify Title of the website
    When change the catagories to Books
    Then search for a Book <wings of fire>
    When Select the Book 
    Then Click on Buy button 