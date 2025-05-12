package com.sportingBull.step_definitions;

import com.sportingBull.pages.Search_Page;
import com.sportingBull.utilities.BrowserUtils;
import com.sportingBull.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TC023_Close_Button_definitions {
    Search_Page searchPage = new Search_Page();

    @When("User Press the Close button")
    public void user_press_the_close_button() {
        BrowserUtils.sleep(2);
        searchPage.getCloseButton().click();
    }
    @Then("The search bar should no longer be visible")
    public void the_search_bar_should_no_longer_be_visible() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(searchPage.getSearchBox()));
        Assert.assertTrue(isInvisible);
    }

}
