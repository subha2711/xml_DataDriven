package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {

	
	WebDriver driver;
	@Test
	@Parameters({ "userName", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State",
		"Zip", "Country" })
	public void verifiedUserMustBeAbleToGoToListCustomerAndPeformOperations(String username, String pwd, String fullName, String company,
			String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();
		String f_Name = fullName;
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(pwd);
		loginPage.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashBoardPage();
		dashboardPage.clickCustomersButton();
		dashboardPage.listCustomersButton();
		
		ListCustomerPage  listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.verifyIfItsContactTitleOnListCustomer();
		listCustomerPage.clickAddCustomer();
		
		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.verifyAddContactPage();
		addCustomer.enterFullname(f_Name);
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
		//dashboardPage.clickCustomersButton();
		dashboardPage.listCustomersButton();
		listCustomerPage.verifyIfItsContactTitleOnListCustomer();
		listCustomerPage.verifySearchBarAddSummaryButton(f_Name);
		addCustomer.accountSummaryPage();
		
		BrowserFactory.tearDown();
	}
}
