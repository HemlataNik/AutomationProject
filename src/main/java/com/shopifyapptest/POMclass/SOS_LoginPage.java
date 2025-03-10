package com.shopifyapptest.POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SOS_LoginPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@id=\"account_email\"]")
    private WebElement username;

    @FindBy (xpath = "//input[@name=\"account[password]\"]")
    private  WebElement password;

    @FindBy (xpath = "//button[@type=\"submit\"]")
    private  WebElement Submit_btn;

    public SOS_LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }


    public void sendUsername(String usernameData)
    {
        username.sendKeys(usernameData);
    }

    public void sendPassword(String pwdData)
    {
        password.sendKeys(pwdData);
    }


    public void loginClick()
    {
        Submit_btn.click();
    }

}
