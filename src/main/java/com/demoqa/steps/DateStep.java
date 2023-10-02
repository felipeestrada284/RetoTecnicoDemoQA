package com.demoqa.steps;


import com.demoqa.pageobjects.DatePageObject;
import com.demoqa.utils.DatosExcel;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class DateStep {

    DatePageObject date = new DatePageObject();
    DatosExcel datos = new DatosExcel();

    @Step
    public void clickWidgets() {
        implicitWait(date.getDriver(), date.getTxtWidgets());
        date.getDriver().findElement(date.getTxtWidgets()).click();
    }

    @Step
    public void clickDatePicker() {
        JavascriptExecutor jse = (JavascriptExecutor)date.getDriver();
        WebElement element = date.getDriver().findElement(date.getTxtDatePicker());
        jse.executeScript("arguments[0].scrollIntoView()", element);
        implicitWait(date.getDriver(), date.getTxtDatePicker());
        date.getDriver().findElement(date.getTxtDatePicker()).click();
    }

    @Step
    public void addSelectDate() throws IOException {

        date.getDriver().findElement(date.getTxtDate()).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        date.getDriver().findElement(date.getTxtDate()).sendKeys(datos.leerDatoExcel("Date","Data.xlsx",1,0));
        date.getDriver().findElement(date.getTxtDate()).sendKeys(Keys.chord(Keys.ENTER));
    }

    @Step
    public void addDateAndTime() throws IOException {
        date.getDriver().findElement(date.getTxtDateAndTime()).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        date.getDriver().findElement(date.getTxtDateAndTime()).sendKeys(datos.leerDatoExcel("Date","Data.xlsx",1,1));
        date.getDriver().findElement(date.getTxtDateAndTime()).sendKeys(Keys.chord(Keys.ENTER));
    }

    public static void implicitWait(WebDriver driver, By element){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
