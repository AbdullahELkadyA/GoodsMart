package appium.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileBrowserType;

public class BasePage {
	public AndroidDriver driver ;
    public JavascriptExecutor jse ;
    public Select select ;
    public Actions action ;

    // create constructor
    public BasePage(AndroidDriver driver)
    {
    	 this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected static void clickButton(WebElement button)
    {
        button.click();
    }

    protected static void setTextElementText(WebElement textElement , String value)
    {
        textElement.sendKeys(value);
    }
    public void scrollToBottom()

    {
        jse.executeScript("scrollBy(0,2500)");
    }

    public void clearText(WebElement element)
    {
        element.clear();
    }
}
