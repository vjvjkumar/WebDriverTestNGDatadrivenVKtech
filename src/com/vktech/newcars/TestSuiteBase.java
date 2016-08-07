package com.vktech.newcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import com.vktech.base.TestBase;
import com.vktech.util.TestUtil;


public class TestSuiteBase extends TestBase {
	
	@BeforeSuite
	public void checkSuiteSkip() throws Exception{
		Initialize();
		if(!TestUtil.isSuiteRunnable(Suitexls, "newcars")){
		throw new SkipException("Runmode of the newcars suite is set as NO, so skipping the newcars suite");
		// doubt: is newcars suite is set as NO??	
		}
		}
}	
	
	
	


