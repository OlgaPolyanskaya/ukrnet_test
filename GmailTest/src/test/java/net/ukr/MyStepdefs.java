package net.ukr;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public static void public static void main(String[]args){
        MyStepdefs obj=new MyStepdefs;
        }
public class MyStepdefs {
    private static ChromeDriver driver;
    private static WebDriverWait waiter;
    private static JavascriptExecutor js;


    String email;
    String password;
    @io.cucumber.java.en.Given("^Login page is open$")
    public void loginPageIsOpen() {
            WebDriverManager.chromediriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://accounts.ukr.net/login");
            waiter = new WebDriverWait(driver, 1000);
            js = (JavascriptExecutor) driver;
    }

    @Test
    @io.cucumber.java.en.When("^I enter valid login (.*)$")
    public void iEnterValidLogin(String arg0) throws Throwable {
        WebElement element1 = waiter.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("./html/body/div/div/main/form/div[1]/div/input")));
        element1.sendKeys(arg0);
        throw new cucumber.api.PendingException();
    }

    @io.cucumber.java.en.And("^I enter valid password (.*)$")
    public void iEnterValidPassword(String arg0) throws Throwable {
        WebElement element2 = driver.findElementByXPath("/html/body/div/div/main/form/div[2]/div/input");
        element2.sendKeys(arg0);
        throw new cucumber.api.PendingException();
    }

    @io.cucumber.java.en.And("^I click btn$")
    public void iClickBtn() throws Throwable {
            WebElement btn = driver.findElementByXPath("/html/body/div/div/main/form/button");
            btn.click();
             throw new cucumber.api.PendingException();
    }
//
//    @io.cucumber.java.en.Then("^page redirects me to my inbox$")
//    public void pageRedirectsMeToMyInbox() {
//    }
//
//    @io.cucumber.java.en.When("^I enter login <login>$")
//    public void iEnterLoginLogin() {
//    }
//
//    @io.cucumber.java.en.And("^I enter password <password>$")
//    public void iEnterPasswordPassword() {
//    }
//
//    @io.cucumber.java.en.Then("^system returns an error$")
//    public void systemReturnsAnError() {
//    }
}
