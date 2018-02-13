package br.selenium.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovaContaPage {
	
	private WebDriver driver;

	public NovaContaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preenche(String correntista, double valor, boolean eUmaContaPremiun){
		
        WebElement txtValor = driver.findElement(By.name("saldo"));
        
        txtValor.sendKeys(String.valueOf(valor));
        
        WebElement combo = driver.findElement(By.name("correntista"));
        
        Select cbCorrentista = new Select(combo);
        cbCorrentista.selectByVisibleText(correntista);
        
        if(eUmaContaPremiun){
        	
        	WebElement ckContaPremiun = driver.findElement(By.name("tipoConta"));
        	ckContaPremiun.click();
        	
        }

        txtValor.submit();
	}

}
