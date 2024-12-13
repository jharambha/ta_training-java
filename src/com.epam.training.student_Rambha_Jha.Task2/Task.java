package com.epam.training.student_Rambha_Jha.Task2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    private WebDriver driver;
    private PastebinPage pastebinPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        pastebinPage = new PastebinPage(driver);
    }

    @Test
    public void testCreateNewPaste() {
        pastebinPage.open();

        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                      "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                      "git push origin master --force";
        String syntax = "Bash";
        String expiration = "10 Minutes";
        String title = "how to gain dominance among developers";

        pastebinPage.createNewPaste(code, syntax, expiration, title);

        Assert.assertEquals(title, pastebinPage.getPageTitle());
        Assert.assertTrue(pastebinPage.isSyntaxHighlighted(syntax));
        Assert.assertEquals(code, pastebinPage.getCode());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
