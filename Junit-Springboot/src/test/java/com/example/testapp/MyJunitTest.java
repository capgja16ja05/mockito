package com.example.testapp;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testapp.model.Product;

@SpringBootTest
public class MyJunitTest {
	
	static Dump dump;
	static Product p1;
	
	@BeforeAll
	public static void init()
	{
		dump = new Dump();
		p1 = new Product(101,"HP-123",2000,-1,"Laptop");
	}
	
	
	@Test
	@Disabled
	@DisplayName("Test to do abc method, passing arg x and y")	
	public void doTesting()
	{
		Dump dump = new Dump();
		String inputStr = "this is the long string ";
		
		boolean result = dump.calculateIsLongString(inputStr);
		
		// match the result with expected result
		// Junit provides assertXYZ()
		
		//assertEquals(true,result);
		assertTrue("This String is not long",inputStr.length()>10);
	}
	
	
	
	@Test
	@Disabled
	public void doCheckAssertEquals()
	{
		Product input = new Product(101,"HP-123",2000,4,"Laptop"); // input 
		Product expectedProduct = new Product(101,"HP-123",3000,4,"Laptop"); // output
		Product p3 = new Product(102,"HP-125",2000,4,"Laptop");

		Dump dump = new Dump();
		
		// matches on the basis of equals and hashcode
		assertEquals(expectedProduct, dump.doProductThings(input));	
		
		 
		
	}
	
	@Test
	@Disabled
	public void doCheckAssertSame()
	{
		Product input = new Product(101,"HP-123",2000,4,"Laptop"); // input 
		Product expectedProduct = new Product(101,"HP-123",3000,4,"Laptop"); // output
		Product p3 = new Product(102,"HP-125",2000,4,"Laptop");

		Dump dump = new Dump();
		
		// matches on the basis of == 
		//assertSame(input, expectedProduct);
		assertNotSame(input, expectedProduct);
	}
	
	
	
	@Test
	@Disabled
	public void doCheckAssertArrays()
	{
		
		int input[] = {1,2,3};
		
		// after calling business method
		
		int expected[] = {1,2,3};
		assertArrayEquals(expected, new int[] {1,2,3});
	}
	
	
	@Test
	@Disabled
	public void doCheckAssertCollectionList()
	{
		Dump dump = new Dump();
		List<Product> actualList = dump.getProducts(); // what returns from Service layer
		
		Product p1 = new Product(101,"HP-123",2000,4,"Laptop");
		Product p2 = new Product(102,"HP-123",2000,4,"Laptop");
		Product p3 = new Product(104,"HP-123",2000,4,"Laptop");
		
		List<Product> expectedList = new ArrayList<>(Arrays.asList(p1,p2,p3));
		
		assertIterableEquals(expectedList, actualList);
		
		
	}
	
	@Test
	//@Disabled
	public void doCheckAssertThrows()
	{
		assertThrows(NullPointerException.class, ()->{
			dump.doProductThings(p1);
		});
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//end class
