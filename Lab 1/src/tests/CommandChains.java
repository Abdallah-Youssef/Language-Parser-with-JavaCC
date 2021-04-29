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

class CommandChains {

	@Test
	void test() {
		//StringReader in=new StringReader("if !(46 == 45) then a:=1; else a:=0;");
		StringReader in=new StringReader("a:=3;while !(a==0) do a:=(a-1);");
		Grammar g =new Grammar(in);
		
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("a",0);
			
		}};
		/**
		 * Two types of tests:
		 * 	1 - Syntax Error tests
		 *  2 - Execution test
		 *  	Visitor returns a map, check that each value in that map is correct
		 *  	e.g.: in the string above: a = 70, b = 23
		 */
		
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

}
