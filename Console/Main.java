package Console;

import calculator.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        UseItAll("1");
    }
    public static void UseItAll(String p)
    {
        try
        {
            History history = new History();
            history.Start();
            history.Pause();
            System.out.println(history.ReadAll());
            history.AddEntry("stuff", new ArrayList<>());
            history.AddEntry("stuff");
            history.Clear();
            System.out.println(history);
            double[] BigDumbArray = new double[100];
            String result = Function.Add(p, p) +
                    Function.Subtract(p, p) +
                    Function.Multiply(p, p) +
                    Function.Divide(p, p) +
                    Function.Mod(p, p) +
                    Function.Power(p, p) +
                    Function.Root(p, p) +
                    Function.Abs(p) +
                    Function.Log(p) +
                    Function.Ln(p) +
                    Function.Log(p, p) +
                    Function.Sin(p) +
                    Function.Cos(p) +
                    Function.Tan(p) +
                    Function.Acos(p) +
                    Function.Asin(p) +
                    Function.Atan(p) +
                    Function.Asinh(p) +
                    Function.Atanh(p) +
                    Function.Acosh(p) +
                    Function.Sinh(p) +
                    Function.Cosh(p) +
                    Function.Tanh(p) +
                    Function.Sin(p, true) +
                    Function.Cos(p, true) +
                    Function.Tan(p, true) +
                    Function.Acos(p, true) +
                    Function.Asin(p, true) +
                    Function.Atan(p, true) +
                    Function.Asinh(p, true) +
                    Function.Atanh(p, true) +
                    Function.Acosh(p, true) +
                    Function.Sinh(p, true) +
                    Function.Cosh(p, true) +
                    Function.Tanh(p, true) +
                    Formula.Geometry.Pythagorean(p, p, null) +
                    Formula.Sum(BigDumbArray) +
                    Formula.Mean(BigDumbArray) +
                    Formula.Mean(List.of(BigDumbArray));
            System.out.println(result);
            double y = Arithmetic.Solve(p, false);
            double x = Arithmetic.Solve(p);
            System.out.println(x);
            System.out.println(y);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}