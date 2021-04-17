package com.lti.JUnitExample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Example2.class, Example3.class, FirstExample.class })
public class AllTests {

}
