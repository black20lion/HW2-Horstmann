package ru.mycompany.forthchapter;

import ru.mycompany.secondchapter.Point;

public class Line extends Shape implements Cloneable {

    Point from;
    Point to;

    public Line(Point from, Point to) {
        super(new Point((from.getX() + to.getX()) / 2, (from.getY() + to.getY()) / 2));
        this.from = from;
        this.to = to;
    }

    @Override
    public void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
        from = from.translate(dx, dy);
        to = to.translate(dx, dy);
    }

    @Override
    public Point getCenter() {
        return super.mainPoint;
    }

    @Override
    public String toString() {
        return "Line{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    @Override
    public Line clone() {
        try {
            return (Line) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}
