package com.PracticeTestNG;

import org.testng.annotations.Test;

public class Sample1 {
	
  @Test	(groups = {"smoke" , "regression"})
	public void Sampletest()
	{
		System.out.println("--Sample1--");
	}

}
