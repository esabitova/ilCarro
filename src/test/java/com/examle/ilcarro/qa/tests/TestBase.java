package com.examle.ilcarro.qa.tests;

import com.examle.ilcarro.qa.application.ApplicationManager;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp(){
        app.start();
    }

    @AfterSuite()
    public void tearDown() {
        app.stop();
    }

}
