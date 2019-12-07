package edu.udacity.java.nano;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebSocketApplicationTests {
    private static String USERNAME = "testing";
    private static String BASE_URL = "http://localhost:8080/";
    private static String CHAT_URL = BASE_URL + "index?username=" +USERNAME;

    private static WebDriver webDriver;

    @Before
    public void initialization() {
        System.setProperty("webdriver.chrome.driver",
                "/chatroom-starter/chromedriver.exe");
        webDriver  = new ChromeDriver();
        webDriver.get(BASE_URL);
    }

    @Test
    public void testLogin() {
        webDriver.get(BASE_URL);
        Assert.assertEquals(webDriver.getTitle(), "Chat Room Login");
    }

    @Test
    public void testJoin() {
        webDriver.get(BASE_URL);
        WebElement username = webDriver.findElement(By.id("username"));
        username.sendKeys(USERNAME);
        WebElement loginButton = webDriver.findElement(By.id("submit"));
        loginButton.click();
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, CHAT_URL);
    }

    @Test
    public void testChat() {
        String message = "Selenium Web Driver Test";
        webDriver.get(CHAT_URL);

        WebElement messageInput = webDriver.findElement(By.id("msg"));
        messageInput.sendKeys(message);

        WebElement sendButton = webDriver.findElement(By.id("sendBtn"));
        sendButton.click();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("message-content"),1));

        List<WebElement> messageElements = webDriver.findElements((By.className("message-content")));
        WebElement messageElement = messageElements.get(messageElements.size() -1);
        Assert.assertEquals(USERNAME + ":" +message, messageElement.getText());
    }

    @Test
    public void testLeave() {
        webDriver.get(CHAT_URL);
        webDriver.findElement(By.id("logout")).click();
        Assert.assertEquals(BASE_URL, webDriver.getCurrentUrl());
    }

    @AfterClass
    public static void destroy() {
        if(webDriver != null){
            webDriver.quit();
        }
    }


}
