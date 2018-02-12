package br.selenium.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoCorrentistaPage {
	
	private WebDriver driver;

    public NovoCorrentistaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cadastra(String nome, String email) {
        WebElement txtNome = driver.findElement(By.name("nome"));
        WebElement txtEmail = driver.findElement(By.name("email"));

        txtNome.sendKeys(nome);
        txtEmail.sendKeys(email);

        txtNome.submit();

    }

}
