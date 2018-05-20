package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sanath on 5/20/2018.
 */
public class ContactsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement lblContacts;


//    @FindBy(xpath = "//a[contains(text(),'tak uat')]/parent::td//preceding-sibling::td//input[@name='contact_id']")
//    WebElement ckBox;

    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyContactLabel(){

        return lblContacts.isDisplayed();
    }

    public void selectContactLable(String name){
        driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"
                +"/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();

    }
}
