package com.demo.step_definitions;


import com.demo.pages.Js_Multiple;
import com.demo.pages.TheInternetBase;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class JS_multipleDrop extends TheInternetBase {

    Js_Multiple jsMultiple= new Js_Multiple();

    @Given("User already in the to  {string} page")
    public void user_already_in_the_to_page(String string) throws AWTException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/");
        BrowserUtils.waitFor(5);
        link(string).click();



        Cookie cookie= new Cookie.Builder("mah","yes")
                .domain("the-internet.herokuapp.com")
                .build();
        Driver.getDriver().manage().addCookie(cookie);

        Set<Cookie> cookies = Driver.getDriver().manage().getCookies();
        for (Cookie cookie1 : cookies) {
            System.out.println(cookie1.getName());
        }

        BrowserUtils.waitFor(3);


    }
    Select select;
    @Given("User send JS tto change multiple option")
    public void user_send_js_tto_change_multiple_option() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("document.getElementById('dropdown').setAttribute(\"multiple\",\"\")");
        select= new Select(jsMultiple.dropdown);
        BrowserUtils.waitFor(2);
        select.selectByValue("1");
        BrowserUtils.waitFor(2);
        select.selectByValue("2");
        BrowserUtils.waitFor(1);
    }
    @Then("User see more option to chose")
    public void user_see_more_option_to_chose() {
        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }


}
