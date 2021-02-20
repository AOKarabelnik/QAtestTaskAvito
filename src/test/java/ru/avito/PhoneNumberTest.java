package ru.avito;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PhoneNumberTest {
    public static StartPage startPage;
    public static TransitionPage transitionPage;
    public static BuyPage buyPage;
    public static  WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        startPage = new StartPage(driver);
        transitionPage = new TransitionPage(driver);
        buyPage = new BuyPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("startpage"));
    }

    @Test
    public void loginTest(){
        startPage.clickLoginHeader();
        startPage.inputLogin(ConfProperties.getProperty("login"));
        startPage.inputPasswd(ConfProperties.getProperty("password"));
        startPage.clickLoginBtn();

//        Timeout.seconds(60);  //for skip captcha
        transitionPage.clickPersonalBelongings();
        transitionPage.checkWithDelivery();
        transitionPage.clickShowAdsBtn();
        transitionPage.selectItem();

        buyPage.clickBuyBtn();
        buyPage.checkPhoneNumberField();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
