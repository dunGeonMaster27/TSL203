package Assignment;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class basicJUNit {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");

	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tear down");

	}

	@Test
	public void test() {
System.out.println("test");	}

}
