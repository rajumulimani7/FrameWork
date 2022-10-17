package pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "dataProvider_test" )
	public void bookTicket(String src,String drc) {
		System.out.println("book titckets from "+src+" to "+drc+"");
		
	}
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Bangalore";
		objArr[0][1]="goa";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="mysore";
		
		objArr[2][0]="Bangalore";
		objArr[2][1]="maglore";
		
		objArr[3][0]="Bangalore";
		objArr[3][1]="mubai";
		
		objArr[4][0]="Bangalore";
		objArr[4][1]="keral";
		
		return objArr;
		
	}

}
