package br.com.empresa.almintegration.suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.empresa.almintegration.web.WebTestExample;

@RunWith(Suite.class)
@Suite.SuiteClasses({ WebTestExample.class })
public class SuitWeb {

}
