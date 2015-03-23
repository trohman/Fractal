package parser;

public class Token {
	private Terminals type;
	private String value;
	
	public Token(Terminals tp, String val){
		type = tp;
		value = val;
	}
	
	public Terminals getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

}
