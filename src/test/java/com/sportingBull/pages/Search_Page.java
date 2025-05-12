package com.sportingBull.pages;

import com.sportingBull.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Search_Page {
    public Search_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBox;
    @FindBy(xpath = "//span[.='Close']")
    private WebElement closeButton;
    @FindBy(xpath = "//div[@class='search-dropdown__item']")
    private List<WebElement> displayedResult;
    @FindBy(xpath = "//*[contains(text(), ' There are no results that match')]")
    private WebElement noResultMessage;

    public WebElement getSearchBox() {
        return searchBox;
    }
    public WebElement getCloseButton() {
        return closeButton;
    }
    public List<WebElement> getDisplayedResult() {
        return displayedResult;
    }
    public WebElement getNoResultMessage() {
        return noResultMessage;
    }

}
