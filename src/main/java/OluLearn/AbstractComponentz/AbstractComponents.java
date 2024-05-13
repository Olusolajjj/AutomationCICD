package OluLearn.AbstractComponentz;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import OluLearn.PageObjects.CartPage;
import OluLearn.PageObjects.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrdersHeader;

	public void waitForElementToAppear(By findBy) {
		
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	
}
	
	public void clickElementWithScroll(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(element));

        // Scroll to the element
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

        // Click on the element
        element.click();
    }
		
		
	
	
public void waitForElementToAppearWE(WebElement element) {
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void waitForElementToDisappear(WebElement element) {
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	public CartPage clickCartHeader() {
		cartHeader.click();
		CartPage CP = new CartPage(driver);
		return CP;
	}
	
	public OrdersPage clickOrdesHeader() {
		OrdersHeader.click();
		OrdersPage OP = new OrdersPage(driver);
		return OP;
	}
}


