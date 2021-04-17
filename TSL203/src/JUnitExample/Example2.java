package JUnitExample;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Example2 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("In Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("In After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("In Before Method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("In After Method");
	}

	@Test
	public void test1() {
		System.out.println("In Test1");
	}


	@Test
	public void test2() {
		System.out.println("In Test2");
	}
}
