package parser;

public class Lexer {

	private String input;
	private int index;

	public void setInputString(String s) {
		input = s;
		input += '$';
		index = 0;
	}

	public Token nextToken() {
		char nextChar = input.charAt(index);
		while (nextChar == ' ' || nextChar == '\t') {
			index++;
			nextChar = input.charAt(index);
		}


		if (nextChar == '-') {
			index++;
			return new Token(Terminals.minus, "-");

		} else if (nextChar == '+') {
			index++;
			return new Token(Terminals.plus, "+");

		} else if (nextChar == '*') {
			index++;
			return new Token(Terminals.star, "*");

		} else if (nextChar == '/') {
			index++;
			return new Token(Terminals.divide, "/");

		} else if (nextChar == '^') {
			index++;
			return new Token(Terminals.power, "^");

		} else if (nextChar == '(') {
			index++;
			return new Token(Terminals.lparen, "(");

		} else if (nextChar == ')') {
			index++;
			return new Token(Terminals.rparen, ")");

		} else if (nextChar == '$') {
			index++;
			return new Token(Terminals.EOF, "$");

		} else {

			String lexeme = getLongest(input.substring(index),
					"[0-9]+"); //?(.[0-9]+)");
			if (lexeme != null) {
				index += lexeme.length();
				return new Token(Terminals.number, lexeme);
			}

			lexeme = getLongest(input.substring(index), "[a-z]+");
			if (lexeme != null) {
				index +=  lexeme.length();
				if (lexeme.equals("sin")) {
					return new Token(Terminals.sin, "sin");

				} else if (lexeme.equals("cos")) {
					return new Token(Terminals.cos, "cos");

				}
				if (lexeme.equals("tan")) {
					return new Token(Terminals.tan, "tan");

				}
				if (lexeme.equals("abs")) {
					return new Token(Terminals.abs, "abs");

				}
				if (lexeme.equals("sqrt")) {
					return new Token(Terminals.sqrt, "sqrt");

				}
				if (lexeme.equals("e")) {
					return new Token(Terminals.number, lexeme);

				}
				if (lexeme.equals("pi")) {
					return new Token(Terminals.number, lexeme);

				} else {
					return new Token(Terminals.var, lexeme);

				}
			}

			return new Token(Terminals.error, lexeme);
		}

	}

	public String getLongest(String input, String regex) {
		int i = 1;
		while (input.substring(0, i).matches(regex)) {
			i++;
		}
		if (i == 1) {
			return null;
		} else {
			return input.substring(0, i - 1);
		}
	}

}
