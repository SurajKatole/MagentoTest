@SignUp
Feature: Sign Up New User


  @SignUpWithAllBlankFields
  Scenario: SignUp for magento with All blank fields
    Given User accesses the site url in browser
    When User chooses create a new account option
    Then User enters First Name as "<firstName>" and Last Name as "<lastName>"
    And User enters Email as "<email>" and Password as "<password>" and confirm password as "<password>" then clicks create account button
    And User verifies for failed Sign Up


  @SignUpWithAllBlankNames
  Scenario Outline: SignUp for magento with Name fields blank
    Given User navigates the site url in browser
    When User chooses create a new account option
    Then User enters First Name as "" and Last Name as ""
    And User enters Email as "<email>" and Password as "<password>" and confirm password as "<password>" then clicks create account button
    And User verifies for failed Sign Up
    Examples:
      | email                | password      |
      | newemail8987@gmail.com | Password@1234 |

  @SignUpWithBlankEmail
  Scenario Outline: SignUp for magento with Email field blank
    Given User navigates the site url in browser
    When User chooses create a new account option
    Then User enters First Name as "<firstName>" and Last Name as "<lastName>"
    And User enters Email as "<email>" and Password as "<password>" and confirm password as "<password>" then clicks create account button
    And User verifies for failed Sign Up
    Examples:
      | firstName | lastName | password      |
      | Suraj     | Katole   | Password@1234 |

 @SignUpWithBlankPassword
  Scenario Outline: SignUp for magento with Password fields blank
    Given User navigates the site url in browser
    When User chooses create a new account option
    Then User enters First Name as "<firstName>" and Last Name as "<lastName>"
   And User enters Email as "<email>" and Password as "<password>" and confirm password as "<password>" then clicks create account button
   And User verifies for failed Sign Up
    Examples:
      | firstName | lastName | email                |
      | Suraj     | Katole   | newemail8987@gmail.com |

  @SignUpWithInvalidEmail
  Scenario Outline: SignUp for magento with Invalid Email
    Given User navigates the site url in browser
    When User chooses create a new account option
    Then User enters First Name as "<firstName>" and Last Name as "<lastName>"
    And User enters Email as "<email>" and Password as "<password>" and confirm password as "<password>" then clicks create account button
    And User verifies for failed Sign Up
    Examples:
      | firstName | lastName | email        | password      |
      | Suraj     | Katole   | newemail8987 | Password@1234 |

  @SignUpWithPasswordAndDifferentConfirmPassword
  Scenario Outline: SignUp for magento with Different Password and Confirm password field
    Given User navigates the site url in browser
    When User chooses create a new account option
    Then User enters First Name as "<firstName>" and Last Name as "<lastName>"
    And User enters Email as "<email>" and Password as "<password>" and confirm password as "<confirmPassword>" then clicks create account button
    And User verifies for failed Sign Up
    Examples:
      | firstName | lastName | email                | password      | confirmPassword |
      | Suraj     | Katole   | newemail8987@gmail.com | Password@1234 | Password@123  |

  @SignUpWithValidCredentials
  Scenario Outline: SignUp for magento with valid credentials
    Given User navigates the site url in browser
    When User chooses create a new account option
    Then User enters First Name as "<firstName>" and Last Name as "<lastName>"
    And User enters Email as "<email>" and Password as "<password>" and confirm password as "<password>" then clicks create account button
    Then User verifies if Signed Up Successfully
    Then User signs out of the application
    Then User closes the browser
    Examples:
      | firstName | lastName | email                | password      |
      | Suraj     | Katole   | newemailone1431@gmail.com | Password@1234 |


#


