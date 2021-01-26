package com.examle.ilcarro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarCreationTests extends TestBase{

    @Test(enabled = true)
    public void testCarCreation() throws InterruptedException {
        if(!app.getUserHelper().isUserLoggedIn()){
            app.getUserHelper().logIn(app.setEmail(), app.setPassword());
        }
        System.out.println("started testCarCreation");
        app.getCarHelper().initAddingNewCar();
        Assert.assertTrue(app.getCarHelper().isCarCreationFormPresent());

        app.getCarHelper().fillCarForm("TelAviv");
        app.getCarHelper().clickYallaButton();

    }

    @Test(enabled = true)
    public void testCarCreationUserLoggedOut() throws InterruptedException {

        if(app.getUserHelper().isUserLoggedIn()){
            app.getUserHelper().logout();
        }
        System.out.println("started testCarCreation");
        app.getCarHelper().initAddingNewCar();
        Assert.assertTrue(app.getCarHelper().isCarCreationFormPresent());

        app.getCarHelper().fillCarForm("TelAviv");
        app.getCarHelper().clickYallaButton();


        app.getUserHelper().logIn(app.setEmail(), app.setPassword());
    }
}
