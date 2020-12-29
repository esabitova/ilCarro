package com.examle.ilcarro.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
        WebDriver wd;
        UserHelper userHelper;


    public void start() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       userHelper = new UserHelper(wd);
   }

    public void stop() {
        wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
}
