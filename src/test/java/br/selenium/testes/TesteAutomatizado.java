package br.selenium.testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Volumes/Arquivos/FIB/POS/workspace/Testes/drives/chromedriver");


		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com.br"); 
		
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("brasil");
		
		campoDeTexto.submit();
	}
}