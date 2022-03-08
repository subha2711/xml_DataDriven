package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage {

	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Contacts')]") WebElement  contactsTitle_OnListCustomerPage;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),' Add Customer')]")WebElement AddCustomer_OnListCustomer;
	@FindBy(how = How.XPATH, using = "//input[@id='foo_filter']")WebElement searchBar_OnListCustomer;
	@FindBy(how = How.XPATH, using = "//input[@id='foo_filter']")WebElement verifyContactPage;
	


public void verifyIfItsContactTitleOnListCustomer() {
	Assert.assertEquals(contactsTitle_OnListCustomerPage.getText(), "Contacts", "Not on the Contacts on the List Customer Page");
}

public void clickAddCustomer() {
	AddCustomer_OnListCustomer.click();
}

public void verifySearchBarAddSummaryButton(String name) {
String xpath_before = "//tbody/tr[";
String xpath_after = "]/td[3]";

System.out.println(name);
for(int i=1; i<=10; i++) {
	String xname =driver.findElement(By.xpath(xpath_before+i+xpath_after)).getText();
	searchBar_OnListCustomer.sendKeys(name+xname.substring(6));
	if(xname.contains((name+xname.substring(6)))) {
		System.out.println(name+xname.substring(6));
		driver.findElement(By.xpath(xpath_before + i +xpath_after +" /following-sibling::td[4]/a[1]")).click();
	}
	break;
}
}

}
