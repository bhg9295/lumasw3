package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {
    String baseUrl ="https://magento.softwaretestingboard.com/";
    @Before
    public void test(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter(){
        //Mouse Hover on Women Menu
        WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        WebElement jacket = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).moveToElement(tops).moveToElement(jacket).click().perform();
//Sort By filter “Product Name”
        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
        //Verify the products name display in alphabetical order
        select.selectByValue("name");
        List<WebElement>ProductName = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println(ProductName.size());
        for (WebElement ele : ProductName) {
            System.out.println(ele.getText());
        }
    }
    @Test
    public void verifyTheSortByPriceFilter(){
        // //Mouse Hover on Women Menu
        WebElement women = driver.findElement((By.xpath("//span[contains(text(),'Women')]")));
        //Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).moveToElement(tops).moveToElement(jackets).click().perform();
        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
        //Select by Value
        select.selectByValue("price");
        List<WebElement>productname = driver.findElements(By.xpath("//body/div[1]/main[1]/div[1]/h1[1]/span[1]"));
        System.out.println(productname.size());
        for (WebElement ele: productname){
            System.out.println(ele.getText());
        }
    }
    @After
    public void tearDown() {
       closeBrowser();

    }
}

