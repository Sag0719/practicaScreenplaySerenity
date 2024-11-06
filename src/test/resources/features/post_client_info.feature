#language: en
Feature: As a client, I want to be registered in the system

  Scenario: Register a new Client
    Given I am connected to the system to register a new client
    When I send a POST request to register myself with my info
    Then the response should have a status code of 201