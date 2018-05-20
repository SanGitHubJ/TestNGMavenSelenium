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
public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactPage;

    public HomePageTest(){
        super();
    }

        @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
       homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

    }

    @Test(priority = 1)
    public void homePageTitleTest(){

        String homeTitle = homePage.validateHomePageTitle();
        Assert.assertEquals(homeTitle,"CRMPRO","Home page title is NOT present");
    }

        @Test(priority = 2)
        public void verifyCorrectUserName(){
            testUtil.switchToFrame();

            //boolean userName = homePage.validateHomeUserName();
            Assert.assertTrue(homePage.validateHomeUserName());
        }

        @Test(priority = 3)
        public void verifyHomePageContactLink(){
            testUtil.switchToFrame();
            contactPage = homePage.clickHomePageContactslink();
        }


    @AfterMethod
    public void tearDown(){

        //driver.close();
       driver.quit();
    }
}
