Feature: Book search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.
  
  Background: 
     Given I have the following books in the store
      | title                                    | author            | category | published  |
      | Emma                                     | Jane Austen       | Romance  | 1815-12-23 |
      | Pride and Prejudice                      | Jane Austen       | Romance  | 1813-01-28 |
      | Harry Potter and the Philosopher's Stone | J. K. Rowling     | Fiction  | 1997-06-26 |


  Scenario: Search books by publication year
    Given I have the following books in the store
      | title              | author          | category | published  |
      | One good book      | Anonymous       | Good     | 2013-03-14 |
      | Some other book    | Tim Tomson      | Meh      | 2014-08-23 |
      | How to cook a dino | Fred Flintstone | Cooking  | 2012-01-01 |
    When the customer searches for books published between 2013-01-01 and 2014-01-01
    Then 2 books should have been found
    And Book 1 should have the title 'Some other book'
    And Book 2 should have the title 'One good book'

  Scenario: Search books by name
    When the customer searches for books published by 'Jane Austen'
    Then 2 books should have been found
    And Book 1 should have the title 'Emma'
    And Book 2 should have the title 'Pride and Prejudice'

  Scenario: Search books by category
    When the customer searches for books with the category 'Romance'
    Then 2 books should have been found
    And Book 1 should have the title 'Emma'
    And Book 2 should have the title 'Pride and Prejudice'

  Scenario: Search books by title
    When the customer searches for books with the title 'Emma'
    Then 1 books should have been found
    And Book 1 should have the title 'Emma'