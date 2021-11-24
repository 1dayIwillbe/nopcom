import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {

 @Before
 public void openWeb() {
  openBrowser("https://demo.nopcommerce.com/");
 }


 @Test
 public void verifyProductArrangeInAlphaBaticalOrder() {
  selectMenu("Computers");
  clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
  clickOnElement(By.xpath("//select[@id='products-orderby']"));
  Actions action = new Actions(driver);
  action.moveToElement(driver.findElement(By.xpath("//select[@id='products-orderby']"))).click().build().perform();
  WebElement dropdown = driver.findElement(By.xpath("//select[@id='products-orderby']"));
  Select select = new Select(dropdown);
  select.selectByVisibleText("Name: Z to A");
  List<WebElement> products = driver.findElements(By.xpath("//div[@class='products-wrapper']//descendant::div[@class='item-box']"));
  List<String> names = new ArrayList<String>();
  for (WebElement e : products) {
   names.add(e.getText());
  }
  List<String> sortedNames = new ArrayList<String>(names);
  Collections.sort(sortedNames);
  System.out.println(sortedNames.equals(names));

  Assert.assertEquals("Sorting product names from Z to A is not working", names, sortedNames);
 }
 @Test
 public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
  selectMenu("Computers");
  clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
  clickOnElement(By.xpath("//select[@id='products-orderby']"));
  Actions action = new Actions(driver);
  action.moveToElement(driver.findElement(By.xpath("//select[@id='products-orderby']"))).click().build().perform();
  WebElement dropdown = driver.findElement(By.xpath("//select[@id='products-orderby']"));
  Select select = new Select(dropdown);
  select.selectByVisibleText("Name: A to Z");
  Thread.sleep(3000);
  driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']")).click();
  Thread.sleep(3000);
  verifyPage("Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"), "You are not on same page");
  WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
  Select select1 = new Select(dropdown1);
  select1.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
  WebElement dropdown2 = driver.findElement(By.id("product_attribute_2"));
  Select select2 = new Select(dropdown2);
  select2.selectByVisibleText("8GB [+$60.00]");
  clickOnElement(By.id("product_attribute_3_7"));
  clickOnElement(By.id("product_attribute_4_9"));
  Thread.sleep(2000);
  //clickOnElement(By.id("product_attribute_5_10"));
  Thread.sleep(2000);
  clickOnElement(By.id("product_attribute_5_12"));
  Thread.sleep(3000);
  //verifyPage("$1,475.00",By.xpath("//span[@id='price-value-1']"),"Check your option again");
  clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
  Thread.sleep(3000);
  verifyPage("The product has been added to your shopping cart",By.xpath("//p[text()='The product has been added to your ']"),"You are not on Shopping Chart");
  clickOnElement(By.xpath("//span[@class='close']"));
  action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"))).build().perform();
  Thread.sleep(4000);
  action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"))).click().perform();
  Thread.sleep(3000);
  action.doubleClick(driver.findElement(By.xpath("//input[@class='qty-input']"))).perform();
  driver.findElement(By.xpath("//input[@class='qty-input']")).sendKeys("2");
  Thread.sleep(2000);
  action.moveToElement(driver.findElement(By.xpath("//button[name='updatecart'][type='submit']"))).click().perform();
  Thread.sleep(3000);
  verifyPage("$2,950.00", By.xpath("//span[@class=\"product-subtotal\"]"), "amount not match");
  Thread.sleep(3000);
  clickOnElement(By.xpath("//input[@id=\"termsofservice\"]"));
  Thread.sleep(3000);
  clickOnElement(By.xpath("//button[@id=\"checkout\"]"));
  Thread.sleep(3000);
  verifyPage("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "User is not navigated correctly");
  clickOnElement(By.xpath("//button[@class=\"button-1 checkout-as-guest-button\"]"));
  sendText(By.xpath("//input[@id=\"BillingNewAddress_FirstName\"]"), "Rahul");
  sendText(By.xpath("//input[@id=\"BillingNewAddress_LastName\"]"), "Khanna");
  RandomString randomString = new RandomString();
  String s = randomString.nextString();
  sendText(By.xpath("//input[@id=\"BillingNewAddress_Email\"]"), s + "@hotmail.com");
  sendText(By.xpath("//input[@id=\"BillingNewAddress_Company\"]"), "helloComp");
  Thread.sleep(3000);
  selectFromDropDown(By.xpath("//select[@id=\"BillingNewAddress_CountryId\"]"), "133");
  clickOnElement(By.xpath("//select[@id=\"BillingNewAddress_StateProvinceId\"]"));
  sendText(By.xpath("//input[@id=\"BillingNewAddress_City\"]"), "Jodhpur.UK");
  sendText(By.xpath("//input[@id=\"BillingNewAddress_Address1\"]"), "1 Old Street ");
  sendText(By.xpath("//input[@id=\"BillingNewAddress_Address2\"]"), "New Building");
  sendText(By.xpath("//input[@id=\"BillingNewAddress_ZipPostalCode\"]"), "496001");
  sendText(By.xpath("//input[@id=\"BillingNewAddress_PhoneNumber\"]"), "066699991");
  sendText(By.xpath("//input[@id=\"BillingNewAddress_FaxNumber\"]"), "01121212121");
  clickOnElement(By.xpath("//button[@name=\"save\"]/parent::div[@id=\"billing-buttons-container\"]"));
  clickOnElement(By.xpath("//input[@id=\"shippingoption_1\"]"));
  clickOnElement(By.xpath("//button[@class=\"button-1 shipping-method-next-step-button\"]"));
  clickOnElement(By.xpath("//input[@id=\"paymentmethod_1\"]"));
  clickOnElement(By.xpath("//button[text()='Continue' and @name='save' and @onclick='PaymentMethod.save()']"));
  selectFromDropDown(By.id("CreditCardType"), "MasterCard");
  Thread.sleep(3000);
  sendText((By.xpath("//input[@id='CardholderName']")), "Rkhanna");
  sendText(By.id("CardNumber"), "5412 5412 9494 3131");
  selectFromDropDown(By.id("ExpireMonth"), "8");
  Thread.sleep(3000);
  selectFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2029");
  sendText(By.xpath("//input[@id='CardCode']"),"618");
  Thread.sleep(3000);
  //click on continue button on page where we fill all card details
  clickOnElement(By.xpath("//button[@onclick=\"PaymentInfo.save()\"]"));
  verifyPage("Credit Card",By.xpath("//span[contains(text(),'Credit Card')]"),"Payment method is not credit card");
  verifyPage("",By.xpath("//span[contains(text(),'\\n\" +\n" +
          "                \"                                Next Day Air\\n\" +\n" +
          "                \"                            ')]"),"Shipping method is not correct");
  verifyPage("$2,950.00",By.xpath("//span[contains(text(),'$2,950.00')]"),"Amount not matched");
  clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
  Thread.sleep(3000);
  verifyPage("",By.xpath("//h1[contains(text(),'Thank you')]"),"User can not see thank you message");
  verifyPage("Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"User is not able to see any text about order conformation");
  clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
  verifyPage("Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]"),"User is not able to see well come note");


 }

 @After
 public void closeWeb(){
  //closeBrowser();
 }


}


