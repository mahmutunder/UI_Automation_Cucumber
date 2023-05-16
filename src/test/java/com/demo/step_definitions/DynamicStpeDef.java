package com.demo.step_definitions;


import com.demo.pages.DynamicPage;
import com.demo.pages.TheInternetBase;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicStpeDef extends TheInternetBase {

    DynamicPage dynamicPage= new DynamicPage();
    @Given("User is on the The internet page")
    public void user_is_on_the_the_internet_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl"));
        BrowserUtils.waitFor(3);
    }
    @Given("User click {string}")
    public void user_click(String string) {

        link(string).click();
        BrowserUtils.waitFor(3);
    }
    @Then("User go to Dynamic page {string}")
    public void user_go_to_dynamic_page(String link) {

        dynamicPage.dynamicLink(link).click();
        BrowserUtils.waitFor(3);
    }
    @Then("User click start button")
    public void user_click_start_button() {

        dynamicPage.start.click();
       // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //wait.until(ExpectedConditions.invisibilityOf(dynamicPage.loading));

        FluentWait wait= new FluentWait(Driver.getDriver());


        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(dynamicPage.loading));

    }
    @Then("User wait until page load to see {string}")
    public void user_wait_until_page_load_to_see(String string) {

        String text = dynamicPage.hello.getText();

        System.out.println(text);

        Assert.assertEquals("Hello World!",text);
    }
}
