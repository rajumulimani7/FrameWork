package pratice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void createCustomerTest()
	{
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals("A","B");
		System.out.println("step3");
		System.out.println("step4");
	}
	@Test
	public void modifiyCustomerTest()
	{
	System.out.println("-------------------");	
	System.out.println("step1");
	System.out.println("step2");
	System.out.println("step3");
	}

}
