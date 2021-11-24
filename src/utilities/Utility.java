package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseClass {
    //Click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }


    public void selectFromDropDown(By by,String value){
        WebElement dropDown1=driver.findElement(by);
        dropDown1.click();
        Select select1=new Select(dropDown1);
        select1.selectByValue(value);
    }

    //Assert Method verification
    public String verifyPage(String expectedMessage, By by, String message) {
     String actualMessage = driver.findElement(by).getText();
     Assert.assertEquals(message,expectedMessage,actualMessage) ;
     return message;
    }

    //Get data from element
    public String getDataFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void selectMenu(String menu){
        driver.findElement(By.linkText(menu)).click();
    }
    //Send data to element

    public void sendText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

}
