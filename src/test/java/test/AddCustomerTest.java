package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;

	@Test
	@Parameters({ "userName", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State",
			"Zip", "Country" })
	public void validUserShouldBeAbleToCreateCustomer(String username, String pwd, String fullName, String company,
			String email, String phone, String address, String city, String state, String zip, String country) {

		driver=	BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(pwd);
		loginPage.clickSignInButton();

		DashboardPage dashBoard = PageFactory.initElements(driver, DashboardPage.class);
		dashBoard.verifyDashBoardPage();
		dashBoard.clickCustomersButton();
		dashBoard.AddCustomersButton();

		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.verifyAddContactPage();
		addCustomer.enterFullname(fullName);
		addCustomer.selectCompany(company);
		addCustomer.enterEmail(email);
		addCustomer.enterPhoneNumber(phone);
		addCustomer.enterAddress(address);
		addCustomer.enterCity(city);
		addCustomer.enterState(state);
		addCustomer.enterZip(zip);
		addCustomer.enterCountry(country);
		addCustomer.saveButton();

		addCustomer.accountSummaryPage();
		dashBoard.listCustomersButton();
		addCustomer.verifyEnteredNameAndDelete();

		 BrowserFactory.tearDown();
	}
}
