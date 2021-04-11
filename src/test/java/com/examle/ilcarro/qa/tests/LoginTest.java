package com.examle.ilcarro.qa.tests;

import com.examle.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validLogin(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{"my.email1608881337043@gmail.com", "Aa1234567"});
        list.add(new Object[]{"my.email1608821574952@gmail.com", "iL12345678"});
        list.add(new Object[]{"my.email1608815551767@gmail.com", "iL12345678"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validLoginFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/validLoginCsv.csv")));

        String line = reader.readLine();
        while(line != null){
            String[] split =line.split(";");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});

            line = reader.readLine();
        }
     return list.iterator();
    }

    @Test(enabled = false, dataProvider = "validLoginFromCsv")
    public void testLoginDataProviderCsv(User user) throws InterruptedException {
        logger.info("\nuser name is " + user.getEmail() + "\n user password is " + user.getPassword());
        app.getUserHelper().clickLogInButton();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButton();

        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());

        logger.info("Test Passed");

        String screenshot = "src/test/screenshots/screenshot-" +System.currentTimeMillis()+ ".png";
        app.getUserHelper().takeScreenshot(screenshot);

        logger.info("Created screenshot "+ screenshot);

    }


    @Test(enabled = false, dataProvider = "validLogin")
    public void testLoginDataProvider(String email, String password) throws InterruptedException {
        logger.info("\nuser name is" + email + "\nuser password is " + password);
        app.getUserHelper().clickLogInButton();
        app.getUserHelper().fillLoginForm(new User()
                .withEmail(email)
                .withPassword(password));
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButton();

        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());

        logger.info("Test Passed");

        String screenshot = "src/test/screenshots/screenshot-" +System.currentTimeMillis()+ ".png";
        app.getUserHelper().takeScreenshot(screenshot);

        logger.info("Created screenshot "+ screenshot);

    }

@Test
    public void testLoginSanity() throws InterruptedException {
        logger.info("\nuser name is my.email1608881337043@gmail.com \n user password is Aa1234567");
        app.getUserHelper().clickLogInButton();
        app.getUserHelper().fillLoginForm(new User()
                .withEmail("my.email1608881337043@gmail.com")
                .withPassword("Aa1234567"));
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButton();

        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());

        logger.info("Test Passed");

        String screenshot = "src/test/screenshots/screenshot-" +System.currentTimeMillis()+ ".png";
        app.getUserHelper().takeScreenshot(screenshot);

        logger.info("Created screenshot "+ screenshot);

    }

    @BeforeMethod
    public void ensurePreconditions() {
        /*if user logged in, logout*/
        if (app.getUserHelper().isUserLoggedIn()) {
            app.getUserHelper().clickLogoutButtonOnHeader();
        }
    }


}
