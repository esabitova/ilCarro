package com.examle.ilcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void logIn() throws InterruptedException {
        clickByCss("[href='/login']");
        // click(By.cssSelector("[href='/login']"));
        fillLoginForm("my.email1608881337043@gmail.com", "Aa1234567");
        pause(2000);
        clickByCss("[type=submit]");
    }

    public void clickYallaButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public boolean isRegistrationFormPresent() {
        return isElementPresent(By.xpath("//h2[contains(., 'Registration')]"));
    }

    public void clickLogInButton() {
        clickByCss("[href='/login']");
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
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

    public void fillLoginForm(String email, String password) {
        typeByCss("[name=email]", email);
        typeByCss("[name=password]", password);
    }

    public void typeByCss(String cssSelector, String text) {
        clickByCss(cssSelector);
        wd.findElement(By.cssSelector(cssSelector)).clear();
        wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public void clickByCss(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByXpath(String xpath) {
        wd.findElement(By.xpath(xpath)).click();
    }

    public void clickLogoutButtonOnHeader() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(., 'logOut')]"));
    }
}
