package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sanath on 5/20/2018.
 */
public class HomePage extends TestBase {


    @FindBy(xpath = "//td[contains(text(),'User: test test')]")
    WebElement lblUserName;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement lnkContacts;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement lnkDeals;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement lnkTasks;

    public HomePage(){

        PageFactory.initElements(driver,this);
    }

    public String validateHomePageTitle(){

        return driver.getTitle();
    }

    public boolean validateHomeUserName(){
        return lblUserName.isDisplayed();

    }
    public ContactsPage clickHomePageContactslink(){

        lnkContacts.click();
        return new ContactsPage();
    }
    public DealsPage clickHomePageDealsLinks(){
        lnkDeals.click();
        return new DealsPage();
    }
    public TasksPage clickHomePageTasksLinks(){

        lnkTasks.click();
        return new TasksPage();
    }


}
