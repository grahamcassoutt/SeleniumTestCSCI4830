package testcases;

import static org.junit.Assert.fail;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
   private WebDriver driver;
   private String baseUrl;
   private boolean acceptNextAlert = true;
   private StringBuffer verificationErrors = new StringBuffer();
   JavascriptExecutor js;

   @Before
   public void setUp() throws Exception {
      System.setProperty("webdriver.chrome.driver", "lib/mac/chromedriver");
      driver = new ChromeDriver();
      baseUrl = "http://ec2-3-95-26-219.compute-1.amazonaws.com:8000";
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
      js = (JavascriptExecutor) driver;
   }

   @Test
   public void testUntitledTestCase() throws Exception {
      driver.manage().window().maximize();
      driver.get(baseUrl);
      driver.findElement(By.linkText("Subjects")).click();
      Thread.sleep(1500);
      driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[1]/div/a[1]")).click();
      Thread.sleep(1500);
      driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/form/input[2]")).sendKeys("Testing");
      Thread.sleep(1500);
      driver.findElement(By.className("btn-outline-success")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[2]/ul/li/a")).click();
      Thread.sleep(3000);
      Assert.assertEquals("Title: Testing", driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h2")).getText());
      Thread.sleep(3000);
   }

   @After
   public void tearDown() throws Exception {
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
         fail(verificationErrorString);
      }
   }

   @SuppressWarnings("unused")
   private boolean isElementPresent(By by) {
      try {
         driver.findElement(by);
         return true;
      } catch (NoSuchElementException e) {
         return false;
      }
   }

   @SuppressWarnings("unused")
   private boolean isAlertPresent() {
      try {
         driver.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }

   @SuppressWarnings("unused")
   private String closeAlertAndGetItsText() {
      try {
         Alert alert = driver.switchTo().alert();
         String alertText = alert.getText();
         if (acceptNextAlert) {
            alert.accept();
         }
         else {
            alert.dismiss();
         }
         return alertText;
      } finally {
         acceptNextAlert = true;
      }
   }

}
