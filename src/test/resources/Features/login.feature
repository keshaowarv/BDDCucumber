

Feature: Amazon website feature to test add iphone product

Scenario: check login is successful with valid credentials and add the product into the cart
Given user is log onto the Amazon Website Home page
When user searches a I phone product on the home page
Then user should be able to view product and add to cart product
And closed