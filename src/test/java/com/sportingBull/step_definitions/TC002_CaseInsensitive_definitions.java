package com.sportingBull.step_definitions;

import com.sportingBull.pages.Home_Page;
import com.sportingBull.pages.Search_Page;
import com.sportingBull.utilities.BrowserUtils;
import com.sportingBull.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TC002_CaseInsensitive_definitions {
    Search_Page searchPage = new Search_Page();
    Home_Page homePage = new Home_Page();
    private List<String> displayedResult = new ArrayList<>();

   @When("User enters in the search bar the following")
    public void user_enters_in_the_search_bar_the_following(List<String> queryInput) {

        for (String each : queryInput) {
            searchPage.getSearchBox().sendKeys(each);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElements(searchPage.getDisplayedResult()));


            if(!searchPage.getDisplayedResult().isEmpty()){
                displayedResult.add(searchPage.getDisplayedResult().get(0).getText());
            }else{
                System.out.println("No results found for query: " + each);
            }

            searchPage.getSearchBox().clear();
            BrowserUtils.sleep(1);
            searchPage.getCloseButton().click();
            BrowserUtils.sleep(1);
            homePage.getSearchButton().click();
        }
    }


    @Then("Search result should be the same")
    public void search_result_should_be_the_same() {
       if(displayedResult.isEmpty()){
           throw new AssertionError("No results found");
       }
        String firstResult = displayedResult.get(0);

        for (String each : displayedResult) {
            Assert.assertEquals(firstResult,each);
        }
    }
}
