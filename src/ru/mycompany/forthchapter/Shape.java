package ru.mycompany.forthchapter;

import ru.mycompany.secondchapter.Point;

public abstract class Shape implements Cloneable {
    protected Point mainPoint;

    public Shape(Point mainPoint) {
        this.mainPoint = mainPoint;
    }

    public void moveBy(double dx, double dy) {
        this.mainPoint = mainPoint.translate(dx, dy);
    }

    public abstract Point getCenter();

    @Override
    public String toString() {
        return mainPoint + "";
    }
}
