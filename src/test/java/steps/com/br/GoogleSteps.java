package steps.com.br;

import org.openqa.selenium.WebDriver;
import config.com.br.hooks;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import pages.com.br.GooglePage;

public class GoogleSteps {
	
	private WebDriver driver;
	protected GooglePage page;
	
	public GoogleSteps() {
		driver = hooks.GetDriver();
		page = new GooglePage(driver);
	}
	
	@Dado("^que acesso a url \"([^\"]*)\"$")
	public void que_acesso_a_url(String url) throws Throwable {
		System.out.println("E que acesso a url " + url);
		driver.navigate().to(url);
	}

	@Dado("^que digito o valor \"([^\"]*)\"$")
	public void que_digito_o_valor(String value) throws Throwable {
		System.out.println("digito o valor " + value);
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
