package com.shopifyapptest.POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SOS_LogoutPage {
  WebDriver driver;
    @FindBy(xpath = "//p[text()=\"WordsNWonders\"]")
    private WebElement wordsnwondersButton;

    @FindBy (xpath = "//span[text()=\"Log out\"]")
    private  WebElement LogoutButton;

    public SOS_LogoutPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void wordswondersButton()
    {
        wordsnwondersButton.click();

    }

}