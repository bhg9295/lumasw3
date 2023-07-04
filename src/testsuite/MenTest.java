package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl ="https://magento.softwaretestingboard.com/";
    @Before
    public void test(){

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        WebElement men = driver.findElement((By.xpath("//span[contains(text(),'Men')]")));
        WebElement Bottoms = driver.findElement(By.cssSelector("#ui-id-18"));
        WebElement Pants = driver.findElement(By.cssSelector("#ui-id-23"));
// mouse hover method
        Actions actions = new Actions(driver);
        actions.moveToElement(men).moveToElement(Bottoms).moveToElement(Pants).click().perform();
//clicking Cronus Yoga Pant
        WebElement CronusYogaPant = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/a[1]/span[1]/span[1]"));
        WebElement size = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        // mouse hover method
        actions.moveToElement(CronusYogaPant).click().perform();
//find colour
        WebElement CronuYogaPant = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/a[1]/span[1]/span[1]/img[1]"));
        WebElement colour = driver.findElement(By.cssSelector("#option-label-color-93-item-49"));
//size 32
        clickOnElement(By.xpath("//div[@id='option-label-size-143-item-175']"));
  // Colour Black
        clickOnElement(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]"));
    //Add to cart
        clickOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
// verify text message
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        String actualMessage = getTextFromElement(By.xpath("//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']"));
       Assert.assertEquals("Message is not displayed", expectedMessage, actualMessage);
       clickOnElement(By.xpath("/a[contains(text(),'shopping cart')]"));
//verify shopping cart
        String expectedText = "Shopping Cart";
        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals("Text is not displayed", expectedText, actualText);
//verify Cronus yoga pant
        String expectedProductName = "Cronus Yoga Pant";
        String actualProductName = getTextFromElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant'])[2]"));
        Assert.assertEquals("Product Name is not displayed correctly", expectedProductName,actualProductName);
//verify size 32
        String expectedSize = "32";
        String actualSize = getTextFromElement(By.xpath("//dl[@class='item-options']//dt[contains(text(),'Size')]"));
        String[] parts = actualSize.split(" ");
        String productSize = parts[1];
        Assert.assertEquals("Product size is not displayed correctly", expectedSize,productSize);
// verify product colour black
        String expectedColour = "Black";
        String actualColour = getTextFromElement(By.xpath("//dl[@class='item-options']//dt[contains(text(),'Color')]"));
        String[] stringParts = actualColour.split(" ");
        String productColour = stringParts[1];
        Assert.assertEquals("Product Colour is not displayed correctly", expectedColour,productColour);


    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
