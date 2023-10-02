package com.demoqa.steps;


import com.demoqa.pageobjects.RegisterPageObject;
import com.demoqa.utils.DatosExcel;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegisterStep {

    RegisterPageObject register = new RegisterPageObject();
    DatosExcel datos = new DatosExcel();

    @Step
    public void abrirNavegador() {
        register.open();
    }

    @Step
    public void clickElements() {
        implicitWait(register.getDriver(), register.getTxtElements());
        register.getDriver().findElement(register.getTxtElements()).click();
    }

    @Step
    public void clickBtnElements() {
        implicitWait(register.getDriver(), register.getBtnElements());
        register.getDriver().findElement(register.getBtnElements()).click();
    }

    @Step
    public void clickItemWebTables() {
        implicitWait(register.getDriver(), register.getBtnWebTables());
        register.getDriver().findElement(register.getBtnWebTables()).click();
    }

    @Step
    public void clickBtnAdd() {
        register.getDriver().findElement(register.getBtnAdd()).click();
    }

    @Step
    public void addFirstName() throws IOException {
        implicitWait(register.getDriver(), register.getTxtFirstName());
        register.getDriver().findElement(register.getTxtFirstName()).sendKeys(datos.leerDatoExcel("Register","Data.xlsx",1,0));
        System.out.println(datos.leerDatoExcel("Register","Data.xlsx",1,0));
    }

    @Step
    public void addLastName() throws IOException {
        register.getDriver().findElement(register.getTxtLastName()).sendKeys(datos.leerDatoExcel("Register","Data.xlsx",1,1));
    }

    @Step
    public void addEmail() throws IOException {
        register.getDriver().findElement(register.getTxtEmail()).sendKeys(datos.leerDatoExcel("Register","Data.xlsx",1,2));
    }

    @Step
    public void addAge() throws IOException {
        register.getDriver().findElement(register.getTxtAge()).sendKeys(datos.leerDatoExcel("Register","Data.xlsx",1,3));
    }

    @Step
    public void addSalary() throws IOException {
        register.getDriver().findElement(register.getTxtSalary()).sendKeys(datos.leerDatoExcel("Register","Data.xlsx",1,4));
    }

    @Step
    public void addDepartment() throws IOException {
        register.getDriver().findElement(register.getTxtDepartment()).sendKeys(datos.leerDatoExcel("Register","Data.xlsx",1,5));
    }

    @Step
    public void clickBtnSubmit() {
        register.getDriver().findElement(register.getBtnSubmit()).click();
    }

    @Step
    public void validateUserCreated() throws IOException {

        String nameUserCreated = register.getDriver().findElement(register.getTxtValidar()).getText();
        System.out.println("name: " + nameUserCreated);
        assertThat(nameUserCreated, is(equalTo(datos.leerDatoExcel("Register","Data.xlsx",1,0))));
    }


    @Step
    public void clickRandomBtnDelete() {
        List<WebElement> btnDelete = register.getDriver().findElements(register.getImgbtnDelete());

        if (!btnDelete.isEmpty()) {
            int randomIndex = new Random().nextInt(btnDelete.size());
            WebElement randomBtnDelete = btnDelete.get(randomIndex);
            randomBtnDelete.click();
        } else {
            System.out.println("No se encontraron elementos para Eliminar.");
        }
    }



    public static void implicitWait(WebDriver driver, By element){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}


