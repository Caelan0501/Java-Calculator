package calculator.Shapes;

import java.util.Arrays;

public class Rectangle extends Quadrilateral
{
    public Rectangle()
    {
        super();
        Arrays.fill(interiorAngles, 90);
        Arrays.fill(exteriorAngles, 90);
    }
    public Rectangle(double Length, double Width)
    {
        this();
        sidesLength[0] = Length;
        sidesLength[1] = Width;
        sidesLength[2] = Length;
        sidesLength[3] = Width;

        area = Length * Width;
    }

    //1 Element will cause a square
    //2 Elements will cause a rectangle
    //3 and beyond will ignore extra values
    public static Rectangle fromSidesLength(double[] sidesLength)
    {
        if (sidesLength == null || sidesLength.length < 1)
        {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }
        else if (sidesLength.length == 1) return new Rectangle(sidesLength[0], sidesLength[0]);
        else return new Rectangle(sidesLength[0], sidesLength[1]);
    }


}
