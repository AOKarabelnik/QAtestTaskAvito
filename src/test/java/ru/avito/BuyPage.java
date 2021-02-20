package ru.avito;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyPage {

    public WebDriver driver;
    public BuyPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".item-buyer-button-1-zak")
    private WebElement buyBtn;

    @FindBy(name = "phone")
    private WebElement phoneNumberField;

    public void clickBuyBtn(){
        this.buyBtn.click();
    }

    public void checkPhoneNumberField(){
        assert this.phoneNumberField.equals("");
    }
}
