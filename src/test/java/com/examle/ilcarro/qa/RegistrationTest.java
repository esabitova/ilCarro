package com.examle.ilcarro.qa;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        // wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");
    }

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

    public void clickYallaButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public boolean isRegistrationFormPresent() {
        return wd.findElements(By.xpath("//h2[contains(., 'Registration')]")).size() > 0;
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void selectCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void fillRegistrationForm(String fName, String lName, String email, String password) {
        type(By.id("first_name"), fName);
        type(By.cssSelector("#second_name"), lName);

        System.out.println("email is: " + email);
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }

    public void openRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    @AfterMethod()
    public void tearDown() {
        wd.quit();
    }

}


