package br.com.empresa.almintegration.testing.web.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.empresa.almintegration.testing.web.WebTestCase;

public class WebPortal_PesquisaChamados extends WebTestCase {

	protected WebDriver driver;
	
	@FindBy(name="NChamado")
	private WebElement txtNumChamado;
	
	@FindBy(name="NChamadoEDS")
	private WebElement txtNumChamadoEDS;
	
	@FindBy(name="NLogico")
	private WebElement txtNumLogico;
	
	@FindBy(name="Maquineta")
	private WebElement txtNumMaquineta;
	
	@FindBy(id="btnOk")
	private WebElement btnOk;
	
	//------------------------- getter and setters -------------------------
	
	public WebElement getTxtNumChamado() {
		return txtNumChamado;
	}

	public void setTxtNumChamado(WebElement txtNumChamado) {
		this.txtNumChamado = txtNumChamado;
	}

	public WebElement getTxtNumChamadoEDS() {
		return txtNumChamadoEDS;
	}

	public void setTxtNumChamadoEDS(WebElement txtNumChamadoEDS) {
		this.txtNumChamadoEDS = txtNumChamadoEDS;
	}

	public WebElement getTxtNumLogico() {
		return txtNumLogico;
	}

	public void setTxtNumLogico(WebElement txtNumLogico) {
		this.txtNumLogico = txtNumLogico;
	}

	public WebElement getTxtNumMaquineta() {
		return txtNumMaquineta;
	}

	public void setTxtNumMaquineta(WebElement txtNumMaquineta) {
		this.txtNumMaquineta = txtNumMaquineta;
	}

	public WebElement getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(WebElement btnOk) {
		this.btnOk = btnOk;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	
	public WebPortal_PesquisaChamados(WebDriver driver) {
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
	
	public void clickOnOkButton() {
		btnOk.click();
	}
	
	public void inserirValorNumChamado(String numChamado) {
		txtNumChamado.sendKeys(numChamado);
	}
	
	public void inserirValorNumChamadoEDS(String numChamadoEDS) {
		txtNumChamadoEDS.sendKeys(numChamadoEDS);
	}
	
	public void inserirValorNumLogico(String numLogico) {
		txtNumLogico.sendKeys(numLogico);
	}
	
	public void inserirValorNumMaquineta(String numMaquineta) {
		txtNumMaquineta.sendKeys(numMaquineta);
	}

}
