
@tag
Feature:Error Validation
  I want validate the error displayed when log in with wrong email and password

 


  @LoginErrorValidation
  Scenario Outline: Login Eror Validation
    Given I landed on Ecommerce Page
    And Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name  								|  password		    |
      | olu7777@gmail.com     |  AA123456       |

      