
Feature: Admin
  I want to use this template for my Admin feature file

  Scenario: Successfully Login with valid credentials
    Given User Launch Chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    And Close browser

 
