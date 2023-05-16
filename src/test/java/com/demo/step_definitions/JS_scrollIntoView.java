package com.demo.step_definitions;


import com.demo.pages.Js_largeDom;
import com.demo.pages.TheInternetBase;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class JS_scrollIntoView extends TheInternetBase {

    Js_largeDom js_largeDom= new Js_largeDom();

    @Given("User already in the {string} page")
    public void user_already_in_the_page(String string) throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/");
        BrowserUtils.waitFor(10);
        link(string).click();

    }
    @Then("User scroll down to view")
    public void user_scroll_down_to_view() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String intoView="arguments[0].scrollIntoView()";
        System.out.println("hello");
        js.executeScript(intoView,js_largeDom.tableDown);
        BrowserUtils.waitFor(5);


    }
}
