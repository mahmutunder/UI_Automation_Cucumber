package com.demo.pages;


import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class TheInternetBase {

    public TheInternetBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//ul//a")
    public List<WebElement> links;

    public WebElement link(String link){

        for (WebElement element : links) {

            if (element.getText().equals(link)){
                return element;
            }
        }
        return null;
    }
}
