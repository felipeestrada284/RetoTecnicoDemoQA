package com.demoqa.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://demoqa.com/")
public class DatePageObject extends PageObject {

    By txtWidgets = By.xpath("//div[contains(@class, 'card mt-4 top-card')][contains(., 'Widgets')]");
    By txtDatePicker = By.xpath("//span[contains(.,'Date Picker')]");
    By txtDate = By.id("datePickerMonthYearInput");
    By txtDateAndTime = By.id("dateAndTimePickerInput");

    public By getTxtWidgets() {
        return txtWidgets;
    }

    public By getTxtDatePicker() {
        return txtDatePicker;
    }

    public By getTxtDate() {
        return txtDate;
    }

    public By getTxtDateAndTime() {
        return txtDateAndTime;
    }
}
