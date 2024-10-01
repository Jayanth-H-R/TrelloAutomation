package datadriventesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

	// this is the class which is used to store data

	@DataProvider
	public Object dataContainer() {
		Object[][] data = new Object[2][3];
		data[0][0] = "bengaluru";
		data[0][1] = "Mysuru";
		data[0][2] = "5";

		data[1][0] = "Mangaluru";
		data[1][1] = "shivamogga";
		data[1][2] = "3";

		return data;

	}

	

	// this is the testcase
	@Test(dataProvider = "dataContainer")
	public void testCase(String fromAdd, String toAdd, String noOfTicket) {
		System.out.println("fromAdd > " + fromAdd + " toAdd > " + toAdd + " noOfTicket >" + noOfTicket);

	}

}
