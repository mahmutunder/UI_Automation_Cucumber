package com.demo.step_definitions;


import com.demo.pages.Js_lnfinite;
import com.demo.pages.TheInternetBase;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class JS_scrollToView extends TheInternetBase {

    Js_lnfinite js_lnfinite= new Js_lnfinite();

    @Given("User already in the to {string} page")
    public void user_already_in_the_page(String string) throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/");
        BrowserUtils.waitFor(10);
        link(string).click();

    }
    @Then("User scroll  to down to view")
    public void user_scroll_down_to_view() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String intoView="window.scrollTo(0,document.body.scrollHeight)";
        System.out.println("hello");

        while (js_lnfinite.tableDown.size()<5){
            js.executeScript(intoView);
            BrowserUtils.waitFor(1);
        }

        BrowserUtils.waitFor(5);


    }
}
