package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Sanath on 5/20/2018.
 */
public class ContactPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactPage;

    public ContactPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtil.switchToFrame();
       contactPage =  homePage.clickHomePageContactslink();

    }

    @Test(priority = 1)
    public void verifyContactLableTest(){

        Assert.assertTrue(contactPage.verifyContactLabel(),"Contact page is NOT found");

    }

    @Test(priority = 2)
    public void verifSingleyContactLable(){

        contactPage.selectContactLable("tak uat");

    }

    @Test(priority = 3)
    public void verifyMultipleContactLable(){

        contactPage.selectContactLable("tak uat");
        contactPage.selectContactLable("jan kai");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
