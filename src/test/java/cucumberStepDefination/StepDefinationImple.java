package cucumberStepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import Olu1.TestComponents.BaseTest;
import OluLearn.PageObjects.CartPage;
import OluLearn.PageObjects.CheckoutPage;
import OluLearn.PageObjects.ConfirmationPage;
import OluLearn.PageObjects.LandingPage;
import OluLearn.PageObjects.ProductToCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImple extends BaseTest {
	
	LandingPage LP;
	ProductToCart PTC;
	CartPage CP;
	ConfirmationPage ConfP;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		
		LP = LaunchApp();
		
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		
	PTC = LP.LoginApplication(username, password);
			
	}
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		
		List<WebElement> products =  PTC.getProducts();
		
		PTC.addProductToCart(productName);
	
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
	 CP = PTC.clickCartHeader();

			
			Boolean match = CP.verifyProductAdded(productName);
			Assert.assertTrue(match);
			
			CheckoutPage coPage = CP.clickCheckout();
			coPage.SelectCountry("india");
			ConfP = coPage.PlaceOrder();
		 
	 }
	 
	@Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string)
    {
		 
		 String match1 = ConfP.GetDisplayText();
			AssertJUnit.assertTrue(match1.equalsIgnoreCase(string));
		 
	 }
	
	 @Then("^\"([^\"]*)\" message is displayed$")
	    public void something_message_is_displayed(String strArg1) throws Throwable {
	   
	    	Assert.assertEquals(strArg1, LP.ErrorLogin());
	 }
	 
	 
	 
	 
	

}
