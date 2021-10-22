Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario: Check that User can see additional menu when additional menu button is clicked
    Given User opens homepage
    When User clicks on additional menu button
    Then additional menu is visible to the User

  Scenario: Check that not logged in User can see specific massage in additional menu header
    Given User opens homepage
    When User clicks on additional menu button
    Then User checks that massage in additional menu header is Hello, Sign in

  Scenario: Check that User when input incorrect email in sign in email field get error massage
    Given User opens homepage
    And User clicks on additional menu button
    And User checks that massage in additional menu header is Hello, Sign in
    And User clicks massage for unsigned customers
    When User set incorrect email in email field on sign in page
    And User clicks continue button
    Then Massage about error is popup and equals to specific query for this scenario

  Scenario: Check that User can log in when correct data is set
    Given User opens homepage
    And User clicks on additional menu button
    And User checks that massage in additional menu header is Hello, Sign in
    And User clicks massage for unsigned customers
    When User enter correct email in email field on sign in page
    And  User clicks continue button
    And User enter correct password in password input field
    And User clicks sign in button
    And User clicks on additional menu button
    Then User checks that additional menu header contains Hello, and his name

  Scenario: Check that logged User with empty cart can see right amount of recommended items
    Given User opens homepage
    And User clicks on additional menu button
    And User checks that massage in additional menu header is Hello, Sign in
    And User clicks massage for unsigned customers
    And User enter correct email in email field on sign in page
    And  User clicks continue button
    And User enter correct password in password input field
    And User clicks sign in button
    When User clicks cart button
    And User clicks recommended items button
    Then User checks right amount of recommendations product categories must show up

  Scenario: Check that logged User cant create new list without name
    Given User opens homepage
    And User clicks on additional menu button
    And User checks that massage in additional menu header is Hello, Sign in
    And User clicks massage for unsigned customers
    And User enter correct email in email field on sign in page
    And  User clicks continue button
    And User enter correct password in password input field
    And User clicks sign in button
    And User clicks create a list button
    When User don't input in list name any value
    And User clicks create list button
    Then User can see specific error massage


  Scenario Outline: Check that search result items are visible for the User
    Given User opens '<homepage>'
    When User set '<search keys>' in the search field
    And User clicks search submit button
    Then User checks  product image of search result is visible
    Examples:
      | homepage                | search keys  |
      | https://www.amazon.com/ | xiaomi mi 11 |

  Scenario Outline: Check that User can add product to list when product is available
    Given User opens '<homepage>'
    And User clicks on additional menu button
    And User checks that massage in additional menu header is Hello, Sign in
    And User clicks massage for unsigned customers
    When User enter correct email in email field on sign in page
    And  User clicks continue button
    And User enter correct password in password input field
    And User clicks sign in button
    And User set '<search keys>' in the search field
    And User clicks search submit button
    And User checks  product image of search result is visible
    And User clicks on the first product of search result products list
    When User clicks on the add to list button on product page
    Then User see '<massage>' about item adding to the wishlist
    Examples:
      | homepage                | search keys              | massage                       |
      | https://www.amazon.com/ | xiaomi redmi note 10     | 1 item added to Shopping List |
      | https://www.amazon.com/ | xiaomi redmi note 10 pro | 1 item added to Shopping List |
      | https://www.amazon.com/ | keyboard                 | 1 item added to Shopping List |

  Scenario: Check that User can delete product from list when product is available
    Given User opens homepage
    And User clicks on additional menu button
    And User checks that massage in additional menu header is Hello, Sign in
    And User clicks massage for unsigned customers
    When User enter correct email in email field on sign in page
    And  User clicks continue button
    And User enter correct password in password input field
    And User clicks sign in button
    And User opens his shopping list
    When User wants to delete products from list he clicks all delete buttons in his list
    And User refresh list page
    Then User checks that his list is empty and see massage



  Scenario Outline: Check that User can see correct massage when item is out of stock
    Given User opens '<homepage>'
    And User set '<search keys>' in the search field
    And User clicks search submit button
    And User checks  product image of search result is visible
    When User clicks on the first product of search result products list
    Then User check there is special massage if product out of stock
    Examples:
      | homepage                | search keys          |
      | https://www.amazon.com/ | xiaomi redmi note 10 |







