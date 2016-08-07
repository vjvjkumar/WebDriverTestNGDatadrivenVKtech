package com.vktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import com.vktech.base.TestBase;
import com.vktech.util.TestUtil;


public class TestSuiteBase extends TestBase {
		
	@BeforeSuite
	public void checkSuiteSkip() throws Exception{
		Initialize();
		if(!TestUtil.isSuiteRunnable(Suitexls, "sellcars")){
		throw new SkipException("Runmode of the sellcars suite is set as NO, so skipping the sellcars suite");
		}
		}
}