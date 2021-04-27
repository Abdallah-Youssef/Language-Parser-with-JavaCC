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
		try {
			g.CommandChain();
		} catch (ParseException e) {
			fail(e.getMessage());
		}
		
	}

}
