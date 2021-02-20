package ru.avito;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransitionPage {

    public WebDriver driver;

    public TransitionPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//option[text()='Личные вещи']")
    private WebElement personalBelongings;

    @FindBy(xpath = "//input[contains(@data-marker, \"delivery-filter/input\")]")
    private WebElement withDelivery;

    @FindBy(xpath = "//div[2]/button")
    private WebElement showAdsBtn;

    @FindBy(css = "[data-marker='catalog-serp'] > [data-marker='item']:nth-child(2) > div > div > div > a")
    private WebElement item;


    public void clickPersonalBelongings(){
        this.personalBelongings.click();
    }

    public void checkWithDelivery(){
        this.withDelivery.sendKeys(Keys.SPACE);
    }

    public void clickShowAdsBtn(){
        this.showAdsBtn.click();
    }

    public void selectItem(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('target','_self')", item);
        this.item.click();
    }


}
