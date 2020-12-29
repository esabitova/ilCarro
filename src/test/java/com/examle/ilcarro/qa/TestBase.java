package com.examle.ilcarro.qa;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp(){
        app.start();
    }

    @AfterMethod()
    public void tearDown() {
        app.stop();
    }

}
