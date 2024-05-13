package OluLearn.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OluLearn.AbstractComponentz.AbstractComponents;

public class ProductToCart extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductToCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement animating;
	
	
	
	By productLists = By.cssSelector(".mb-3");
	By addToCart = By.xpath(".//div[@class='card-body']/button[2]");
	By toastContainer = By.cssSelector("#toast-container");
	
	
	
	public List<WebElement> getProducts(){
		waitForElementToAppear(productLists);
		return products;
	}
		
	
	public WebElement getProductName(String productName) {
		
		WebElement prod = products.stream().filter(product->

		product.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals(productName)).findFirst().orElse(null);
		
		return prod;
	}
	
	public void addProductToCart(String productName) {
		
		
		WebElement prod =	getProductName(productName);
		
		prod.findElement(addToCart).click();
		
		waitForElementToAppear(toastContainer);
		waitForElementToDisappear(animating);
		
		
		
			}
	
	
	
	
}

	


