package edu.udacity.java.nano.client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUserTest extends GeneralHtml {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(className = "submit")
    private WebElement submit;

    private String usernameText;

    public LoginUserTest(WebDriver driver) {
        super(driver);
    }

    public ChatTestPage loginAndJoin(String username) {
        this.usernameText = username;
        this.username.sendKeys(username);
        this.submit.click();
        return PageFactory.initElements(super.webDriver, ChatTestPage.class);
    }

    public static LoginUserTest to(WebDriver driver) {
        driver.get("http://localhost:8080/");
        return PageFactory.initElements(driver, LoginUserTest.class);
    }

    public WebElement getUsername() {
        return username;
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public void setSubmit(WebElement submit) {
        this.submit = submit;
    }

    public String getUsernameText() {
        return usernameText;
    }

    public void setUsernameText(String usernameText) {
        this.usernameText = usernameText;
    }
}