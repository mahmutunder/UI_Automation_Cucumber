package com.demo.pages;


import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShiftingContent {

    public ShiftingContent(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//div[@id='content']//a")
    public  List<WebElement> shiftingLink;

    public  WebElement sLink(String link){

        for (WebElement eachLink : shiftingLink) {

            if (eachLink.getText().equals(link)){
                System.out.println(eachLink.getText());
                return eachLink;
            }
        }
        return null;
    }

}
