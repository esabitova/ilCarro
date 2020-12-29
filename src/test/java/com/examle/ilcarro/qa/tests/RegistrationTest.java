package com.examle.ilcarro.qa.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
       @Test
    public void testRegistration() throws InterruptedException {
        app.getUserHelper().openRegForm();
        String email =  "my.email" + System.currentTimeMillis() + "@gmail.com";
        app.getUserHelper().fillRegistrationForm("Elena", "Ro", email, "Aa1234567");
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButton();
        app.getUserHelper().pause(3000);

        Assert.assertFalse(app.getUserHelper().isRegistrationFormPresent());
    }

    @Test
    public void testRegistration2() throws InterruptedException {
        app.getUserHelper().openRegForm();
        String email =  "myEmail" + System.currentTimeMillis() + "@yahoo.com";
        app.getUserHelper().fillRegistrationForm("Elena-Maria", "RoChmaninov", email, "Aa12345677297979789");
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButton();
        app.getUserHelper().pause(3000);

        Assert.assertFalse(app.getUserHelper().isRegistrationFormPresent());
    }

    @Test
    public void testRegistrationNegative() throws InterruptedException {
        app.getUserHelper().openRegForm();
        String email =  "my.email" + System.currentTimeMillis();
        app.getUserHelper().fillRegistrationForm("Elena", "Ro", email, "Aa1234567");
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButton();
        app.getUserHelper().pause(3000);

        Assert.assertTrue(app.getUserHelper().isRegistrationFormPresent());

    }

}


