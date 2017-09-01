package br.com.empresa.almintegration.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.empresa.almintegration.execution.CustomerTestCase;
import br.com.empresa.almintegration.helper.Utils;
import br.com.empresa.almintegration.testing.web.pageObject.WebPageExample;

public class SPRINTxx_ESTORIAxxxx_CT001 extends CustomerTestCase {
	
	private WebPageExample webPageExample;
	private WebDriver driver;

	@Before
	public void beforeTest() throws Exception{
		driver = Utils.initializeChromeDriver();
		driver.manage().window().maximize();
		webPageExample = PageFactory.initElements(driver, WebPageExample.class);
	}
	
	@Test
	public void testExample(){
		webPageExample.getDriver().get("http://www.google.com.br");
		webPageExample.clickOnSearchField();
		webPageExample.insertValueOnSearchField("Teste de pesquisa");
	}

	@After
	public void afterTest(){
		driver.close();
	}
	
}
