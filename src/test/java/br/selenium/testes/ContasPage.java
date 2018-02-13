package br.selenium.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContasPage {
	
	private WebDriver driver;

	public ContasPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
        driver.get("http://localhost:8080/conta/lista");
    }
	
	public NovaContaPage novo() {
        // clica no link de novo conta
        driver.findElement(By.linkText("Add Contas")).click();
        // retorna a classe que representa a nova pagina
        return new NovaContaPage(driver);
    }
	
	
	public boolean existe(double valor, String correntista,
            boolean eUmaContaPremiun) {

        return driver.getPageSource().contains(correntista) && 
                driver.getPageSource().contains(String.valueOf(valor)) &&
                driver.getPageSource().contains(eUmaContaPremiun ? "PREMIUN" : "BÁSICA");
    }
}