package Olu1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Olu1.TestComponents.BaseTest;
import OluLearn.PageObjects.CartPage;
import OluLearn.PageObjects.CheckoutPage;
import OluLearn.PageObjects.ConfirmationPage;
import OluLearn.PageObjects.LandingPage;
import OluLearn.PageObjects.OrdersPage;
import OluLearn.PageObjects.ProductToCart;
import io.opentelemetry.context.ImplicitContextKeyed;

public class standByLinks4 extends BaseTest{
	
	String productName = "ADIDAS ORIGINAL";
	
	String DisplayedText = "THANKYOU FOR THE ORDER.";
	

	@Test(dataProvider = "getData", groups = "purchaseT")
	public void submitOrderr(HashMap<String, String> input) throws IOException {
		
		

		
		ProductToCart PTC = LP.LoginApplication(input.get("email"), input.get("password"));


		List<WebElement> products =  PTC.getProducts();
		PTC.addProductToCart(input.get("productName"));
		
		CartPage CP = PTC.clickCartHeader();

		

		


		
		Boolean match = CP.verifyProductAdded(productName);
		Assert.assertTrue(match);
		
		CheckoutPage coPage = CP.clickCheckout();
		coPage.SelectCountry(input.get("countryName"));
		
		ConfirmationPage ConfP = coPage.PlaceOrder();
		String match1 = ConfP.GetDisplayText();
		AssertJUnit.assertTrue(match1.equalsIgnoreCase(DisplayedText));
		
		
		
	}
	
	@Test (dependsOnMethods = {"submitOrderr"})
	public void OrderVal() {
		ProductToCart PTC = LP.LoginApplication("olu7777@gmail.com", "Ab123456");
		OrdersPage OP = PTC.clickOrdesHeader();
		Assert.assertTrue(OP.verifyOrdersDisplay(productName));
		
		
	}
	
	@DataProvider
	
	public Object[][] getData() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "olu7777@gmail.com");
		map.put("password", "Ab123456");
		map.put("productName", "ADIDAS ORIGINAL");
		map.put("countryName", "India");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "olu6666@gmail.com");
		map1.put("password", "Bb123456");
		map1.put("productName", "IPHONE 13 PRO");
		map1.put("countryName", "Poland");
		
		return new Object[][]{{map},{map1}};
		
	}
		

		

		}