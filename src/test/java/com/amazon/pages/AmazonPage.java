package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {


public AmazonPage(){
    PageFactory.initElements(Driver.getDriver(), this);
}

    @FindBy(id = "nav-logo-sprites")
    public WebElement amazonLogo;

    @FindBy(id = "sp-cc-accept")
    public WebElement cookies;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement toLoginPage;

    @FindBy(id = "ap_email")
    public WebElement emailBox;

    @FindBy(id = "ap_password")
    public WebElement passwordBox;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement accountList;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//span[.='SONUÇLAR']")
    public WebElement result;

    @FindBy(xpath = "//a[.='2']")
    public WebElement secondPage;

    @FindBy(xpath = "(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[2]")
    public WebElement secondProduct;

    @FindBy(id = "add-to-wishlist-button-submit")
    public WebElement addToList;

    @FindBy(xpath = "//span[.='1 ürün şuraya eklendi:']")
    public WebElement addedMessage;

    @FindBy(xpath = "//*[text()='Favori']/..")
    public WebElement favoriteListButton;

    @FindBy(css = ".a-button-close.a-declarative")
    public WebElement closeButton;

    @FindBy(id = "my-lists-tab")
    public WebElement favoriteList;

    @FindBy(xpath = "(//input[@name='submit.deleteItem'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[.='Silindi']")
    public WebElement deleteMessage;

    @FindBy(id = "nav-item-signout")
    public WebElement logoutButton;




}


