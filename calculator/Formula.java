package calculator;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.lang.String;
import java.util.OptionalDouble;

public class Formula
{
	private static double StringToDouble(String s)
	{
		try
		{
			return Double.parseDouble(s);
		}
		catch (Exception e)
		{
			return Double.NaN;
		}
	}

	public static double Sum(double[] nums)
	{
		double sum = 0;
		for (double i : nums)
		{
			sum += i;
		}
		return sum;
	}
	static Operand Sum(Operand[] nums)
	{
		Operand sum = new Operand(0);
		for (Operand i : nums)
		{
			sum = new Operand(Function.Add(sum, i));
		}
		return sum;
	}
	public static double Sum(List<Object> nums)
	{
		double sum = 0;
		for (Object i : nums)
		{
			double x;
			if (i instanceof Operand) x = ((Operand) i).Value;
			else if (i instanceof Double) x = (double) i;
			else throw new UnsupportedOperationException();
			sum += x;
		}
		return sum;
	}

	public static double Mean(double[] nums)
	{
		double sum = Formula.Sum(nums);
		return sum / nums.length;
	}
	static Operand Mean(Operand[] nums)
	{
		Operand sum = Formula.Sum(nums);
		return new Operand(Function.Divide(sum, new Operand(nums.length)));
	}
	public static double Mean(List<Object> nums)
	{
		double sum = Formula.Sum(nums);
		return sum / nums.size();
	}

	public static class Geometry
	{
		private static double SolvePythagorean(double p1, double p2, char op)
		{
			Token[] equation =
					{
							new Operator("ROOT"), new Operator('('),
							new Operand(p1), new Operator('^'), new Operand(2),
							new Operator(op),
							new Operand(p2), new Operator('^'), new Operand(2),
							new Operator(')'), new Operand(2)
					};
			return Arithmetic.Solve(Arrays.asList(equation)).Value;
		}
		private static double PythagoreanAB(double a, double b) {
			return SolvePythagorean(a, b, '+');
		}
		private static double PythagoreanBC(double b, double c) {
			return SolvePythagorean(b, c, '-');
		}
		private static double PythagoreanAC(double a, double c)  {
			return SolvePythagorean(a, c, '-');
		}
		public static double Pythagorean(double a, double b, double c) {
			OptionalDouble OptionA = OptionalDouble.empty();
			OptionalDouble OptionB = OptionalDouble.empty();
			OptionalDouble OptionC = OptionalDouble.empty();
			if (!Double.isNaN(a))
			{
				OptionA = OptionalDouble.of(a);
			}
			if (!Double.isNaN(b))
			{
				OptionB = OptionalDouble.of(b);
			}
			if (!Double.isNaN(c))
			{
				OptionC = OptionalDouble.of(c);
			}

			if (OptionA.isPresent() && OptionB.isPresent() && OptionC.isEmpty())
			{
				return PythagoreanAB(OptionA.getAsDouble(), OptionB.getAsDouble());
			}
			else if (OptionA.isPresent() && OptionB.isEmpty() && OptionC.isPresent())
			{
				return PythagoreanAC(OptionA.getAsDouble(), OptionC.getAsDouble());
			}
			else if (OptionA.isEmpty() && OptionB.isPresent() && OptionC.isPresent())
			{
				return PythagoreanBC(OptionB.getAsDouble(), OptionC.getAsDouble());
			}
			else
			{
				throw new IllegalArgumentException("Both Parameters must be a number");
			}
		}
		public static String Pythagorean(String aS, String bS, String cS) {
			double a, b, c;
			a = StringToDouble(aS);
			b = StringToDouble(bS);
			c = StringToDouble(cS);
			return Double.toString(Pythagorean(a, b, c));
		}
		static Operand Pythagorean (Operand a, Operand b, Operand c) {
			return new Operand(Pythagorean(a.Value, b.Value, c.Value));
		}

		public static double Distance(Point p1, Point p2)
		{
			return p1.distance(p2);
		}

		public static double[] LawOfCosines(double a, double b, double c)
		{
			double[] interAngles = new double[3];
			Token[] equation =
					{
							new Operator('('),
							new Operand(b), new Operator('^'), new Operand(2),
							new Operator('+'),
							new Operand(c), new Operator('^'), new Operand(2),
							new Operator('-'),
							new Operand(a), new Operator('^'), new Operand(2),
							new Operator(')'),
							new Operator('/'),
							new Operator('('),
							new Operand(2), new Operator('*'), new Operand(b), new Operator('*'), new Operand(c),
							new Operator(')')
					};
			Operand result = Arithmetic.Solve(Arrays.asList(equation));
			interAngles[0] = result.Value;

			equation[1] = new Operand(c);
			equation[5] = new Operand(a);
			equation[9] = new Operand(b);
			equation[17] = new Operand(c);
			equation[19] = new Operand(a);
			result = Arithmetic.Solve(Arrays.asList(equation));
			interAngles[1] = result.Value;

			equation[1] = new Operand(a);
			equation[5] = new Operand(b);
			equation[9] = new Operand(c);
			equation[17] = new Operand(a);
			equation[19] = new Operand(b);
			result = Arithmetic.Solve(Arrays.asList(equation));
			interAngles[2] = result.Value;
			return interAngles;
		}

		public static double Heron(double a, double b, double c)
		{
			double s = (a + b + c) / 2.0;
			return Math.sqrt(s*(s-a)*(s-b)*(s-c));
		}

		public static double AreaOfTriangle(Point a, Point b, Point c)
		{
			Token[] equation =
					{
							new Operator('|'),
							new Operand(a.x), new Operator('*'),
							new Operator('('), new Operand(b.y), new Operator('-'), new Operand(c.y), new Operator(')'),
							new Operator('+'),
							new Operand(b.x), new Operator('*'),
							new Operator('('), new Operand(c.y), new Operator('-'), new Operand(a.y), new Operator(')'),
							new Operator('+'),
							new Operand(c.x), new Operator('*'),
							new Operator('('), new Operand(a.y), new Operator('-'), new Operand(b.y), new Operator(')'),
							new Operator('|'),
							new Operand(2)
					};
			Operand result = Arithmetic.Solve(Arrays.asList(equation));
			return result.Value;
		}
	}
}
