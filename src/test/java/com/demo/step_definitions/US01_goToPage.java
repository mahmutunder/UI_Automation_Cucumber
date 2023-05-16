package com.demo.step_definitions;

import com.demo.pages.ShiftingContent;
import com.demo.pages.TheInternetBase;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.Dimension;

public class US01_goToPage extends TheInternetBase {

    ShiftingContent shiftingContent= new ShiftingContent();
    @Given("User go to inter name page")
    public void user_go_to_inter_name_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl"));

        BrowserUtils.waitFor(5);
        link("Shifting Content").click();
        BrowserUtils.waitFor(3);
        Driver.getDriver().manage().window().setSize(new Dimension(375,812));
       shiftingContent.sLink("Example 2: An image").click();
        BrowserUtils.waitFor(3);

    }

    @Given("User get the title")
    public void user_get_the_title() {

        String title = Driver.getDriver().getTitle();

        Assert.assertTrue(title.contains("The"));
    }
}
