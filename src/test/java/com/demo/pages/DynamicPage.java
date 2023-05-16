package com.demo.pages;


import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DynamicPage {

    public DynamicPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#start button")
    public WebElement start;

    @FindBy(css = "#loading")
    public WebElement loading;

    @FindBy(css = "#finish h4")
    public WebElement hello;

    @FindBy(css = "#content a")
    public List<WebElement> elements;

    public WebElement dynamicLink(String link){

        for (WebElement element : elements) {
            if (element.getText().equals(link)){
                return element;
            }
        }
        return null;
    }


}
