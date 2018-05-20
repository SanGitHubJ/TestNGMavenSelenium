package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sanath on 5/20/2018.
 */
public class TestBase {

   public static WebDriver driver;
   public static Properties prop;

    //construction is same as the class name
    public TestBase(){

        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("E:\\Sanath\\SelleniumNew\\MyProjects\\src\\main\\"
                    +"java\\com\\crm\\qa\\config/config.properties");
            prop.load(ip);
        }
        catch(FileNotFoundException e) {
                e.printStackTrace();
    }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void initialization(){

        String browserName = prop.getProperty("browser");

       if(browserName.equals("chrome")) {

            String driverlocation="E:\\Sanath\\SelleniumNew\\projects\\drivers\\chromedriver(1).exe";
            File driverPath= new File(driverlocation);
            System.setProperty("webdriver.chrome.driver",driverPath.toString());
            //System.setProperty("webdriver.chrome.driver","E:\\Sanath\\SelleniumNew\\MyProjects\\src\\main\\java\\com\\crm\\qa\\config\\chromedriver.exe");
           driver = new ChromeDriver();
        }else
            if(browserName.equals("FireFox")) {

            String driverlocation = "E:\\Sanath\\SelleniumNew\\projects\\drivers\\geckodriver.exe";
            File driverPath = new File(driverlocation);
            System.setProperty("webdriver.gecko.driver", driverPath.toString());
            driver = new FirefoxDriver();
        }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));
        }


}
