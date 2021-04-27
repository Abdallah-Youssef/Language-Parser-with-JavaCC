package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

import lab1.Grammar;
import lab1.ParseException;

class ArithmeticExpressions {

	@Test
	void test() {
		StringReader in=new StringReader("(13 - (45 + 6))");
		Grammar g =new Grammar(in);
		try {
			Integer res = g.AExp();
			assertEquals(-38, res);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

}
