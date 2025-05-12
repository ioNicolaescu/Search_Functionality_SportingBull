package com.sportingBull.step_definitions;

import com.sportingBull.pages.Home_Page;
import com.sportingBull.pages.Search_Page;
import com.sportingBull.utilities.ConfigurationReader;
import com.sportingBull.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TC001_ValidQuery_definitions {
    Home_Page homePage = new Home_Page();
    Search_Page searchPage = new Search_Page();

    @Given("User is on the SportingBull homepage")
    public void user_is_on_the_sporting_bull_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        homePage.getAcceptAllCookies().click();
    }
    @When("User press the search icon")
    public void user_press_the_search_icon() {
        homePage.getSearchButton().click();
    }
    @And("User enters {string} in the search bar")
    public void user_enters_in_the_search_bar(String query) {
        searchPage.getSearchBox().sendKeys(query);
    }
    @Then("search results related to {string} should be displayed")
    public void search_results_related_to_should_be_displayed(String query) {
        boolean resultFound = false;
        for (WebElement each : searchPage.getDisplayedResult()) {
            if (each.getText().contains(query)) {
                resultFound = true;
            }
        }
        Assert.assertTrue("Inserted query is found in search results", resultFound);
    }
}
