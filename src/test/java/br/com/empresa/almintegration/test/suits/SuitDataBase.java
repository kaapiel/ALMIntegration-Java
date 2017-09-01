package br.com.empresa.almintegration.test.suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.empresa.almintegration.test.database.DataBaseTestExample;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DataBaseTestExample.class })
public class SuitDataBase {

}
