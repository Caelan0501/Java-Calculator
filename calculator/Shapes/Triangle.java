package calculator.Shapes;

import calculator.Formula;
import calculator.Formula.Geometry;

import java.awt.*;

public class Triangle extends Polygon
{
    public Triangle()
    {
        super();
        sides = 3;
        sidesLength = new double[3];
        interiorAngles = new double[3];
        exteriorAngles = new double[3];
        points = new Point[3];
    }
    public Triangle(double[] sidesLength)
    {
        this();
        this.sidesLength[0] = sidesLength[0];
        this.sidesLength[1] = sidesLength[1];
        this.sidesLength[2] = sidesLength[2];
        this.perimeter = Formula.Sum(this.sidesLength);
        this.interiorAngles = Geometry.LawOfCosines(sidesLength[0], sidesLength[1], sidesLength[2]);
        for (int i = 0; i < interiorAngles.length; i++)
        {
            exteriorAngles[i] += 180 - interiorAngles[i];
        }
        this.area = Formula.Geometry.Heron(sidesLength[0], sidesLength[1], sidesLength[2]);
    }
    public Triangle(Point[] points)
    {
        this();
        this.points[0] = points[0];
        this.points[1] = points[1];
        this.points[2] = points[2];
        this.sidesLength[0] = points[0].distance(points[1]);
        this.sidesLength[1] = points[1].distance(points[2]);
        this.sidesLength[2] = points[2].distance(points[0]);
        this.interiorAngles = Geometry.LawOfCosines(sidesLength[0], sidesLength[1], sidesLength[2]);
        for (int i = 0; i < interiorAngles.length; i++)
        {
            exteriorAngles[i] += 180 - interiorAngles[i];
        }
        area = Geometry.AreaOfTriangle(points[0], points[1], points[2]);
    }

}
