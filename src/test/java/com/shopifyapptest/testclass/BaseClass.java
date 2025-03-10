package com.shopifyapptest.testclass;

import com.shopifyapptest.POMclass.SOS_LoginPage;
import com.shopifyapptest.utility.utility;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    SOS_LoginPage login;

    @BeforeClass
    @Parameters("browser")
    public void LaunchBrowser() {
        driver = new ChromeDriver();
        driver.get("https://admin.shopify.com/store/wordsnwonders");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void loginPageTest() throws IOException, InterruptedException {
        login = new SOS_LoginPage(driver);
        String usernameData = utility.getCellData(1, 0);
        String pwdData = utility.getCellData(1, 1);
        login.sendUsername(usernameData);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[@class=\"ui-button__text\"]")).click();
        Thread.sleep(4000);
        login.sendPassword(pwdData);
        Thread.sleep(4000);
        login.loginClick();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus())
        {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File("E:\\Screenshots\\"+result.getName()+".png"));
        }
    }

    @AfterClass
        public void CloseBrowser () {
            //Thread.sleep(3000);
            driver.quit();
        }
}