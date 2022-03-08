package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {

	
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")WebElement DashBoard_Header_Field;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]")WebElement Customers_Field;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]")WebElement AddCustomers_Field;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customers')]")WebElement listCustomers_Field;
	
	public void verifyDashBoardPage() {
		Assert.assertEquals(DashBoard_Header_Field.getText(), "Dashboard", "Not on rightPage");
	}
public void clickCustomersButton() {
	Customers_Field.click();
}
public void AddCustomersButton() {
	AddCustomers_Field.click();
}
public void listCustomersButton() {
	listCustomers_Field.click();
}
}
