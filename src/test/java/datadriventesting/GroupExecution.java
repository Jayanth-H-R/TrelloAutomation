package datadriventesting;

import org.testng.annotations.Test;

public class GroupExecution {
	@Test(groups = {"FT"})
	public void testcase1() {
		System.out.println("TestCase1 executed");
	}
	
	@Test(groups = {"FT","IT"})
	public void testcase2() {
		System.out.println("TestCase2 executed");
	}
	
	@Test(groups = {"ST","IT"})
	public void testcase3() {
		System.out.println("TestCase3 executed");
	}
	
	@Test(groups = {"IT"})
	public void testcase4() {
		System.out.println("TestCase4 executed");
	}
	
	@Test(groups = {"ST"})
	public void testcase5() {
		System.out.println("TestCase5 executed");
	}

}
