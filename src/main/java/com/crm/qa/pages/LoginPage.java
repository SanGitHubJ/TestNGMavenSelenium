package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sanath on 5/20/2018.
 */
public class LoginPage extends TestBase {

    //page factory OR Object Repo

    @FindBy(css="div[class=\"input-group\"]>input[name=\"username\"]")
    WebElement txtUserName;

    @FindBy(css = "div[class=\"input-group\"]>input[name=\"password\"]")
    WebElement txtPassword;

    @FindBy(xpath = "/html//form[@id='loginForm']//input[@value='Login']")
    WebElement btnloginbtn;

    @FindBy(xpath = "//button[contains(text(),'Sign Up')]")
    WebElement lnkSingUp;

    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement imgCRM;


    //constructure to inizialioze ALL objects above
    public LoginPage(){

        PageFactory.initElements(driver,this); // here this mean current class ie LoginPage objects

    }

        //Actions
    public String validateLoginPageTitle(){

        String ph = driver.getTitle();
        System.out.print(ph);
        return  ph;
    }

    public boolean validateCRMImage(){
        return imgCRM.isDisplayed();
    }

    public HomePage login(String un, String pw) throws InterruptedException {

        txtUserName.sendKeys(un);
        txtPassword.sendKeys(pw);
        Thread.sleep(3000);
        btnloginbtn.click();

        return new HomePage();

    }

}
