#language: en

Feature: As a client, I want to update my information in the system

  Scenario: Update existing client information
    Given that client with ID 1 has been registered in the system
    When I update the client's information with valid data
    Then response should have a status code of 200