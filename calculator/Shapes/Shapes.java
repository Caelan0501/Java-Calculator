package calculator.Shapes;

import java.awt.Point;

public abstract class Shapes
{
    public String DescribeShape()
    {
        StringBuilder builder = new StringBuilder();
        if (this instanceof Polygon)
        {
            if (this instanceof Quadrilateral)
            {
                if (this instanceof Square)
                {
                    builder.append("Regular Polygon\nSquare");
                }
                else if (this instanceof Rhombus)
                {

                }
                else if (this instanceof Rectangle)
                {

                }
            }
            else if (this instanceof Triangle)
            {

            }
            else
            {

            }
        }

        builder.append("Shapes");
        return builder.toString();
    }
}
