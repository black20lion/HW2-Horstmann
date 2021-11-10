package ru.mycompany.forthchapter;

import ru.mycompany.secondchapter.Point;

public class Rectangle extends Shape implements Cloneable {
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        assert (width > 0): "width is expected to be a positive value";
        assert (height > 0): "height is expected to be a positive value";
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        double botRightX = super.mainPoint.getX() + width;
        double botRightY = super.mainPoint.getY() - height;
        return new Point((super.mainPoint.getX() + botRightX)/2,
                (super.mainPoint.getY() + botRightY) / 2);
    }

    @Override
    public String toString() {
        return "Rectangle [" + super.toString()  +
                ",width=" + width +
                ",height=" + height +
                ']';
    }

    @Override
    public Rectangle clone() {
        try {
            return (Rectangle) super.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}
