package ru.mycompany.forthchapter;

import ru.mycompany.secondchapter.Point;

public class Circle extends Shape implements Cloneable{

    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return super.mainPoint;
    }

    @Override
    public String toString() {
        return "Circle [" + super.toString()  +
                ",radius=" + radius +
                ']';
    }

    @Override
    public Circle clone() {
        try {
            return (Circle) super.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}
