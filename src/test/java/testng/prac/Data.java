package testng.prac;

import org.testng.annotations.DataProvider;

public class Data {
	
	@DataProvider(name="inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"bmw", "m3"},
			{"audi", "a6"},
			{"benz", "c300"}
		};
	}
}