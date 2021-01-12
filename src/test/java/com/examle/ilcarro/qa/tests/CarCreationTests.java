package com.examle.ilcarro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarCreationTests extends TestBase{
    @Test(enabled = true)
    public void testCarCreation(){
        System.out.println("started testCarCreation");
        app.getCarHelper().initAddingNewCar();
        Assert.assertTrue(app.getCarHelper().isCarCreationFormPresent());

        app.getCarHelper().fillCarForm("TelAviv");
        app.getCarHelper().clickYallaButton();

    }
}
