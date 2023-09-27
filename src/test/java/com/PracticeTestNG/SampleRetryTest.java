package com.PracticeTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebDriverUtils.BaseClass;

public class SampleRetryTest extends BaseClass {

	
	@Test(retryAnalyzer = com.WebDriverUtils.RetryImpl.class)
	public void retrytest()
	{
		Assert.assertEquals("A", "B");
	}
}
