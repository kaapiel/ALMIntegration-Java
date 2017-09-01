package br.com.empresa.almintegration.suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.empresa.almintegration.webservices.WebServiceTestExample;

@RunWith(Suite.class)
@Suite.SuiteClasses({ WebServiceTestExample.class })
public class SuitWebService {

}
