package com.example.testapp;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testapp.model.Product;

@SpringBootTest
public class MyMockitoTest {
	
	@Mock
	Dump dump;

	
	@Test
	public void doTesting()
	{
		/*
		Dump dump = new Dump();
		
		
		// when 
		boolean result = dump.calculateIsLongString(inputStr);
		//    then return
		
		//verify
		assertTrue("This String is not long",inputStr.length()>10);
	*/
		String inputStr = "this is the long string ";
		when(dump.calculateIsLongString(inputStr)).thenReturn(true);
		dump.calculateIsLongString(inputStr); // calling actual method to be test
		verify(dump).calculateIsLongString(inputStr); // to verify call the mock object method to be tested
		
		
	}
	
	
	
	

}//end class
