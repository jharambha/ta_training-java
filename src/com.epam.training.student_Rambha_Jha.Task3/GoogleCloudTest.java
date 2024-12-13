package com.epam.training.student_Rambha_Jha.Task3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCloudTest {
    private WebDriver driver;
    private GoogleCloudPage googleCloudPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        googleCloudPage = new GoogleCloudPage(driver);
    }

    @Test
    public void testGoogleCloudPricingCalculator() {
        googleCloudPage.open();
        
       googleCloudPage.searchForCalculator();

       googleCloudPage.navigateToComputeEngine();

       googleCloudPage.fillOutForm();

       String estimatedCostText = googleCloudPage.getEstimatedCost();
       Assert.assertTrue(estimatedCostText.contains("Total Estimated Cost: USD"));

       googleCloudPage.shareEstimate();

   }

   @After
   public void tearDown() {
       driver.quit();
   }
}
