package calculator.Shapes;

import calculator.Function;

import java.awt.Point;
import java.util.Arrays;

public class Polygon extends Shapes
{
    protected int sides = -1;
    protected double perimeter = -1;
    protected double area = -1;

    protected double[] sidesLength = null;
    protected double[] interiorAngles = null;
    protected double[] exteriorAngles = null;
    protected Point[] points = null;

    protected void Fill(boolean autoFill,int sides, double perimeter, double area, double[] sidesLength, double[] interiorAngles, double[] exteriorAngles)
    {
        boolean[] Validity = new boolean[6];
        Arrays.fill(Validity, false);

        if (sides > 2)
        {
            this.sides = sides;
            Validity[0] = true;
        }
        if (perimeter > 0)
        {
            this.perimeter = perimeter;
            Validity[1] = true;
        }
        if (area > 0)
        {
            this.area = area;
            Validity[2] = true;
        }
        if (sidesLength != null)
        {
            this.sidesLength = sidesLength;
            Validity[3] = true;
        }
        if (interiorAngles != null)
        {
            this.interiorAngles = interiorAngles;
            Validity[4] = true;
        }
        if (exteriorAngles != null)
        {
            this.exteriorAngles = exteriorAngles;
            Validity[5] = true;
        }

        if (autoFill) autoFill(Validity);
    }

    protected void autoFill(boolean[] Validity)
    {
        /*
            0 = sides
            1 = perimeter
            2 = area
            3 = sidesLength
            4 = interiorAngles
            5 = exteriorAngles
        */

        // 0 -> Regular(4), Regular(5), sizeOf(3)
        // 3 -> 0, 1, 4, 5
        // 4 -> 0, 5, sizeOf(3)
        // 5 -> 0, 4, sizeOf(3)
        // 0, 1 -> 3, 4, 5
        // 0, 3 -> 1, 4, 5, sizeOf(3)

        if(Validity[0])
        {
            interiorAngles = new double[sides];
            Arrays.fill(interiorAngles, Function.Divide(Function.Multiply(Function.Subtract(sides, 2), 180), sides));
            exteriorAngles = new double[sides];
            Arrays.fill(exteriorAngles, 0);

        }
        if(Validity[1])
        {

        }
        if(Validity[2])
        {

        }
        if(Validity[3])
        {

        }
        if(Validity[4])
        {

        }
        if(Validity[5])
        {

        }
    }

    public Polygon()
    {

    }

    public Polygon(int sides)
    {
        Fill(false, sides, -1, -1, null, null, null);
    }
    public Polygon(double perimeter)
    {
        Fill(false, -1, perimeter, -1, null, null, null);
    }
    public Polygon(double[] sidesLength)
    {
        Fill(false, -1, -1, -1, sidesLength, null, null);
    }
    public Polygon(int sides, double perimeter)
    {
        Fill(false, sides, perimeter, -1, null, null, null);
    }
    public Polygon(int sides, double[] sideLength)
    {
        Fill(false, sides, -1, -1, sideLength, null, null);
    }
    public Polygon(double perimeter, double[] sidesLength)
    {
        Fill(false, -1, perimeter, -1, sidesLength, null, null);
    }
    public Polygon(int sides, double perimeter, double[] sidesLength)
    {
        Fill(false, sides, perimeter, -1, sidesLength, null, null);
    }

    public Polygon(int sides, boolean autoFill)
    {
        Fill(autoFill, sides, -1, -1, null, null, null);
    }
    public Polygon(double perimeter, boolean autoFill)
    {
        Fill(autoFill, -1, perimeter, -1, null, null, null);
    }
    public Polygon(double[] sidesLength, boolean autoFill)
    {
        Fill(autoFill, -1, -1, -1, sidesLength, null, null);
    }
    public Polygon(int sides, double perimeter, boolean autoFill)
    {
        Fill(autoFill, sides, perimeter, -1, null, null, null);
    }
    public Polygon(int sides, double[] sideLength, boolean autoFill)
    {
        Fill(autoFill, sides, -1, -1, sideLength, null, null);
    }
    public Polygon(double perimeter, double[] sidesLength, boolean autoFill)
    {
        Fill(autoFill, -1, perimeter, -1, sidesLength, null, null);
    }
    public Polygon(int sides, double perimeter, double[] sidesLength, boolean autoFill)
    {
        Fill(autoFill, sides, perimeter, -1, sidesLength, null, null);
    }
}
