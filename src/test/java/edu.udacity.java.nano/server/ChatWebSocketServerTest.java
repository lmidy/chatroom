package edu.udacity.java.nano.server;

import edu.udacity.java.nano.client.ChatTestPage;
import edu.udacity.java.nano.client.LoginUserTest;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.openqa.selenium.WebDriver;
import edu.udacity.java.nano.config.WebSocketConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebSocketConfig.class})
@WebAppConfiguration
public class ChatWebSocketServerTest {

    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new HtmlUnitDriver(true);
    }

    @After
    public void destroy() {
        if (webDriver != null) {
            webDriver.close();
        }
    }

    @Test
    public void loginAndJoin() throws Exception{
        LoginUserTest page = LoginUserTest.to(webDriver);
        ChatTestPage chat = page.loginAndJoin("Ian");

        (new WebDriverWait(chat.webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                System.out.println("username: " + chat.getUsername().getText());
                return chat.getUsername().getText().equals(page.getUsernameText());
            }
        });
    }

    @Test
    public void chat() throws Exception {
        LoginUserTest page = LoginUserTest.to(webDriver);
        ChatTestPage chat = page.loginAndJoin("Ian");
        chat.sendChatMessage("Hey peeps");

        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                System.out.println("current URL: " + chat.getCurrentUrl());
                return chat.getMessageContent() != null && chat.getMessageContent().getText().contains(page.getUsernameText());
            }
        });
    }

    @Test
    public void logout() throws Exception {

        LoginUserTest page = LoginUserTest.to(webDriver);
        ChatTestPage chat = page.loginAndJoin("Ian");
        chat.sendChatMessage("Hey peeps");


        WebElement element = webDriver.findElement(By.id("logout"));

        element.click();

        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                System.out.println("logout triggered. current URL: " + webDriver.getCurrentUrl());
                return webDriver.getCurrentUrl().equals("http://localhost:8080/");
            }
        });
    }


}

