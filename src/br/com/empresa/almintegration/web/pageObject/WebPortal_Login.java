package br.com.empresa.almintegration.web.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.empresa.almintegration.web.WebTestCase;

public class WebPortal_Login extends WebTestCase {

	protected WebDriver driver;
	
	@FindBy(name="txtUsuario")
	private WebElement txtLogin;
	
	@FindBy(name="txtSenha")
	private WebElement txtSenha;
	
	@FindBy(name="txtDominio")
	private WebElement txtDominio;
	
	@FindBy(id="button2")
	private WebElement btnLogin;
	
	
	//------------------------- getter and setters -------------------------
	
	public WebElement getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(WebElement txtLogin) {
		this.txtLogin = txtLogin;
	}

	public WebElement getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(WebElement txtSenha) {
		this.txtSenha = txtSenha;
	}

	public WebElement getTxtDominio() {
		return txtDominio;
	}

	public void setTxtDominio(WebElement txtDominio) {
		this.txtDominio = txtDominio;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	
	public WebPortal_Login(WebDriver driver) {
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
	
	public void clickOnLoginButton() {
		btnLogin.click();
	}
	
	public void inserirValorUsuario(String usuario) {
		txtLogin.sendKeys(usuario);
	}
	
	public void inserirValorSenha(String senha) {
		txtSenha.sendKeys(senha);
	}
	
	public void inserirValorDominio(String dominio) {
		txtDominio.sendKeys(dominio);
	}

}
