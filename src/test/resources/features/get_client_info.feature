#language: en
Feature: As a client, I need to manage my information


  Scenario: Register a new Client
    Given I am connected to the system
    When I send a POST request to register myself with my info
    Then the response should have a status code of 201