package calculator;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;
import java.util.Stack;

abstract class Token
{
	protected String Name;
	
	protected Token()
	{
		Name = "UNDEFINED";
	}

	protected static List<Token> ParseEquation(String equation) throws ParserException
	{
		List<Token> tokens = new ArrayList<>();
		int openParen = 0;
		Token token;
		for (int i = 0; i < equation.length(); i++)
		{
			switch (equation.charAt(i))
			{
			case ' ':
			case '\t':
			case '\r':
			case '\f':
				break;
			case '(':
			    token = new Operator('(');
			    tokens.add(token);
			    openParen++;
			    break;
			case ')':
			    token = new Operator(')');
			    tokens.add(token);
			    openParen--;
			    break;
			case '+':
			case '-':
			case '*':
			case '×':
			case '/':
			case '%':
			case '√':
			case '÷':
			case '^':
			    token = new Operator(equation.charAt(i));
			    tokens.add(token);
			    break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '.':
			    StringBuilder number = new StringBuilder(Character.toString(equation.charAt(i)));
			    boolean decimalUsed = equation.charAt(i) == '.';
			    while (i + 1 < equation.length())
			    {
			        if (!(equation.charAt(i + 1) == '.' || Character.isDigit(equation.charAt(i + 1)))) break;
			        if (decimalUsed && equation.charAt(i + 1) == '.') throw new ParserException("Multiple Decimals where used");
			        i++;
			        number.append(equation.charAt(i));
			    }
			    token = new Operand(Double.parseDouble(number.toString()));
			    tokens.add(token);
			    break;
			default:
			    StringBuilder s = new StringBuilder();
			    int x = 0;
			    while (Character.isLetter(equation.charAt(i + x)))
			    {
			        s.append(equation.charAt(i + x));
			        if (i + x + 1 >= equation.length()) break;
			        x++;
			    }
			    switch (s.toString())
			    {
			        case "Root":
			            token = new Operator("Root");
			            tokens.add(token);
			            break;
                    case "ABS":
                        token = new Operator("ABS");
                        tokens.add(token);
                        break;
                    case "SIN":
                        token = new Operator("SIN");
                        tokens.add(token);
                        break;
			        default:
			            token = new Operand(s.toString());
			            tokens.add(token);
			            break;
			    }
			    i = i + s.length() - 1;
			    break;
			}
		}
		if (openParen != 0) throw new ParserException("PARENTHESIS NOT CLOSED");
		return tokens;
	}

    protected static List<Token> InfixToRPN(List<Token> tokens)
	{
        //Shunting yard Algorithm //Praise Dijkstra
        Stack<Operator> operatorStack = new Stack<>();
        List<Token> RPN = new ArrayList<>();
        for(Token token : tokens)
        {
            if (token instanceof Operand) RPN.add(token);
            else if (token.Name.equals("LPAREN")) operatorStack.push((Operator)token);
            else if (token.Name.equals("RPAREN"))
            {
                Operator top = operatorStack.peek();
                while (!(top.Name.equals("LPAREN")))
                {
                    RPN.add(operatorStack.pop());
                    top = operatorStack.peek();
                }
                operatorStack.pop();// Remove the LPAREN
            }
            else
            {
                Operator top;
                Operator curr = (Operator)token;
                if (operatorStack.isEmpty()) operatorStack.push(curr);
                else
                {
                    top = operatorStack.peek();
                    while (!(top.Name.equals("LPAREN")) && ((curr.Precedence <= top.Precedence) && curr.Associativity == 'L'))
                    {
                        RPN.add(operatorStack.pop());
                        if (operatorStack.isEmpty()) break;
                        top = operatorStack.peek();
                    }
                    operatorStack.push(curr);
                }
            }
        }
        while (!operatorStack.isEmpty()) RPN.add(operatorStack.pop());
        return RPN;
	}
    //NEED to transfer functionality
    protected static List<Token> RPNToInfix(List<Token> RPN)
	{
        for (int i = RPN.size() - 1; i >= 0; i--)
        {
            if (i >= RPN.size()) continue; //Prevents falling out of bounds
            Token op = RPN.get(i);
            if (!(op instanceof Operator)) continue;
            Token a = RPN.get(i - 2);
            if (a instanceof Operator) continue;
            Token b = RPN.get(i - 1);
            if (b instanceof Operator) continue;

            Token term = new Term(a, b, (Operator)op);

            RPN.remove(i);
            RPN.remove(i - 1);
            RPN.set(i - 2, term);
        }

        if (RPN.getFirst() instanceof Operand) return RPN;
        return ((Term)RPN.getFirst()).TermToList();
	}

    protected static class ParserException extends Exception
    {
		ParserException(String message) { super(message); }
	}
}

class Operand extends Token
{
    protected double Value;
    protected Operand(double num)
	{
	    Name = Double.toString(num);
	    Value = num;
	}
    protected Operand(String variable)
	{
	    Name = variable;
	    Value = Double.NaN;
	}
	Operand(Operand operand)
	{
	    this.Name = operand.Name;
	    this.Value = operand.Value;
	}
}

class Operator extends Token
{
	int Precedence = -1;
    char Associativity = 'N';
    char ShortName;

    Operator(Operator operator)
    {
        this.Name = operator.Name;
        this.Precedence = operator.Precedence;
        this.Associativity = operator.Associativity;
        this.ShortName = operator.ShortName;
    }

    Operator(char symbol)
    {
        switch (symbol)
        {
            case '+':
                Name = "ADD";
                ShortName = '+';
                Precedence = 2;
                Associativity = 'L';
                break;
            case '-':
                Name = "SUBTRACT";
                ShortName = '-';
                Precedence = 2;
                Associativity = 'L';
                break;
            case '*':
            case '×':
                Name = "MULTIPLY";
                ShortName = '*';
                Precedence = 3;
                Associativity = 'L';
                break;
            case '/':
            case '÷':
                Name = "DIVIDE";
                ShortName = '/';
                Precedence = 3;
                Associativity = 'L';
                break;
            case '%':
                Name = "MODULUS";
                ShortName = '%';
                Precedence = 3;
                Associativity = 'L';
                break;
            case '^':
                Name = "POWER";
                ShortName = '^';
                Precedence = 4;
                Associativity = 'R';
                break;
            case '√':
                Name = "ROOT";
                ShortName = '√';
                Precedence = 4;
                Associativity = 'L';
                break;
            case '(':
                Name = "LPAREN";
                ShortName = '(';
                break;
            case ')':
                Name = "RPAREN";
                ShortName = ')';
                break;
            case '=':
                Name = "EQUAL";
                ShortName = '=';
                break;
            default:
                Name = "ERROR";
                ShortName = 'E';
                break;
        }
    }

    Operator(String function)
    {
        function = function.toUpperCase();
        switch (function)
        {
            case "ROOT":
                Name = "ROOT";
                ShortName = '√';
                Precedence = 4;
                Associativity = 'L';
                break;
            case "ABS":
                Name = "ABS";
                break;
            default:
                Name = "ERROR";
                ShortName = 'E';
                break;
        }
    }
}

class Term extends Token
{
	Token Left;
    Token Right;
    Operator Op;

    public Term(Term other) {
        // Deep copy of Left (can be either Operand or another Term)
        if (other.Left instanceof Term) {
            this.Left = new Term((Term) other.Left);  // Recursively copy the Term
        } else if (other.Left instanceof Operand) {
            this.Left = new Operand((Operand) other.Left);  // Copy the Operand
        } else {
            this.Left = null;  // Handle null case if necessary
        }

        // Deep copy of Right (can be either Operand or another Term)
        if (other.Right instanceof Term) {
            this.Right = new Term((Term) other.Right);  // Recursively copy the Term
        } else if (other.Right instanceof Operand) {
            this.Right = new Operand((Operand) other.Right);  // Copy the Operand
        } else {
            this.Right = null;  // Handle null case if necessary
        }

        // Deep copy of Op (assuming Operator has a copy constructor)
        this.Op = other.Op != null ? new Operator(other.Op) : null;
    }

    Term(Token Left, Token Right, Operator Op)
    {
        StringBuilder name = new StringBuilder();

        if (Left instanceof Term) name.append("(").append(Left.Name).append(")");
        else name.append(Left.Name);
        name.append(Op.Name);
        if (Right instanceof Term) name.append("(").append(Right.Name).append(")");
        else name.append(Right.Name);

        this.Name = String.valueOf(name);
        this.Left = Left;
        this.Right = Right;
        this.Op = Op;
    }

    List<Token> TermToList()
    {
        List<Token> tokens = new ArrayList<>();
        if (Left instanceof Operand) tokens.add(Left);
        else if (Left instanceof Term)
        {
            tokens.add(new Operator('('));
            tokens.addAll(TermToList((Term)Left));
            tokens.add(new Operator(')'));
        }
        else throw new IllegalArgumentException("MISPLACED OPERATOR");

        tokens.add(Op);

        if (Right instanceof Operand) tokens.add(Right);
        else if (Right instanceof Term)
        {
            tokens.add(new Operator('('));
            tokens.addAll(TermToList((Term)Right));
            tokens.add(new Operator(')'));
        }
        else throw new IllegalArgumentException("MISPLACED OPERATOR");

        return tokens;
    }
    private List<Token> TermToList(Term curr)
    {
        List<Token> tokens = new ArrayList<>();

        if (curr.Left instanceof Operand) tokens.add(curr.Left);
        else if (curr.Left instanceof Term)
        {
            tokens.add(new Operator('('));
            tokens.addAll(TermToList((Term)curr.Left));
            tokens.add(new Operator(')'));
        }
        else throw new IllegalArgumentException("MISPLACED OPERATOR");

        tokens.add(curr.Op);

        if (curr.Right instanceof Operand) tokens.add(curr.Right);
        else if (curr.Right instanceof Term)
        {
            tokens.add(new Operator('('));
            tokens.addAll(TermToList((Term)curr.Right));
            tokens.add(new Operator(')'));
        }
        else throw new IllegalArgumentException("MISPLACED OPERATOR");

        return tokens;
    }

}