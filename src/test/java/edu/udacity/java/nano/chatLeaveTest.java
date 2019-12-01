package edu.udacity.java.nano;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class chatLeaveTest {

    public static void main(String[] args) {

        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/chat/Ian";
        driver.get(baseUrl);

        // Get the WebElement corresponding to the message
        WebElement message = driver.findElement(By.id("msg"));

        message.sendKeys("Hello Peeps ");
        System.out.println("Chat Message entered on input");

        // Deleting values in the text box
        message.clear();
        System.out.println("Text Field Cleared");

        // Find the send button
        WebElement sendButton = driver.findElement(By.id("sendBtn"));

        // Using click method to submit form
        message.sendKeys("Hello Peeps");

        sendButton.click();
        System.out.println("Chat Message Sent");

        //using submit method to submit the form. Submit
        driver.findElement(By.id("sendBtn")).submit();
        System.out.println("Login Done with Submit");

        //driver.close();

    }
}