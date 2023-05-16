package com.demo.pages;


import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Js_Multiple {

    public Js_Multiple(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="dropdown")
    public WebElement dropdown;


}
