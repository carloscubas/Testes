package br.selenium.testes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public DetalheDaContaPage historico(int posicao) {
        List<WebElement> elementos = driver.findElements(By.linkText("Históricos"));
        elementos.get(posicao - 1).click();

        return new DetalheDaContaPage(driver);
    }
}