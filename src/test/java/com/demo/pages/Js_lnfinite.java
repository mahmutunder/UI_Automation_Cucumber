package com.demo.pages;


import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Js_lnfinite {

    public Js_lnfinite(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className="jscroll-added")
    public List<WebElement> tableDown;


}
