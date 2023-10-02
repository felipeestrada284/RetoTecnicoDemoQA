Feature: DemoQa
  el usuario esta tratando de interactuar en la pagina de demoqa

  @RegisterSuccessful
  Scenario: Web Tables

    Given that the user is on the demoqa home page
    When the user enters the web tables option and adds a new record
    Then delete any records in the table

  @SelectDate
  Scenario: Date Picker

    Given that the user is on the demoqa home page
    When the user enters the date picker option
    Then select dates in select date and date and time

  @TypeOfAlerts
  Scenario: Alerts

    Given that the user is on the demoqa home page
    When the user enters the option alerts
    Then interact with the different types of alerts