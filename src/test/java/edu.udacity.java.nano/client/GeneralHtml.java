package edu.udacity.java.nano.client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralHtml {

    public WebDriver webDriver;

    public GeneralHtml(WebDriver driver) {
        this.webDriver = driver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public <T> WebDriverWait webDriverWait(long timeoutInSeconds) {
        return new WebDriverWait(this.webDriver, timeoutInSeconds);
    }
}