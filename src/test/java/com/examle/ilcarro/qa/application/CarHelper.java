package com.examle.ilcarro.qa.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void initAddingNewCar(){
        click(By.cssSelector("header [href='/car']"));
        }

    public boolean isCarCreationFormPresent() {
        return isElementPresent(By.xpath("//h3[contains(., 'Let the car work')]"));
    }

    public void fillCarForm(String location){
        type(By.name("country"), location);
    }
}
