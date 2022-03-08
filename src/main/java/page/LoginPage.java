package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using ="//input[@id='username']")
	WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using ="//input[@id='password']")
	WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using ="//button[contains(text(),'Sign in')]")
	WebElement SIGNIN_FIELD;

	public void enterUserName(String username) {
		USERNAME_FIELD.sendKeys(username);
	}

	public void enterPassword(String Password) {
		PASSWORD_FIELD.sendKeys(Password);
	}

	public void clickSignInButton() {
		SIGNIN_FIELD.click();
	}

}
