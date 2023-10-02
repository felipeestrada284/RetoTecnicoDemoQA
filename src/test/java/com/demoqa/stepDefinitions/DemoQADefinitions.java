package com.demoqa.stepDefinitions;


import com.demoqa.steps.AlertsStep;
import com.demoqa.steps.DateStep;
import com.demoqa.steps.RegisterStep;
import com.demoqa.utils.DatosExcel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class DemoQADefinitions {

    DatosExcel datos = new DatosExcel();

    @Steps
    RegisterStep register;

    @Steps
    DateStep date;

    @Steps
    AlertsStep alert;


    @Given("^that the user is on the demoqa home page$")
    public void thatTheUserIsOnTheDemoqaHomePage() {
        register.abrirNavegador();
    }

    @When("^the user enters the web tables option and adds a new record$")
    public void theUserEntersTheWebTablesOptionAndAddsANewRecord() throws IOException {
        register.clickElements();
        register.clickBtnElements();
        register.clickItemWebTables();
        register.clickBtnAdd();
        register.addFirstName();
        register.addLastName();
        register.addEmail();
        register.addAge();
        register.addSalary();
        register.addDepartment();
        register.clickBtnSubmit();
        register.validateUserCreated();
    }

    @Then("^delete any records in the table$")
    public void deleteAnyRecordsInTheTable() {
        register.clickRandomBtnDelete();
    }

    //////////////////////////////////////Date Picker///////////////////////////////////////////////////////

    @When("^the user enters the date picker option$")
    public void theUserEntersTheDatePickerOption() {
        date.clickWidgets();
        date.clickDatePicker();

    }
    @Then("^select dates in select date and date and time$")
    public void selectDatesInSelectDateAndDateAndTime() throws IOException {
        date.addSelectDate();
        date.addDateAndTime();
    }

    //////////////////////////////////////Alerts///////////////////////////////////////////////////////
    @When("^the user enters the option alerts$")
    public void theUserEntersTheOptionAlerts() {
        alert.clickAlerts();
        alert.clickBtnAlerts();
    }
    @Then("^interact with the different types of alerts$")
    public void interactWithTheDifferentTypesOfAlerts() throws IOException {
        alert.clickBtnAlertButton();

        alert.clickBtnTimerAlertButton();

        alert.clickConfirmButton();
        alert.validateTextAlert(datos.leerDatoExcel("Alert","Data.xlsx",1,1));
        alert.clickCancelButton();
        alert.validateTextAlert(datos.leerDatoExcel("Alert","Data.xlsx",1,2));

        alert.clickPromtButton();
        alert.validateTextAlertPromPt("You entered "+datos.leerDatoExcel("Alert","Data.xlsx",1,0));

    }
}
