package calculator.Shapes;

public class Square extends Rectangle
{
    public Square()
    {
        super();
    }

    public Square(double sideLength)
    {
        super(sideLength, sideLength);
    }

    public Square(Polygon poly)
    {
        this.sides = poly.sides;
        this.perimeter = poly.perimeter;
        this.area = poly.area;
        this.sidesLength = poly.sidesLength;
        this.interiorAngles = poly.interiorAngles;
        this.exteriorAngles = poly.exteriorAngles;
    }
    public static Square fromSidesLength(double[] sidesLength)
    {
        if (sidesLength == null || sidesLength.length < 1)
        {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }
        else return new Square(sidesLength[0]);
    }

    public Rhombus toRhombus()
    {
        return new Rhombus(this);
    }
}
