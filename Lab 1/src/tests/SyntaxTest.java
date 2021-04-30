package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import org.junit.jupiter.api.Test;

import lab1.Grammar;
import lab1.ParseException;
import lab1.SimpleNode;
import semantic.Visitor;
import lab1.TokenMgrError;

class SyntaxTest {

	@Test
	void test() {
		StringReader in=new StringReader("a:= 0;if (a==0) then a:=1; else a:=2;");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("a", 1);
		}};
		
		try {
			SimpleNode root = g.Start();
			root.dump("");
			HashMap<String, Integer> output = (HashMap<String, Integer>) root.jjtAccept(new Visitor(), null);
			Iterator<Entry<String, Integer>> it = output.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<String, Integer> pair = it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        
		        Integer correct = map_correct.get(pair.getKey());
		        
		        assertEquals(correct, pair.getValue());
		        
		    }
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	void test0() {
		
		StringReader in=new StringReader("a==5;");
		Grammar g =new Grammar(in);
		assertThrows(ParseException.class, ()->g.Start());
		
	}
	
	@Test
	void test1() {
		
		StringReader in=new StringReader("c:= (5 == 5);");
		Grammar g =new Grammar(in);
		assertThrows(ParseException.class, ()->g.Start());
		
	}
	
	@Test
	void test2() {
		
		StringReader in=new StringReader("c:= )5 - 5(");
		Grammar g =new Grammar(in);
		assertThrows(ParseException.class, ()->g.Start());
		
	}
	
	@Test
	void test3() {
		
		StringReader in=new StringReader("a:=5, b:= 30, c:= (a + b);");
		Grammar g =new Grammar(in);
		assertThrows(TokenMgrError.class, ()->g.Start());
		
	}
	@Test
	void test4() {
		
		StringReader in=new StringReader("if TT then e:=10; else e:=15;");
		Grammar g =new Grammar(in);
		assertThrows(TokenMgrError.class, ()->g.Start());
		
	}
	

	@Test
	void test5() {
		
		StringReader in=new StringReader("if (0 == 0)! then a:=10; else a:=15;");
		Grammar g =new Grammar(in);
		assertThrows(ParseException.class, ()->g.Start());
		
	}
	
	@Test
	void test6() {
		
		StringReader in=new StringReader("a:=3; whle!(a==0) do a:= (a-1);");
		Grammar g =new Grammar(in);
		assertThrows(TokenMgrError.class, ()->g.Start());
		
	}
	
}
