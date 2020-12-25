package com.examle.ilcarro.qa;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
       @Test
    public void testRegistration() throws InterruptedException {
        openRegForm();
        String email =  "my.email" + System.currentTimeMillis() + "@gmail.com";
        fillRegistrationForm("Elena", "Ro", email, "Aa1234567");
        selectCheckBox();
        pause(2000);
        clickYallaButton();
        pause(3000);

        Assert.assertFalse(isRegistrationFormPresent());
    }

    @Test
    public void testRegistration2() throws InterruptedException {
        openRegForm();
        String email =  "myEmail" + System.currentTimeMillis() + "@yahoo.com";
        fillRegistrationForm("Elena-Maria", "RoChmaninov", email, "Aa12345677297979789");
        selectCheckBox();
        pause(2000);
        clickYallaButton();
        pause(3000);

        Assert.assertFalse(isRegistrationFormPresent());
    }

    @Test
    public void testRegistrationNegative() throws InterruptedException {
        openRegForm();
        String email =  "my.email" + System.currentTimeMillis();
        fillRegistrationForm("Elena", "Ro", email, "Aa1234567");
        selectCheckBox();
        pause(2000);
        clickYallaButton();
        pause(3000);

        Assert.assertTrue(isRegistrationFormPresent());
    }

}


