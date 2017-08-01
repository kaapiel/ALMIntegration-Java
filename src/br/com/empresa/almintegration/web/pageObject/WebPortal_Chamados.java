package br.com.empresa.almintegration.web.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.empresa.almintegration.web.WebTestCase;

public class WebPortal_Chamados extends WebTestCase {

	protected WebDriver driver;
	
	@FindBy(id="grdItens")
	private WebElement gradeItens;
	
	//------------------------- getter and setters -------------------------
	
	public WebElement getGradeItens() {
		return gradeItens;
	}

	public void setGradeItens(WebElement gradeItens) {
		this.gradeItens = gradeItens;
	}
	
	//Gerar logica (METODO) para obter os valores dos indices da tabela
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	
	public WebPortal_Chamados(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open(String url) {
		driver.get(url);
	}
	
	public void close() {
		driver.quit();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
}
