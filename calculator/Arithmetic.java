package calculator;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Arithmetic 
{
	private record returnValue(double result, List<String> subHistory) { }

	public static boolean IsValid(String equation)
	{
		try
		{
			Token.ParseEquation(equation);
		}
		catch (Token.ParserException e)
		{
			return false;
		}
		return true;
	}

	public static double Solve(String equation) throws Token.ParserException
	{
		return (BaseSolve(Token.ParseEquation(equation), false)).result;
	}

	public static double Solve(String equation, boolean getHistory) throws Token.ParserException
	{
		return BaseSolve(Token.ParseEquation(equation), getHistory).result;
	}

	static Operand Solve(List<Token> equation) {
        return new Operand(BaseSolve(equation, false).result);
    }

	private static returnValue BaseSolve(List<Token> equation, boolean getHistory)
	{
		List<String> recentSolveHistory = new ArrayList<>();

		List<Token> RPN = Token.InfixToRPN(equation);
		Stack<Token> stack = new Stack<>();
		if (getHistory) recentSolveHistory.add(WriteStep(stack, RPN));
		for (Token token : RPN)
		{
		    if (token instanceof Operand)
		    {
		        stack.push(token);
		        continue;
		    }
		    Operator op = (Operator)token;
		    Operand b = (Operand)stack.pop();
		    Operand a = (Operand)stack.pop();
		    stack.push(Function.SmartSolve(a, b, op));
			if (getHistory) recentSolveHistory.add(WriteStep(stack, RPN));
		}
		Operand result = (Operand)stack.pop();
		return new returnValue(result.Value, recentSolveHistory);
	}

	private static String WriteStep(Stack<Token> ogStack, List<Token> ogRPN)
	{
		Stack<Token> stack = new Stack<>();
		for (Token token : ogStack)
		{
			if (token instanceof Operand)
			{
				stack.push(new Operand((Operand)token));
			}
			else if (token instanceof Operator)
			{
				stack.push(new Operator((Operator)token));
			}
			else if (token instanceof Term)
			{
				stack.push(new Term((Term)token));
			}
			  // Assuming Token has a copy constructor
		}

		List<Token> RPN = new ArrayList<>();
		for (Token token : ogRPN)
		{
			if (token instanceof Operand)
			{
				RPN.add(new Operand((Operand)token));
			}
			else if (token instanceof Operator)
			{
				RPN.add(new Operator((Operator)token));
			}
			else if (token instanceof Term)
			{
				RPN.add(new Term((Term)token));
			}
		}

		while (!stack.empty()) RPN.addFirst(stack.pop());
		List<Token> Infix = Token.RPNToInfix(RPN);
		StringBuilder result = new StringBuilder();
		for(Token token : Infix)
		{
			if (token instanceof Operator) result.append(((Operator)token).ShortName);
			else result.append(token.Name);
		}
		return result.toString();
	}
}
