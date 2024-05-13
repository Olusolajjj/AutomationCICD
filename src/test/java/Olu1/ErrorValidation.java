package Olu1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
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
import OluLearn.PageObjects.ProductToCart;
import io.opentelemetry.context.ImplicitContextKeyed;

public class ErrorValidation extends BaseTest{

	
		
		String productName = "ADIDAS ORIGINAL";
		String countryName = "india";
		String DisplayedText = "THANKYOU FOR THE ORDER.";
		String InvalidProductName = "Name not there";

		@Test(groups = {"error"})
		public void loginErrorValidation() throws IOException {
		
		LP.LoginApplication("olu7777@gmail.com", "AAb123456");
		AssertJUnit.assertEquals("Incorrect email or password.", LP.ErrorLogin());
		
		
		
	}
		@Test(groups = {"error"})
	public void CartProductErrorValidation() {
		
		
		ProductToCart PTC = LP.LoginApplication("olu7777@gmail.com", "Ab123456");


		List<WebElement> products =  PTC.getProducts();
		PTC.addProductToCart(productName);
		
		CartPage CP = PTC.clickCartHeader();


		
		Boolean match = CP.verifyProductAdded(InvalidProductName);
		Assert.assertFalse(match);
	}
		

		

		}