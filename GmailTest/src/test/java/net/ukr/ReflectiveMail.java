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


public class ReflectiveMail {

    private static ChromeDriver driver;
    private static WebDriverWait waiter;
    private static JavascriptExecutor js;

//    class SingleDiriver() {
//
//    }

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromediriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.ukr.net/login");
        js = (JavascriptExecutor) driver;
        authorize();
    }

    private static void authorize() {
        WebElement element1 = waiter.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("./html/body/div/div/main/form/div[1]/div/input")));
        element1.sendKeys("tigrina.pitonovna");
        WebElement element2 = driver.findElementByXPath("/html/body/div/div/main/form/div[2]/div/input");
        element2.sendKeys("n0n0n0y9s");
        WebElement btn = driver.findElementByXPath("/html/body/div/div/main/form/button");
        btn.click();

    }

    @Test
    public void writeMessage() throws InterruptedException {
        String email = "tigrina.pitonovna@ukr.net";
        String body = "qwerty 1234567890";
        String theme = "test" + String.valueOf((int) (Math.random() * 1000));
        int quantityOfMails2;
        boolean flag;
        String actualBody;
        try {
            WebElement container1 = waiter.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("/html/body/div[1]/div[2]/aside/button")));
            int quantityOfMails1 = Integer.parseInt(driver.findElementByCssSelector("#\\30  > span.sidebar__list-link-count").getText());
            System.out.println(quantityOfMails1);

            WebElement btnMakeMessage = driver.findElementByXPath("/html/body/div[1]/div[2]/aside/button");
            btnMakeMessage.click();
            WebElement container2 = waiter.until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector("#screens > div > div.screen__content > section.sendmsg__form > div:nth-child(1) > div.sendmsg__form-label-field.auto.cropped.ui-sortable > input.input")));
            WebElement textAreaTo = driver.findElementByCssSelector("#screens > div > div.screen__content > section.sendmsg__form > div:nth-child(1) > div.sendmsg__form-label-field.auto.cropped.ui-sortable > input.input");
            textAreaTo.sendKeys(email);
            WebElement textAreaTheme = driver.findElementByCssSelector("#screens > div > div.screen__content > section.sendmsg__form > div:nth-child(4) > div.sendmsg__form-label-field.subject > input");
            textAreaTheme.sendKeys(theme);
            driver.switchTo().frame("mce_0_ifr");
            WebElement textArea = driver.findElementByCssSelector("#tinymce > div");
            textArea.sendKeys(body);
            driver.switchTo().parentFrame();
            WebElement btnSend = driver.findElementByCssSelector("#screens > div > div.screen__head > div > button");
            btnSend.click();
            waiter.until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector("#screens > div > div.sendmsg__ads.show.ready > " +
                    "div.sendmsg__ads-sending > div.sendmsg__ads-ready > button.action")));
            quantityOfMails2 = Integer.parseInt(driver.findElementByCssSelector("#\\30  > span.sidebar__list-link-count").getText());
            System.out.println(quantityOfMails2);
            flag = quantityOfMails1 < quantityOfMails2;
            WebElement btnInbox = driver.findElementByCssSelector(("#screens > div > div.sendmsg__ads.show.ready > " +
                    "div.sendmsg__ads-sending > div.sendmsg__ads-ready > button.action"));
            btnInbox.click();
            WebElement topMssg = driver.findElementByPartialLinkText(theme);
            topMssg.click();
            waiter.until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector("#readmsg > div.screen__content > section >" +
                    " div.readmsg__content > div.readmsg__body > span > div > span")));
            WebElement mailBody = driver.findElementByXPath("//*[@id=\"readmsg\"]/div[2]/section/div[2]/div[1]/span/div/span");
            actualBody = mailBody.getText();

        } finally {
            driver.quit();
        }
        Assert.assertEquals(true, flag);
        Assert.assertEquals(body, actualBody);
    }


}
