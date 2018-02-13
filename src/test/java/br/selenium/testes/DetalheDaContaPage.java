package br.selenium.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalheDaContaPage {

	private WebDriver driver;

	public DetalheDaContaPage(WebDriver driver) {
		this.driver = driver;
	}

	public void movimento(String tipo, double valor, String descricao) {
		WebElement txtValor = driver.findElement(By.name("valor"));
		WebElement txtDescricao = driver.findElement(By.name("descricao"));

		WebElement combo = driver.findElement(By.name("tipo"));
		Select cbTipo = new Select(combo);

		cbTipo.selectByVisibleText(tipo);
		txtValor.sendKeys(String.valueOf(valor));
		txtDescricao.sendKeys(descricao);

		driver.findElement(By.id("button1")).click();
	}

	public boolean existeHistorico(String tipo, double valor, String descricao) {

		Boolean temDescricao = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.textToBePresentInElement(By.id("listatabela"), descricao));

		if (temDescricao) {
			return driver.getPageSource().contains(String.valueOf(valor))
					&& driver.getPageSource().contains(String.valueOf(tipo));
		} else {
			return false;
		}

	}
}