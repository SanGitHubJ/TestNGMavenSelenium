package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Sanath on 5/20/2018.
 */
public class LogingPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LogingPageTest(){

        super(); //caling to supper class construction ie TestBase to call prop
    }
    @BeforeTest
    public void setUp(){

        initialization();  // call to initialization  method in TestBase class
        loginPage = new LoginPage(); //call to LogingPage class
    }


    @Test(priority = 1)
    public void logingPageTitleTest(){

        String title = loginPage.validateLoginPageTitle();
        //System.out.print(title);
        Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service");
    }

      @Test(priority = 2)
    public void crmLogoImgageTest(){

       Boolean crmImg =  loginPage.validateCRMImage();
        Assert.assertTrue(crmImg);
    }

    @Test(priority = 3)
    public void loginTest(){

        try {
            homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown(){

        driver.quit();
    }


}
