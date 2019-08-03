package pages.com.br;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	
	private WebDriver driver;
	
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(how = How.NAME, using = "q")
	@FindBy(name="q")
	public WebElement txtSearch;
	
	//@FindBy(how = How.NAME, using = "btnK")
	@FindBy(name="btnK")
	public WebElement btnBuscar;
	
	//@FindBy(how = How.CLASSNAME, using = "rc")
	@FindBy(className="rc")
	public List<WebElement> listResult;
	
	public void CheckResult() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(listResult.get(1)));

		int noticias = listResult.size();
		Assert.assertFalse(noticias == 0);
	}
}
