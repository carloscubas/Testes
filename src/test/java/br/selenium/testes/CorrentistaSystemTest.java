package br.selenium.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class CorrentistaSystemTest {
	
	private WebDriver driver;
	private CorrentistaPage correntistas;
	
	@Before
	public void inicializa(){
		
		System.setProperty("webdriver.chrome.driver", 
				"/Volumes/Arquivos/FIB/POS/workspace/Testes/drives/chromedriver");

		this.driver = new ChromeDriver();
		this.correntistas = new CorrentistaPage(driver);
	}
	
	@Test
    public void deveAdicionarUmCorrentista() {
		correntistas.visita();
		correntistas.novo().cadastra("Manoel da Silva", "manoel.silva@mailinator.com");
		assertTrue(correntistas.existeNaListagem("Manoel da Silva", "manoel.silva@mailinator.com"));
	}
	
	@After
	public void encerra(){
		driver.close();
	}
}