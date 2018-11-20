package testng.prac;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestNG_DataProviders {

	@DataProvider(name="local_inputs", parallel = true)
	public Object[][] getData() {
		return new Object[][] {
				{"bmw", "m3"},
				{"audi", "a6"},
				{"benz", "c300"}
		};
	}

	@Test(dataProvider="local_inputs")
	public void testLocallyParametrizedMethod(String input1, String input2) {
		System.out.println("Input 1: " + input1 + "\tInput 2: " + input2);
	}

	@Test(dataProvider = "inputs", dataProviderClass = Data.class)
	public void testParametrizedMethod(String input1, String input2) {
		System.out.println("Input 1: " + input1 + "\tInput 2: " + input2);
	}

	@Test
	public void testBro(){
		System.out.println("testBro: ");
	}
}