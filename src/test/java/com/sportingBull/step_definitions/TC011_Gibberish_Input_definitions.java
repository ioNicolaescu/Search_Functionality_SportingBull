package com.sportingBull.step_definitions;

import com.sportingBull.pages.Search_Page;
import com.sportingBull.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TC011_Gibberish_Input_definitions {
    Search_Page searchPage = new Search_Page();

    @Then("User should see a {string} message displayed")
    public void user_should_see_a_message_displayed(String expectedMessage) {
        BrowserUtils.sleep(2);
        String actualMessage = searchPage.getNoResultMessage().getText().replaceAll("\\s+", " ").trim();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
