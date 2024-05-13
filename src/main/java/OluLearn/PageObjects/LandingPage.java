package OluLearn.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OluLearn.AbstractComponentz.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	@FindBy(id="userEmail")
	WebElement UserName;
	
	@FindBy(id="userPassword")
	WebElement UserpassWord;
	
	@FindBy(id="login")
	WebElement submit;	
			
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrorLogin;
		public ProductToCart LoginApplication(String Email, String Password) {
		UserName.sendKeys(Email);
		UserpassWord.sendKeys(Password);
		submit.click();
		ProductToCart PTC = new ProductToCart(driver);
		return PTC;
	}
		
	public void GoTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
		
		
	}
	
	public String ErrorLogin() {
		waitForElementToAppearWE(ErrorLogin);
		return ErrorLogin.getText();
	}

	
	

}

