package br.com.empresa.almintegration.test.suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.empresa.almintegration.test.webservices.WebServiceTestExample;

@RunWith(Suite.class)
@Suite.SuiteClasses({ WebServiceTestExample.class })
public class SuitWebService {

}
