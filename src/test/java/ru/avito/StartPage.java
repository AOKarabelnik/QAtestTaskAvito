package ru.avito;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    public WebDriver driver;
    public StartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(linkText = "Вход и регистрация")
    private WebElement loginHeader;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwdField;

    @FindBy(name = "submit")
    private WebElement loginBtn;

    public void clickLoginHeader(){
        this.loginHeader.click();
    }

    public void inputLogin(String login){
        this.loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd){
        this.passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn(){
        this.loginBtn.click();
    }
}


