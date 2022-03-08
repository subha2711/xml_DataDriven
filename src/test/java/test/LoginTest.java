package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;

	@Test
	@Parameters({"userName" , "password"})
	public void validUserShouldBeAbleToLogIn( String username, String pwd) {
		
	driver=	BrowserFactory.init();
	
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	loginPage.enterUserName(username);
	loginPage.enterPassword(pwd);
	loginPage.clickSignInButton();
	
	
	DashboardPage dashBoard = PageFactory.initElements(driver,DashboardPage.class);
	dashBoard.verifyDashBoardPage();
	
		BrowserFactory.tearDown();
	}
}
