package com.demo.step_definitions;


import com.demo.pages.ProgressBarPage;
import com.demo.pages.TheInternetBase;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarSteps extends TheInternetBase {

    ProgressBarPage progressBar = new ProgressBarPage();
    WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("Navigate to {string} page")
    public void navigate_to_page(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl"));
        link(string).click();

    }

    @When("click startStopButton")
    public void click_start_stop_button() {

        progressBar.startStopButton.click();
    }

    @When("progress bar continue until value is {string}")
    public void progress_bar_continue_until_value_is(String value) {

        wait.pollingEvery(Duration.ofMillis(30));
        wait.until(ExpectedConditions.attributeToBe(progressBar.progressBar,"aria-valuenow",value));

    }

    @When("progressbar value is {string}")
    public void progressbarValueIs(String resetValue) {

    }
    @Then("verify button name is Reset")
    public void verifyButtonNameIsReset() {

       String pro= progressBar.progressBar.getAttribute("aria-valuenow");
        System.out.println(pro);
    }
}
