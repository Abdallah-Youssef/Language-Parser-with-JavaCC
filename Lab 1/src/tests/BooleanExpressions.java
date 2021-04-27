package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

import lab1.Grammar;
import lab1.ParseException;

class BooleanExpressions {

	@Test
	void test() {
		StringReader in=new StringReader("(tt ^ !(45 == 6))");
		Grammar g =new Grammar(in);
		try {
			Boolean res = g.BExp();
			assertEquals(true, res);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

}
