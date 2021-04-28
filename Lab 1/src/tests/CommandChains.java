package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

import lab1.Grammar;
import lab1.ParseException;

class CommandChains {

	@Test
	void test() {
		StringReader in=new StringReader("a := 45;b := 23;a := ((b+a) + (5 - 3)  );");
		Grammar g =new Grammar(in);
		
		
		/**
		 * Two types of tests:
		 * 	1 - Syntax Error tests
		 *  2 - Execution test
		 *  	Visitor returns a map, check that each value in that map is correct
		 *  	e.g.: in the string above: a = 70, b = 23
		 */
		
		try {
			g.CommandChain();
		} catch (ParseException e) {
			fail(e.getMessage());
		}
		
	}

}
