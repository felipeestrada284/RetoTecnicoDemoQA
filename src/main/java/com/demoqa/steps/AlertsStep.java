package com.demoqa.steps;


import com.demoqa.pageobjects.AlertsPageObject;
import com.demoqa.utils.DatosExcel;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AlertsStep {

    AlertsPageObject alerts = new AlertsPageObject();
    DatosExcel datos = new DatosExcel();

    @Step
    public void clickAlerts() {
        implicitWait(alerts.getDriver(), alerts.getTxtAlerts());
        alerts.getDriver().findElement(alerts.getTxtAlerts()).click();
    }

    @Step
    public void clickBtnAlerts() {
        JavascriptExecutor jse = (JavascriptExecutor)alerts.getDriver();
        WebElement element = alerts.getDriver().findElement(alerts.getTxtBtnAlerts());
        jse.executeScript("arguments[0].scrollIntoView()", element);
        implicitWait(alerts.getDriver(), alerts.getTxtBtnAlerts());
        alerts.getDriver().findElement(alerts.getTxtBtnAlerts()).click();
    }

    @Step
    public void clickBtnAlertButton() {
        implicitWait(alerts.getDriver(), alerts.getBtnAlertButton());
        alerts.getDriver().findElement(alerts.getBtnAlertButton()).click();
        Alert alert = alerts.getDriver().switchTo().alert();
        alert.accept();
    }

    @Step
    public void clickBtnTimerAlertButton() {
        WebDriverWait wait = new WebDriverWait(alerts.getDriver(),7);

        alerts.getDriver().findElement(alerts.getBtnTimerAlertButton()).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = alerts.getDriver().switchTo().alert();
        alert.accept();
    }

    @Step
    public void clickConfirmButton() {
        implicitWait(alerts.getDriver(), alerts.getBtnConfirmButton());
        alerts.getDriver().findElement(alerts.getBtnConfirmButton()).click();
        Alert alert = alerts.getDriver().switchTo().alert();
        alert.accept();
    }


    @Step
    public void clickCancelButton() {
        alerts.getDriver().findElement(alerts.getBtnConfirmButton()).click();
        Alert alert = alerts.getDriver().switchTo().alert();
        alert.dismiss();
    }

    @Step
    public void validateTextAlert(String textExpected) {
        String textActual = alerts.getDriver().findElement(alerts.getTxtAlertConfirm()).getText();
        System.out.println(textActual);
        assertThat(textActual, is(equalTo(textExpected)));
    }



    @Step
    public void clickPromtButton() throws IOException {
        alerts.getDriver().findElement(alerts.getBtnPromtButton()).click();
        Alert alert = alerts.getDriver().switchTo().alert();
        String alertText = alert .getText();
        System.out.println("Alert text is " + alertText);
        alert.sendKeys(datos.leerDatoExcel("Alert","Data.xlsx",1,0));
        alert.accept();
    }

    @Step
    public void validateTextAlertPromPt(String textExpected) {
        String textActual = alerts.getDriver().findElement(alerts.getTxtAlertPromPt()).getText();
        System.out.println(textActual);
        assertThat(textActual, is(equalTo(textExpected)));
    }

    public static void implicitWait(WebDriver driver, By element){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
