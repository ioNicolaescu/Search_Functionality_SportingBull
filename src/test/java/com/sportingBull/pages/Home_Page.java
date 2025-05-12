package com.sportingBull.pages;

import com.sportingBull.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
    public Home_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Accept all cookies']")
    private WebElement acceptAllCookies;
    @FindBy(xpath = "//div[@class='search-button search-button--sport']")
    private WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }
    public WebElement getAcceptAllCookies() {
        return acceptAllCookies;
    }
}
