package ru.mycompany.secondchapter;

public final class Point {
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point translate(double xDelta, double yDelta) {
        return new Point(this.x+xDelta, this.y+yDelta);
    }

    public Point scale(double scale) {
        return new Point(this.x * scale,this.y * scale);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
