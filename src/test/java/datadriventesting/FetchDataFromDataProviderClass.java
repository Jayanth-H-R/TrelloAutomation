package datadriventesting;

import org.testng.annotations.Test;

public class FetchDataFromDataProviderClass {
  
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "dataContainer")
	public void dtatDrivenTest(String fromAdd ,String toAdd,String noOfTickets) {
		
		System.out.println(" fromAdd > "+fromAdd+" toAdd > "+toAdd+" noOfTickets > "+noOfTickets);
		
	}
}
