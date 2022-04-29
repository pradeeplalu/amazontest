package laptop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void SetUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheProductsDisplayed() {
        clickOnElement(By.id("sp-cc-accept"));//accept cookies
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");//send text to search bar
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));//click on search button
        //click on checkbox against 'Dell'
        clickOnElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]"));

        WebElement productDell=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        int countProducts = products.size();
        List<String> actualListName = new ArrayList<>();
        for (WebElement element : products) {
            actualListName.add(element.getText());
        }
        //verify products count
        if (productDell.isDisplayed()){
            Assert.assertEquals("Check number of products : ",countProducts,30);}
        //print the products list
        System.out.println("Prodcuts Name:" + actualListName);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
