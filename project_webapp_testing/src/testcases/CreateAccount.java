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

public class CreateAccount {
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
      driver.findElement(By.linkText("Account")).click();
      Thread.sleep(1500);
      driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/div/a[2]")).click();
      Thread.sleep(1500);
      driver.findElement(By.xpath("//*[@id=\"id_username\"]")).sendKeys("Testing");
      driver.findElement(By.xpath("//*[@id=\"id_first_name\"]")).sendKeys("Bill");
      driver.findElement(By.xpath("//*[@id=\"id_last_name\"]")).sendKeys("Smith");
      driver.findElement(By.xpath("//*[@id=\"id_email\"]")).sendKeys("Bill.Smith@gmail.com");
      driver.findElement(By.xpath("//*[@id=\"id_password1\"]")).sendKeys("bIll#123");
      driver.findElement(By.xpath("//*[@id=\"id_password2\"]")).sendKeys("bIll#123");
      Thread.sleep(2000);
      driver.findElement(By.className("btn-success")).click();
      Thread.sleep(2000);
      Assert.assertEquals("Discover", driver.findElement(By.xpath("/html/body/div[2]/h2")).getText());
      Thread.sleep(1000);
      driver.findElement(By.linkText("Account")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/div/a[3]")).click();
      Thread.sleep(5000);
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
