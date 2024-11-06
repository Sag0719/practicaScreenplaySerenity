#language: en
Feature: As a client, I want to delete my information from the system

  Scenario: Delete a new Client
    Given I am connected to the system to delete a client
    When I send a DELETE request to delete my info from the system
    Then the response should have a status code of 200