package calculator.Shapes;

import calculator.Function;

import java.util.Arrays;

public class Rhombus extends Quadrilateral
{
    public Rhombus()
    {
        super();
    }
    public Rhombus(double sideLength)
    {
        this();
        Arrays.fill(sidesLength, sideLength);
    }
    public Rhombus(double angleA, double angleB)
    {
        this();
        interiorAngles[0] = angleA;
        interiorAngles[1] = angleB;
        interiorAngles[2] = angleA;
        interiorAngles[3] = angleB;
    }
    public Rhombus(double sideLength, double angleA, double angleB)
    {
        this(sideLength);
        interiorAngles[0] = angleA;
        interiorAngles[1] = angleB;
        interiorAngles[2] = angleA;
        interiorAngles[3] = angleB;
    }
    public Rhombus(Polygon poly)
    {
        this.sides = 4;
        this.sidesLength = Arrays.copyOf(poly.sidesLength, 4);
        //Deal with faulty angles
        this.interiorAngles = Arrays.copyOf(poly.interiorAngles, 4);
        this.exteriorAngles = Arrays.copyOf(poly.exteriorAngles, 4);
        for (double length : poly.sidesLength)
        {
            this.perimeter += length;
        }
        this.area = Function.Multiply(sidesLength[0], sidesLength[0]);
    }
    public Square toSquare()
    {
        return new Square(this);
    }
}
