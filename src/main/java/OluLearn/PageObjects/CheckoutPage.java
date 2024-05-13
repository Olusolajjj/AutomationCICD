package OluLearn.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import OluLearn.AbstractComponentz.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement typeCountry;
	
	
	
	@FindBy(css ="[placeholder='Select Country']")
	WebElement country;	
	
	@FindBy(css=".action__submit")
	WebElement PlaceOrder;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By countriesVisible = By.cssSelector(".ta-results");
	
	By PlaceOrderr = By.cssSelector(".action__submit");
	
	
	public void SelectCountry(String countryName) {
		
		Actions a = new Actions(driver);

	    a.sendKeys(country, countryName).build().perform();

	    waitForElementToAppear(countriesVisible);

	    selectCountry.click();
	}
	
	public ConfirmationPage PlaceOrder() {
		
		clickElementWithScroll(PlaceOrder);
		//Wait.until(ExpectedConditions.elementToBeClickable(PlaceOrderr)).click();
		
		//Point p= PlaceOrder.getLocation(); 
		//Actions actions = new Actions(driver); 
		//actions.moveToElement(PlaceOrder).moveByOffset(p.x,p.y).click().perform();
		
	    //PlaceOrder.click();
	    ConfirmationPage ConfP = new ConfirmationPage(driver);
	    return ConfP;
		
	}

}

