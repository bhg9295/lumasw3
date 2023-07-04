package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void test() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        WebElement gear = driver.findElement((By.xpath("//a[@id='ui-id-6']//span[contains(text(),'Gear')]")));
        WebElement bag = driver.findElement(By.xpath("//span[contains(text(),'Bags')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).moveToElement(bag).click().perform();
//Verify the text ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        String expectedText ="Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        Assert.assertEquals("Text is not displayed",expectedText,actualText);
//chande qty
        WebElement qtybox = driver.findElement(By.xpath("//input[@id='qty']"));
        qtybox.clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");
        // click on the cart
        clickOnElement(By.cssSelector("button[id='product-addtocart-button'] span"));
        // verify the message
        String expectedMessage="You added Overnight Duffle to your shopping cart.";
        String actualMessage = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("Message is not displayed",expectedMessage,actualMessage);
//verify shopping cart
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        String actualTextInCart = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        Assert.assertEquals("Product name text is not displayed correctly",expectedText,actualTextInCart);
// Verify the Qty is ‘3’
        String expectedqty = "3";
        WebElement actualQtyWebEle = driver.findElement(By.xpath("//td[@data-th='Qty']/div/div/label/input"));
        String actualQty = actualQtyWebEle.getAttribute("value");
        Assert.assertEquals("Price is not displayed correctly",expectedqty,actualQty);
        String expectedPrice = "$135.00";

// Verify the Qty is ‘5’
        String expectedQty = "5";
        WebElement actualqtyWebEle = driver.findElement(By.xpath("//td[@data-th='Qty']/div/div/label/input"));
        String actualQtyn = actualQtyWebEle.getAttribute("value");
        Assert.assertEquals("Price is not displayed correctly",expectedQty,actualQtyn);
        String expectedPrices = "$225.00";



    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
