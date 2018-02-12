package br.selenium.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CorrentistaPage {

	private WebDriver driver;

	public CorrentistaPage(WebDriver driver) {
		this.driver = driver;
    }

	public void visita() {
		driver.get("http://localhost:8080/correntista/lista");
	}

	public NovoCorrentistaPage novo() {
        // clica no link de novo usuario
        driver.findElement(By.linkText("Add Correntista")).click();
        // retorna a classe que representa a nova pagina
        return new NovoCorrentistaPage(driver);
    }

	public boolean existeNaListagem(String nome, String email) {
		// verifica se ambos existem na listagem
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email);
	}
	

}