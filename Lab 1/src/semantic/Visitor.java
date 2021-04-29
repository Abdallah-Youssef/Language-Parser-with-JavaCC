package semantic;

import lab1.*;

public class Visitor implements GrammarVisitor {
	SymbolTable st = new SymbolTable();
	
	private boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	@Override
	public Object visit(SimpleNode node, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(ASTAExp node, Object data) {
		String value = (String)node.jjtGetValue();
		
		if (value.equals("+")) {
			return (Integer) node.jjtGetChild(0).jjtAccept(this, data) +
				   (Integer) node.jjtGetChild(1).jjtAccept(this, data);
		}else if (value.equals("-")) {
			return (Integer) node.jjtGetChild(0).jjtAccept(this, data) -
				   (Integer) node.jjtGetChild(1).jjtAccept(this, data);
		}
		
		if (isNumeric(value)) {
			return Integer.parseInt(value);
		}else {
			try {
				return st.get(value);
			} catch (ParseException e) {
				System.out.println(value + " is not defined");
				return Integer.MIN_VALUE;
			}
		}
		
		
	}

	@Override
	public Boolean visit(ASTBExp node, Object data) {
		String value = (String)node.jjtGetValue();
		
		if (value.equals("!")) {
			return !(Boolean) node.jjtGetChild(0).jjtAccept(this, data);
		}
		else if (value.equals("==")) {
			return (Integer)node.jjtGetChild(0).jjtAccept(this, data) ==
				   (Integer)node.jjtGetChild(1).jjtAccept(this, data);
		}else if (value.equals("^")) {
			return (Boolean)node.jjtGetChild(0).jjtAccept(this, data) ^
				   (Boolean)node.jjtGetChild(1).jjtAccept(this, data);
		}else {
			return value.equals("tt");
		}
	}

	@Override
	public Object visit(ASTCommand node, Object data) {
		String value = (String)node.jjtGetValue();
		
		if (value.equals("if")) {
			Boolean condition = (Boolean) node.jjtGetChild(0).jjtAccept(this, data);
			
			if (condition) {
				node.jjtGetChild(1).jjtAccept(this, data);
			}else {
				node.jjtGetChild(2).jjtAccept(this, data);
			}
			
			
		}
		else if (value.equals("while")) {
			while ((Boolean) node.jjtGetChild(0).jjtAccept(this, data)) {
				node.jjtGetChild(1).jjtAccept(this, data);
			}
			
			
		}else {
			st.set(value, (Integer)node.jjtGetChild(0).jjtAccept(this, data));
		}
		
		return null;
	}

	@Override
	public Object visit(ASTCommandChain node, Object data) {
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(ASTStart node, Object data) {
		node.childrenAccept(this, data);
		
		st.printMap();
		return st.map;
	}


}
