package calculator;

import java.lang.Math;
import java.lang.String;

//Provides Basic Functions as building blocks of equations
//Exceptions include: 
//		IllegalArgumentException when Dividing by Zero or an improper parameter was given
//		UnsupportedOperationException() when a feature has either not been implemented or the Operation does not exist.
public class Function
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

	static Operand SmartSolve(Operand a, Operand b, Operator op)
	{
		switch (op.Name)
		{
		    case "ADD":
		        return Add(a, b);
		    case "SUBTRACT":
		        return Subtract(a, b);
		    case "MULTIPLY":
		        return Multiply(a, b);
		    case "DIVIDE":
		        return Divide(a, b);
		    case "MODULUS":
		        return Mod(a, b);
		    case "POWER":
		        return Power(a, b);
		    case "ROOT":
		        return Root(a, b);
		    case "ABS":
		    	return Abs(a);
		    case "SIN":
		    	return Sin(a);
		    case "COS":
		    	return Cos(a);
		    case "TAN":
		    	return Tan(a);
		    case "ASIN":
		    	return Asin(a);
		    case "ACOS":
		    	return Acos(a);
		    case "ATAN":
		    	return Atan(a);
		    case "SINH":
		    	return Sinh(a);
		    case "COSH":
		    	return Cosh(a);
		    case "TANH":
		    	return Tanh(a);
		    case "ASINH":
		    	return Asinh(a);
		    case "ACOSH":
		    	return Acosh(a);
		    case "ATANH":
		    	return Atanh(a);
		    case "LN":
		    	return Ln(a);
		    case "LOG":
		    	if (b == null) return Log(a);
		    	else return Log(a, b);
		    default:
		        throw new UnsupportedOperationException("Attempted Operation: " + op.Name);
		}
	}
	
	public static double Add(double a, double b)
	{
		if (Double.isNaN(a) || Double.isNaN(b)) throw new IllegalArgumentException("Both Parameters must be a number");
	    return a + b;
	}
	public static String Add(String aS, String bS)
	{
		double a = StringToDouble(aS);
		double b = StringToDouble(bS);
		return Double.toString(Add(a,b));
	}
	static Operand Add(Operand a, Operand b)
	{
	    return new Operand(Add(a.Value, b.Value));
	}

	public static double Subtract(double a, double b)
	{
		if (Double.isNaN(a) || Double.isNaN(b)) throw new IllegalArgumentException("Both Parameters must be a number");
	    return a - b; 
	}
	public static String Subtract(String aS, String bS)
	{
		double a = StringToDouble(aS);
		double b = StringToDouble(bS);
		return Double.toString(Subtract(a,b));
	}
	static Operand Subtract(Operand a, Operand b)
    {
        return new Operand(Subtract(a.Value, b.Value));
    }
	
	public static double Multiply(double a, double b)
	{
		if (Double.isNaN(a) || Double.isNaN(b)) throw new IllegalArgumentException("Both Parameters must be a number");
	    return a * b;
	}
	public static String Multiply(String aS, String bS)
	{
		double a = StringToDouble(aS);
		double b = StringToDouble(bS);
		return Double.toString(Multiply(a, b));
	}
	static Operand Multiply(Operand a, Operand b)
    {
        return new Operand(Multiply(a.Value, b.Value));
    }
	
	public static double Divide(double a, double b)
	{
		if (Double.isNaN(a) || Double.isNaN(b)) throw new IllegalArgumentException("Both Parameters must be a number");
	    if (b == 0) throw new IllegalArgumentException("Cannot Divide by Zero");
	    return a / b;
	}
	public static String Divide(String aS, String bS)
	{
		double a = StringToDouble(aS);
		double b = StringToDouble(bS);
		return Double.toString(Divide(a, b));
	}
	static Operand Divide(Operand a, Operand b)
    {
        return new Operand(Divide(a.Value, b.Value));
    }
	
	public static int Mod(int a, int b)
	{
	    if (b == 0) throw new IllegalArgumentException("Cannot Divide by Zero");
	    return a % b;
	}
	public static String Mod(String aS, String bS)
	{
		int a = Integer.parseInt(aS);
		int b = Integer.parseInt(bS);
		return Integer.toString(Mod(a, b));
	}
	static Operand Mod(Operand a, Operand b)
    {
        return new Operand(Mod((int)a.Value, (int)b.Value));
    }
	
	public static double Power(double a, double b)
	{
		if (Double.isNaN(a) || Double.isNaN(b)) throw new IllegalArgumentException("Both Parameters must be a number");
	    return Math.pow(a, b);
	}
	public static String Power(String aS, String bS)
	{
		double a = StringToDouble(aS);
		double b = StringToDouble(bS);
		return Double.toString(Power(a, b));
	}
	static Operand Power(Operand a, Operand b)
    {
        return new Operand(Math.pow(a.Value, b.Value));
    }
	
	public static double Root(double a, double b)
	{
		if (Double.isNaN(a) || Double.isNaN(b)) throw new IllegalArgumentException("Both Parameters must be a number");
	    return Power(a, Divide(1, b));
	}
	public static String Root(String aS, String bS)
	{
		double a = StringToDouble(aS);
		double b = StringToDouble(bS);
		return Double.toString(Root(a, b));
	}
	static Operand Root(Operand a, Operand b)
    {
        return new Operand(Root(a.Value, b.Value));
    }
	
	public static double Abs(double a)
	{
		if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
	    return Math.abs(a);
	}
	public static String Abs(String a)
	{
		return Double.toString(Abs(StringToDouble(a)));
	}
	static Operand Abs(Operand a)
	{
		return new Operand (Abs(a.Value));
	}
	
	public static double Sin(double a)
	{
		if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
	    return Math.sin(a);
	}
	public static double Sin(double a, boolean degrees)
	{
	    if (degrees) a = Math.toRadians(a);
	    a = Sin(a);
	    if (degrees) a = Math.toDegrees(a);
	    return a;
	}
	public static String Sin(String a)
	{
		return Double.toString(Sin(StringToDouble(a)));
	}
	public static String Sin(String a, boolean degrees)
	{
		return Double.toString(Sin(StringToDouble(a), degrees));
	}
	static Operand Sin(Operand a)
	{
		return new Operand(Sin(a.Value));
	}
	static Operand Sin(Operand a, boolean degrees)
	{
		return new Operand(Sin(a.Value, degrees));
	}
	
	public static double Cos(double a) 
    {
		if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Math.cos(a);
    }
    public static double Cos(double a, boolean degrees) 
    {
        if (degrees) a = Math.toRadians(a);
        a = Cos(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Cos(String aS) 
	{
		return Double.toString(Cos(StringToDouble(aS)));
	}
	public static String Cos(String aS, boolean degrees) 
	{
		return Double.toString(Cos(StringToDouble(aS), degrees));
	}
	static Operand Cos(Operand a) 
	{
		return new Operand (Cos(a.Value));
	}
	static Operand Cos(Operand a, boolean degrees) 
	{
		return new Operand(Cos(a.Value, degrees));
	}
	
    public static double Tan(double a) 
    {
    	if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Math.tan(a);
    }
    public static double Tan(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Tan(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Tan(String aS)
	{
		return Double.toString(Tan(StringToDouble(aS)));
	}
	public static String Tan(String aS, boolean degrees)
	{
		return Double.toString(Tan(StringToDouble(aS), degrees));
	}
	static Operand Tan(Operand a)
	{
		return new Operand(Tan(a.Value));
	}
	static Operand Tan(Operand a, boolean degrees)
	{
		return new Operand(Tan(a.Value, degrees));
	}

    public static double Sinh(double a) 
    {
    	if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Math.sinh(a);
    }
    public static double Sinh(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Sinh(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Sinh(String aS)
	{
		return Double.toString(Sinh(StringToDouble(aS)));
	}
	public static String Sinh(String aS, boolean degrees)
	{
		return Double.toString(Sinh(StringToDouble(aS), degrees));
	}
	static Operand Sinh(Operand a)
	{
		return new Operand(Sinh(a.Value));
	}
	static Operand Sinh(Operand a, boolean degrees)
	{
		return new Operand(Sinh(a.Value, degrees));
	}
	
    public static double Cosh(double a)
    {
    	if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Math.cosh(a);
    }
    public static double Cosh(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Cosh(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Cosh(String aS)
	{
		return Double.toString(Cosh(StringToDouble(aS)));
	}
	public static String Cosh(String aS, boolean degrees)
	{
		return Double.toString(Cosh(StringToDouble(aS), degrees));
	}
	static Operand Cosh(Operand a)
	{
		return new Operand(Cosh(a.Value));
	}
	static Operand Cosh(Operand a, boolean degrees)
	{
		return new Operand(Cosh(a.Value, degrees));
	}
	
    public static double Tanh(double a)
    {
    	if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Math.tanh(a);
    }
    public static double Tanh(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Tanh(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Tanh(String aS)
	{
		return Double.toString(Tanh(StringToDouble(aS)));
	}
	public static String Tanh(String aS, boolean degrees)
	{
		return Double.toString(Tanh(StringToDouble(aS), degrees));
	}
	static Operand Tanh(Operand a)
	{
		return new Operand(Tanh(a.Value));
	}
	static Operand Tanh(Operand a, boolean degrees)
	{
		return new Operand(Tanh(a.Value, degrees));
	}
	
    public static double Asin(double a)
    {
    	if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Math.asin(a);
    }
    public static double Asin(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Asin(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Asin(String aS)
	{
		return Double.toString(Asin(StringToDouble(aS)));
	}
	public static String Asin(String aS, boolean degrees)
	{
		return Double.toString(Asin(StringToDouble(aS), degrees));
	}
	static Operand Asin(Operand a)
	{
		return new Operand(Asin(a.Value));
	}
	static Operand Asin(Operand a, boolean degrees)
	{
		return new Operand(Asin(a.Value, degrees));
	}
	
    public static double Acos(double a)
    {
    	if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Math.acos(a);
    }
    public static double Acos(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Acos(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Acos(String aS)
	{
		return Double.toString(Acos(StringToDouble(aS)));
	}
	public static String Acos(String aS, boolean degrees)
	{
		return Double.toString(Acos(StringToDouble(aS), degrees));
	}
	static Operand Acos(Operand a)
	{
		return new Operand(Acos(a.Value));
	}
	static Operand Acos(Operand a, boolean degrees)
	{
		return new Operand(Acos(a.Value, degrees));
	}
	
	public static double Atan(double a)
    {
		if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Math.atan(a);
    }
    public static double Atan(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Atan(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Atan(String aS)
	{
		return Double.toString(Atan(StringToDouble(aS)));
	}
	public static String Atan(String aS, boolean degrees)
	{
		return Double.toString(Atan(StringToDouble(aS), degrees));
	}
	static Operand Atan(Operand a)
	{
		return new Operand(Atan(a.Value));
	}
	static Operand Atan(Operand a, boolean degrees)
	{
		return new Operand(Atan(a.Value, degrees));
	}
	
	public static double Asinh(double a)
	{
		if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
		return Math.log(a + Math.sqrt(a * a + 1));
	}
	public static double Asinh(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Asinh(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Asinh(String aS)
	{
		return Double.toString(Asinh(StringToDouble(aS)));
	}
	public static String Asinh(String aS, boolean degrees)
	{
		return Double.toString(Asinh(StringToDouble(aS), degrees));
	}
	static Operand Asinh(Operand a)
	{
		return new Operand(Asinh(a.Value));
	}
	static Operand Asinh(Operand a, boolean degrees)
	{
		return new Operand(Asinh(a.Value, degrees));
	}
	
	public static double Acosh(double a)
	{
		if (a < 1) return Double.NaN;
		if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
		return Math.log(a + Math.sqrt(a * a - 1));
	}
	public static double Acosh(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Acosh(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Acosh(String aS)
	{
		return Double.toString(Acosh(StringToDouble(aS)));
	}
	public static String Acosh(String aS, boolean degrees)
	{
		return Double.toString(Acosh(StringToDouble(aS), degrees));
	}
	static Operand Acosh(Operand a)
	{
		return new Operand(Acosh(a.Value));
	}
	static Operand Acosh(Operand a, boolean degrees)
	{
		return new Operand(Acosh(a.Value, degrees));
	}
	
	public static double Atanh(double a)
	{
		if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
	    return 0.5 * Math.log((1 + a) / (1 - a));
	}
	public static double Atanh(double a, boolean degrees)
    {
        if (degrees) a = Math.toRadians(a);
        a = Atanh(a);
        if (degrees) a = Math.toDegrees(a);
        return a;
    }
    public static String Atanh(String aS)
	{
		return Double.toString(Atanh(StringToDouble(aS)));
	}
	public static String Atanh(String aS, boolean degrees)
	{
		return Double.toString(Atanh(StringToDouble(aS), degrees));
	}
	static Operand Atanh(Operand a)
	{
		return new Operand(Atanh(a.Value));
	}
	static Operand Atanh(Operand a, boolean degrees)
	{
		return new Operand(Atanh(a.Value, degrees));
	}
	
    public static double Ln(double a)
    {
    	if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
        return Math.log(a);
    }
    public static String Ln(String aS)
    {
    	double a = StringToDouble(aS);
    	return Double.toString(Ln(a));
    }
    static Operand Ln(Operand a)
    {
    	return new Operand(Ln(a.Value));
    }
    public static double Log(double a)
    {
    	if (Double.isNaN(a)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Math.log10(a);
    }
    public static String Log(String a)
    {
    	return Double.toString(Log(StringToDouble(a)));
    }
    static Operand Log(Operand a)
    {
    	return new Operand(Log(a.Value));
    }
    public static double Log(double a, double b)
    {
    	if (Double.isNaN(a) || Double.isNaN(b)) throw new IllegalArgumentException("Both Parameters must be a number");
    	return Divide(Ln(a), Ln(b));
    }
    public static String Log(String a, String b)
    {
    	return Double.toString(Log(StringToDouble(a), StringToDouble(b)));
    }
    static Operand Log(Operand a, Operand b)
    {
    	return new Operand(Divide(Ln(a.Value), Ln(b.Value)));
    }
}
