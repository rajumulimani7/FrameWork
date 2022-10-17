package com.crm.Generic_Utilities;

import java.util.Random;



public class Java_Utility {
	/**
	 * @author raju
	 * @return RanNum
	 */
	
	public int getRanDomNum()
	{
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
	}

}
