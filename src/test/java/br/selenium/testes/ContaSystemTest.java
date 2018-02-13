package br.selenium.testes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContaSystemTest {
	
	private WebDriver driver;
	private ContasPage contas;
	
	@Before
	public void inicializa(){
		
		System.setProperty("webdriver.chrome.driver", 
				"/Volumes/Arquivos/FIB/POS/workspace/Testes/drives/chromedriver");
		
		this.driver = new ChromeDriver();
		this.contas = new ContasPage(driver);
		
		// limpa a base de dados
		driver.get("http://localhost:8080/reset");
		
		CorrentistaPage correntista = new CorrentistaPage(driver);
		correntista.visita();
		correntista.novo().cadastra("Bill Gates", "billgates@microssoft.com");
	}
	
	@Test
	public void deveCadastrarUmaConta(){
		
		contas.visita();
		
		NovaContaPage novaConta = contas.novo();
		
		novaConta.preenche("Bill Gates", 3000, true);
		
		assertTrue(contas.existe(3000, "Bill Gates", true));
		
	}
	
	@Test
	public void deveCadastrarUmMovimento(){
	
		contas.visita();
		NovaContaPage novaConta = contas.novo();
		novaConta.preenche("Bill Gates", 3000, true);
		
		DetalheDaContaPage historicos = contas.historico(1);
		historicos.movimento("Crédito", 3000.0, "Viagem");
		assertTrue(historicos.existeHistorico("Crédito", 3000.0, "Viagem"));
	}
	
	@After
	public void encerra(){
		driver.close();
	}

}