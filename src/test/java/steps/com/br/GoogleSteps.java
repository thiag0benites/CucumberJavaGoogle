package steps.com.br;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import pages.com.br.GooglePage;

public class GoogleSteps {
	
	private WebDriver driver;
	protected GooglePage page;
	
	@After
	public void FechaBrowser(Scenario scenario) {
		if(!scenario.isFailed()) {
			scenario.write("Cenario Passou");
		}
		else
		{
			scenario.write("Cenario Falhou");
		}
		
		scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
		
		driver.quit();
	}
	
	@Dado("^que acesso o google pelo \"([^\"]*)\"$")
	public void que_acesso_o_google_pelo(String browser) throws Throwable {
		System.out.println("Dado que acesso o google pelo " + browser);
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		page = new GooglePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://google.com.br");
	}

	@E("^que digito o valor \"([^\"]*)\"$")
	public void que_digito_o_valor(String value) throws Throwable {
		System.out.println("E digito o valor " + value);
		page.txtSearch.sendKeys(value);
	}

	@Quando("^realizo a busca$")
	public void realizo_a_busca() throws Throwable {
		System.out.println("Quando realizo a busca");
		page.btnBuscar.submit();
	}

	@Entao("^apresenta a lista de resultados$")
	public void apresenta_a_lista_de_resultados() throws Throwable {
		System.out.println("apresenta a lista de busca$");
		page.CheckResult();
	}
}
