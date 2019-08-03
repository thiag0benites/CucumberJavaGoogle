package config.com.br;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {
	
	@Before
	public void ConfiguracaoInicial(Scenario scenario) {
		//this.scenario = scenario;
		
		System.out.println("*** Iniciando Teste ***");
		System.out.println("Executando cenario " + scenario.getName());
	}
	
	@After
	public void FecharJanela() {
		System.out.println("*** Fim dos testes ***");	
	}
}
