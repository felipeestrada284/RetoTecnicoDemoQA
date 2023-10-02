package com.demoqa.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://demoqa.com/")
public class RegisterPageObject extends PageObject {

    By txtElements = By.xpath("//div/div/div/div[contains(.,'Elements')]");
    By btnElements = By.xpath("//span[contains(.,'Elements')]");
    By btnWebTables = By.xpath("//div/ul/li[@id = 'item-3']");
    By btnAdd = By.id("addNewRecordButton");
    By txtFirstName = By.id("firstName");
    By txtLastName = By.id("lastName");
    By txtEmail = By.id("userEmail");
    By txtAge = By.id("age");
    By txtSalary = By.id("salary");
    By txtDepartment = By.id("department");
    By btnSubmit = By.id("submit");
    //By imgbtnDelete = By.id("delete-record-1");
    By imgbtnDelete = By.xpath("//span[@title='Delete']");
    By txtValidar = By.xpath("//div[contains(text(), 'Felipe')]");

    public By getTxtElements() {
        return txtElements;
    }

    public By getBtnElements() {
        return btnElements;
    }

    public By getBtnWebTables() {
        return btnWebTables;
    }

    public By getBtnAdd() {
        return btnAdd;
    }

    public By getTxtFirstName() {
        return txtFirstName;
    }

    public By getTxtLastName() {
        return txtLastName;
    }

    public By getTxtEmail() {
        return txtEmail;
    }

    public By getTxtAge() {
        return txtAge;
    }

    public By getTxtSalary() {
        return txtSalary;
    }

    public By getTxtDepartment() {
        return txtDepartment;
    }

    public By getBtnSubmit() {
        return btnSubmit;
    }

    public By getImgbtnDelete() {
        return imgbtnDelete;
    }

    public By getTxtValidar() {
        return txtValidar;
    }
}

