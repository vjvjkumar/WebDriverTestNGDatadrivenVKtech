package com.vktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import com.vktech.base.TestBase;
import com.vktech.util.TestUtil;

public class TestSuiteBase extends TestBase {
	
	@BeforeSuite
	public void checkSuiteSkip() throws Exception{
		Initialize();
		if(!TestUtil.isSuiteRunnable(Suitexls, "usedcars")){
		throw new SkipException("Runmode of usedcars suite is set as NO, so skipping runmode of usedcars suite");	
		}
		
	}
	

}
