package com.epam.training.student_Rambha_Jha.Task1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Task {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://pastebin.com/");

            WebElement newPasteLink = driver.findElement(By.linkText("New Paste"));
            newPasteLink.click();

            WebElement codeField = driver.findElement(By.id("postform-text"));
            codeField.sendKeys("Hello from WebDriver");

            WebElement expirationDropdown = driver.findElement(By.name("expiry"));
            expirationDropdown.sendKeys("10 Minutes");

            WebElement titleField = driver.findElement(By.id("postform-name"));
            titleField.sendKeys("helloweb");

            WebElement createPasteButton = driver.findElement(By.xpath("//button[contains(text(), 'Create New Paste')]"));
            createPasteButton.click();

        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
