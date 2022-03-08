package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;
	String enteredName;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Add Contact')]")
	WebElement AddContactPage_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FullName_Field;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement company_Field;
	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	WebElement email_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement phone_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement address_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement city_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement state_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement zip_Field;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement country_Field;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement savebutton_On_AddContactField;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Summary')]")
	WebElement SummaryPage;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	WebElement okButtonToConfirmDelete;

	public void verifyAddContactPage() {
		Assert.assertEquals(AddContactPage_Field.getText(), "Add Contact", "Not on rightPage");
	}

	public void enterFullname(String fullname) {
		enteredName = fullname + generateNumber(500);
		FullName_Field.sendKeys(enteredName);
	}

	public void selectCompany(String company) {
		selectDropDown(company_Field, company);
	}

	public void enterEmail(String email) {
		email_Field.sendKeys(generateNumber(500) + email);
	}

	public void enterPhoneNumber(String phoneNumber) {
		phone_Field.sendKeys(generateNumber(500) + phoneNumber);
	}

	public void enterAddress(String address) {
		address_Field.sendKeys(address);
	}

	public void enterCity(String city) {
		city_Field.sendKeys(city);
	}

	public void enterState(String state) {
		state_Field.sendKeys(state);
	}

	public void enterZip(String zipcode) {
		zip_Field.sendKeys(zipcode);
	}

	public void enterCountry(String country) {
		selectDropDown(country_Field, country);
	}

	public void saveButton() {
		savebutton_On_AddContactField.click();
	}

	public void accountSummaryPage() {
		waitForElement(driver, 5, SummaryPage);
		Assert.assertEquals(SummaryPage.getText(), "Summary", "Not on right page after saving");
	}

	public void verifyEnteredNameAndDelete() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			/*
			 * System.out.println(name); Assert.assertEquals(name, enteredName,
			 * "Entered name does not exist"); break
			 */;
			if (name.contains(enteredName)) {
				System.out.println("Entered name exist");
				// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
				driver.findElement(By.xpath(before_xpath + i + after_xpath + "/following-sibling::td[4]/a[2]")).click();
//			 Alert alert = driver.switchTo().alert();
//			 waitForElement(driver, 10, areYouSureWindow);
				okButtonToConfirmDelete.click();
			}
		}
	}
}
