package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    @Before
    public void openWeb(){
        openBrowser("https://demo.nopcommerce.com/");
    }
        @Test
     public void topMenuTest(){
        selectMenu("Computers");
        verifyPage("Computers",By.xpath("//h1[normalize-space()='Computers']"),"You are not on Computers Page.");
    }
    @Test
    public void topMenuTest2(){
        selectMenu("Computers");
        verifyPage("Computers",By.xpath("//h1[normalize-space()='Computers']"),"You are not on Computers Page.");
    }
    @Test
    public void topMenuTest3(){
        selectMenu("Electronics");
        verifyPage("Electronics",By.xpath("//h1[normalize-space()='Electronics']"),"You are not on Electronics Page.");
    }
    @Test
    public void topMenuTest4(){
        selectMenu("Apparel");
        verifyPage("Apparel",By.xpath("//h1[normalize-space()='Apparel']"),"You are not on Apparel Page.");
    }
    @Test
    public void topMenuTest5(){
        selectMenu("Digital downloads");
        verifyPage("Digital downloads",By.xpath("//h1[normalize-space()='Digital downloads']"),"You are not on Digital downloads Page.");
    }
    @Test
    public void topMenuTest6(){
        selectMenu("Books");
        verifyPage("Books",By.xpath("//h1[normalize-space()='Books']"),"You are not on Books Page.");
    }
    @Test
    public void topMenuTest7(){
        selectMenu("Jewelry");
        verifyPage("Jewelry",By.xpath("//h1[normalize-space()='Jewelry']"),"You are not on Jewelry Page.");
    }
    @Test
    public void topMenuTest8(){
        selectMenu("Gift Cards");
        verifyPage("Gift Cards",By.xpath("//h1[normalize-space()='Gift Cards']"),"You are not on Gift Cards Page.");
    }

// @ After
  //  public void closeWeb(){
    //    closeBrowser();
//}

}
