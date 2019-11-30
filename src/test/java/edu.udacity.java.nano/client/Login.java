package edu.udacity.java.nano.client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends GeneralHtml {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(className = "submit")
    private WebElement submit;

    private String usernameText;

    public Login(WebDriver driver) {
        super(driver);
    }

    public Chat userJoin(String username) {
        this.usernameText = username;
        this.username.sendKeys(username);
        this.submit.click();
        return PageFactory.initElements(super.webDriver, Chat.class);
    }

    public static Login to(WebDriver driver) {
        driver.get("http://localhost:8080/");
        return PageFactory.initElements(driver, Login.class);
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