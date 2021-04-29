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

class EvaluatingTest {

	@Test
	void assignment0() {
		
		StringReader in=new StringReader("a:=5;");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("a",5);
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
	
	@Test
	void assignment1() {
		
		StringReader in=new StringReader("c:= (13 + 5);");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("c", 18);
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
	
	@Test
	void assignment2() {
		
		StringReader in=new StringReader("f:= (366 - 66);");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("f", 300);
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

	
	@Test
	void assignment3() {
		
		StringReader in=new StringReader("a:=5; b:= 30; c:= (a + b);");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("a",5);
			put("b", 30);
			put("c", 35);
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
	
	@Test
	void assignment4() {
		
		StringReader in=new StringReader("e:=11; d:= 0; f:= (e - d);");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("e",11);
			put("d", 0);
			put("f", 11);
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
	
	@Test
	void IF_True() {
		
		StringReader in=new StringReader("if tt then e:=10; else e:=15;");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("e", 10);
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
	
	@Test
	void IF_False() {
		
		StringReader in=new StringReader("if ff then e:=10; else e:=15;");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("e", 15);
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
	
	@Test
	void IF1() {
		
		StringReader in=new StringReader("if (4 == 4) then a:=10; else a:=15;");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("a", 10);
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
	
	@Test
	void IF2() {
		
		StringReader in=new StringReader("if !(0 == 0) then a:=10; else a:=15;");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("a", 15);
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
	
	@Test
	void IF3() {
		
		StringReader in=new StringReader(
				"b := 2; c:= 4; if ( tt ^ (3 == 3)) then f:=(c + b); else f:=(c - b);");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("b", 2);
			put("c", 4);
			put("f", 2);
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
	
	@Test
	void While1() {
		
		StringReader in=new StringReader("a:=0; while!(a==3) do a:=(a+1);");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("a", 3);
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
	
	@Test
	void While2() {
		
		StringReader in=new StringReader("a:=3; while!(a==0) do a:= (a-1);");
		Grammar g =new Grammar(in);
		
		HashMap<String, Integer> map_correct = new HashMap<>(){{
			put("a", 0);
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
