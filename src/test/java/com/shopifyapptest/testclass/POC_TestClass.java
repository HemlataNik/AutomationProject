package com.shopifyapptest.testclass;

import com.shopifyapptest.utility.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class POC_TestClass extends BaseClass{

    @Test
    public void Verify_Pumper_Offer_Creation() throws InterruptedException, IOException {
        System.out.println("Verify Pumper Offer Creation");
        WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(6));
        w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Pumper Bundles Quantity Breaks')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Pumper Bundles Quantity Breaks')]")).click();

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@name=\"app-iframe\"]"));
        driver.switchTo().frame(iframe1);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement create_off = driver.findElement(By.xpath("//span[text()=\"Create new offer\"]"));
        js.executeScript("arguments[0].scrollIntoView();", create_off);
        create_off.click();

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,550)", "");
        WebElement create_quantitybreak = driver.findElement(By.xpath("//span[text()=\"Create a Quantity Break\"]"));
        create_quantitybreak.click();
        Thread.sleep(3000);

        WebElement offerName_value = driver.findElement(By.id("offerName"));
        offerName_value.sendKeys(Keys.CONTROL,"a");
        offerName_value.sendKeys(Keys.DELETE);
        offerName_value.sendKeys("Offer 3",Keys.ENTER);

        JavascriptExecutor js4 = ((JavascriptExecutor) driver);
        WebElement delet_off = driver.findElement(By.xpath("//span[text()=\"Delete\"]"));
        js4.executeScript("arguments[0].scrollIntoView();", delet_off);
        delet_off.click();
        delet_off.click();

        JavascriptExecutor js3 = ((JavascriptExecutor) driver);
        WebElement add_off = driver.findElement(By.xpath("//p[@class=\"addBtn-text\"]"));
        js3.executeScript("arguments[0].scrollIntoView();", add_off);

        WebElement off1 = driver.findElement(By.xpath("//div[@data-rbd-draggable-id=\"draggable-0\"]"));
        off1.click();
        WebElement discountType = driver.findElement(By.cssSelector("select#price0.Polaris-Select__Input"));
        Select s = new Select(discountType);
        s.selectByValue("percentage");
        WebElement discBox = driver.findElement(By.cssSelector("input#discount0.Polaris-TextField__Input"));
        discBox.sendKeys(Keys.CONTROL,"a");
        discBox.sendKeys(Keys.DELETE);
        discBox.sendKeys("35",Keys.ENTER);
        WebElement quantBox = driver.findElement(By.cssSelector("input#quantity0.Polaris-TextField__Input"));
        quantBox.sendKeys(Keys.CONTROL,"a");
        quantBox.sendKeys(Keys.DELETE);
        quantBox.sendKeys("1",Keys.ENTER);
        WebElement offerTitleBox = driver.findElement(By.cssSelector("input#title0.Polaris-TextField__Input"));
        offerTitleBox.sendKeys(Keys.CONTROL,"a");
        offerTitleBox.sendKeys(Keys.DELETE);
        offerTitleBox.sendKeys("35% OFF",Keys.ENTER);
        WebElement discLabelBox = driver.findElement(By.cssSelector("input#subtitle0.Polaris-TextField__Input"));
        discLabelBox.sendKeys(Keys.CONTROL,"a");
        discLabelBox.sendKeys(Keys.DELETE);
        discLabelBox.sendKeys("Special offer",Keys.ENTER);

        JavascriptExecutor js6 = ((JavascriptExecutor) driver);
        WebElement showTotalPrizeCkBox = driver.findElement(By.xpath("//input[@id=\"showTotalPrice\"]"));
        js6.executeScript("arguments[0].scrollIntoView();", showTotalPrizeCkBox);
        showTotalPrizeCkBox.click();

        JavascriptExecutor js7 = ((JavascriptExecutor) driver);
        WebElement publishBox = driver.findElement(By.xpath("//button[@class=\"Polaris-Button Polaris-Button--pressable Polaris-Button--variantPrimary Polaris-Button--sizeMedium Polaris-Button--textAlignCenter\"]"));
        js7.executeScript("arguments[0].scrollIntoView();", publishBox);
        publishBox.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://wordsnwonders.myshopify.com/products/bookstore\"]")));

        driver.findElement(By.xpath("//a[@href=\"https://wordsnwonders.myshopify.com/products/bookstore\"]")).click();
        Set w = driver.getWindowHandles();

        Iterator<String> t = w.iterator();
        String pw = t.next();
        String ch = t.next();

        driver.switchTo().window(ch);
        WebElement passwordStore = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        String pwdData = utility.getCellData(1, 2);
        passwordStore.sendKeys(pwdData);

        WebElement submitButton = driver.findElement(By.xpath("//button[text()=\"Enter\"]"));
        submitButton.click();

        JavascriptExecutor js9 = (JavascriptExecutor) driver;
        js9.executeScript("window.scrollBy(0,900)", "");

        WebElement productShow = driver.findElement(By.xpath("//li[@id=\"Slide-template--18927208300770__featured_collection-2\"]"));
        productShow.click();

        WebElement product1 = driver.findElement(By.xpath("//div[@class=\"product__title\"]//h1"));
        String prodTitle = product1.getText();
        System.out.println(prodTitle);

        WebElement regularPrize = driver.findElement(By.xpath("//div[@class=\"price__regular\"]//span[@class=\"price-item price-item--regular\"]"));
        String regularPrizeTexT = regularPrize.getText();
        System.out.println(regularPrizeTexT);

        WebElement offTitle = driver.findElement(By.xpath("//div[@class=\"template_4_block__cbmain--content--left__top\"]//h5"));
        String getOfferTitle = offTitle.getText();
        System.out.println(getOfferTitle);

        WebElement discountLabel = driver.findElement(By.xpath("//div[@class=\"template_4_block__cbmain--content--left__top\"]//h4"));
        String getDiscountLabel = discountLabel.getText();
        System.out.println(getDiscountLabel);

        WebElement totalAmount = driver.findElement(By.xpath("//div[@class=\"prvw_totalAmount_wrapper\"]//h4[@class=\"prvw_totalAmount_price_0\"]"));
        String getTotalAmt = totalAmount.getText();
        System.out.println(getTotalAmt);


    }
}
