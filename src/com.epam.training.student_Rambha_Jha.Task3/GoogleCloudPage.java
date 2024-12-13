package com.epam.training.student_Rambha_Jha.Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleCloudPage {
    private WebDriver driver;

   
    private By searchIcon = By.xpath("//button[@aria-label='Search']");
    private By searchField = By.name("q");
    private By searchResult = By.xpath("//h3[contains(text(), 'Google Cloud Platform Pricing Calculator')]");
    private By computeEngineLink = By.xpath("//md-tab[.//span[text()='COMPUTE ENGINE']]");
    
    
    private By instancesField = By.id("input_67");
    private By osDropdown = By.id("select_69");
    private By provisioningModelDropdown = By.id("select_70");
    private By machineFamilyDropdown = By.id("select_71");
    private By seriesDropdown = By.id("select_72");
    private By machineTypeDropdown = By.id("select_73");
    private By addGPUsButton = By.xpath("//button[contains(text(), 'Add GPUs')]");
    private By gpuTypeDropdown = By.id("select_75");
    private By numberOfGPUsField = By.id("input_76");
    private By localSSDField = By.xpath("//md-checkbox[@aria-label='Add Local SSD']");
    private By datacenterLocationDropdown = By.id("select_77");
    private By committedUsageDropdown = By.id("select_78");
    
    
    private By addToEstimateButton = By.xpath("//button[contains(text(), 'Add to Estimate')]");
    
    public GoogleCloudPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://cloud.google.com/");
    }

    public void searchForCalculator() {
        driver.findElement(searchIcon).click();
        driver.findElement(searchField).sendKeys("Google Cloud Platform Pricing Calculator");
        driver.findElement(searchField).submit();
        driver.findElement(searchResult).click();
    }

    public void navigateToComputeEngine() {
        driver.findElement(computeEngineLink).click();
    }

    public void fillOutForm() {
        driver.findElement(instancesField).sendKeys("4");

        
        WebElement osSelect = driver.findElement(osDropdown);
        osSelect.click();
        osSelect.findElement(By.xpath("//md-option[contains(text(), 'Free: Debian, CentOS, CoreOS, Ubuntu, or another User-Provided OS')]")).click();

        
        WebElement provisioningSelect = driver.findElement(provisioningModelDropdown);
        provisioningSelect.click();
        provisioningSelect.findElement(By.xpath("//md-option[contains(text(), 'Regular')]")).click();

        
        WebElement machineFamilySelect = driver.findElement(machineFamilyDropdown);
        machineFamilySelect.click();
        machineFamilySelect.findElement(By.xpath("//md-option[contains(text(), 'General purpose')]")).click();

        
        WebElement seriesSelect = driver.findElement(seriesDropdown);
        seriesSelect.click();
        seriesSelect.findElement(By.xpath("//md-option[contains(text(), 'N1')]")).click();

        
        WebElement machineTypeSelect = driver.findElement(machineTypeDropdown);
        machineTypeSelect.click();
        machineTypeSelect.findElement(By.xpath("//md-option[contains(text(), 'n1-standard-8')]")).click();

        
        driver.findElement(addGPUsButton).click();
        WebElement gpuTypeSelect = driver.findElement(gpuTypeDropdown);
        gpuTypeSelect.click();
        gpuTypeSelect.findElement(By.xpath("//md-option[contains(text(), 'NVIDIA Tesla V100')]")).click();
        
        driver.findElement(numberOfGPUsField).sendKeys("1");

        
        driver.findElement(localSSDField).click();

        
        WebElement locationSelect = driver.findElement(datacenterLocationDropdown);
        locationSelect.click();
        locationSelect.findElement(By.xpath("//md-option[contains(text(), 'Frankfurt (europe-west3)')]")).click();

        
        WebElement usageSelect = driver.findElement(committedUsageDropdown);
        usageSelect.click();
        usageSelect.findElement(By.xpath("//md-option[contains(text(), '1 Year')]")).click();
        
        
        driver.findElement(addToEstimateButton).click();
    }

    public String getEstimatedCost() {
        return driver.findElement(By.xpath("//h2[contains(text(), 'Total Estimated Cost: USD')]")).getText();
    }

    public void shareEstimate() {
        WebElement shareButton = driver.findElement(By.xpath("//button[contains(text(), 'Share')]"));
        shareButton.click();
        
       
       WebElement openSummaryButton = driver.findElement(By.xpath("//button[contains(text(), 'Open estimate summary')]"));
       openSummaryButton.click(); 
   }
}
