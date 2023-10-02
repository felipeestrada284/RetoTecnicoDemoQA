package com.demoqa.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://demoqa.com/")
public class AlertsPageObject extends PageObject {

    By txtAlerts = By.xpath("//div[3][contains(.,'Alerts, Frame & Windows')]");
    By txtBtnAlerts = By.xpath("//span[text()='Alerts']");
    By btnAlertButton = By.id("alertButton");
    By btnTimerAlertButton= By.id("timerAlertButton");
    By btnConfirmButton = By.id("confirmButton");
    By btnPromtButton = By.id("promtButton");
    By txtAlertConfirm = By.xpath("//span[contains(text(),'You selected')]");
    By txtAlertPromPt = By.xpath("//span[contains(text(),'You entered ')]");

    public By getTxtAlerts() {
        return txtAlerts;
    }

    public By getTxtBtnAlerts() {
        return txtBtnAlerts;
    }

    public By getBtnAlertButton() {
        return btnAlertButton;
    }

    public By getBtnTimerAlertButton() {
        return btnTimerAlertButton;
    }

    public By getBtnConfirmButton() {
        return btnConfirmButton;
    }

    public By getBtnPromtButton() {
        return btnPromtButton;
    }

    public By getTxtAlertConfirm() {
        return txtAlertConfirm;
    }

    public By getTxtAlertPromPt() {
        return txtAlertPromPt;
    }
}
