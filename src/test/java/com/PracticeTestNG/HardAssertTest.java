package com.PracticeTestNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertTest {
	
	@Test
	public void Hardasserttest()
	{
		System.out.println("--step 1--");
		System.out.println("--step 2--");
		assertEquals("A", "B");
		System.out.println("--step 3--");
		System.out.println("--step 4--");		
	}

	@Test
	public void Hardasserttest2()
	{
		System.out.println("--step 5--");
		System.out.println("--step 6--");
		assertNotEquals("A", "A");
		System.out.println("--step 7--");
		System.out.println("--step 8--");
	}
	
	@Test
	public void Hardasserttest3()
	{
		int m=5;
		assertNull(m);
		System.out.println("--step 9--");
	}
	
	@Test
	public void Hardasserttest4()
	{
		int n=5;
		assertNotNull(n);
		System.out.println("--step 10--");
	}
	
	
	
	
	
	
}
