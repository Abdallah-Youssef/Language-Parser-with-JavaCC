package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import lab1.Grammar;
import lab1.ParseException;
import lab1.SimpleNode;
import semantic.Visitor;

public class Test {
	void IF4() {
		
		StringReader in=new StringReader("a:= 0;if (((a == 0) ^ (a == 0)) ^  ((a == 0) ^ (a == 0))) then a:=1; else a:=2;");
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
}
