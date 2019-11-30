package edu.udacity.java.nano.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ChatTestPage extends GeneralHtml {

    @FindBy(id = "username")
    private WebElement username;

    private WebElement msg;

    @FindBy(id = "sendBtn")
    private WebElement sendBtn;

    private String messageText;

    public ChatTestPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void sendChatMessage(String message) {
        this.messageText = message;
        this.msg.sendKeys(message);
        this.sendBtn.click();
    }

    public WebElement getMessageContent() {
        return super.webDriver.findElement(By.className("message-content"));
    }

    public static ChatTestPage to(WebDriver driver) {
        driver.get("http://localhost:8080/chat/Ian");
        return PageFactory.initElements(driver, ChatTestPage.class);
    }

    public WebElement getMsg() {
        return msg;
    }

    public void setMsg(WebElement msg) {
        this.msg = msg;
    }

    public WebElement getSendBtn() {
        return sendBtn;
    }

    public void setSendBtn(WebElement sendBtn) {
        this.sendBtn = sendBtn;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public WebElement getUsername() {
        return username;
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }

}
