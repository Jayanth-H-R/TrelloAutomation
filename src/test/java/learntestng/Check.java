package learntestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Check {
	
   @Test
	public void test1() {
		System.out.println("Test annotated method 1");

	}
   @Test
  	public void test2() {
  		System.out.println("Test annotated method 2");

  	}
   
   @BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest executed");

	}
   @BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite executed");

	}
   
   @AfterTest
	public void afterTest() {
		System.out.println("afterTest executed");

	}
   
   @BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass executed");

	}
   
   @BeforeMethod
   public void beforeMethod() {
		System.out.println("beforeMethod executed");

	}
   @AfterMethod
   public void afterMethod() {
		System.out.println("afterMethod executed");

	}
   @AfterClass
  	public void afterClass() {
  		System.out.println("afterClass executed");

  	}
   @AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite executed");

	}
   
   
}


