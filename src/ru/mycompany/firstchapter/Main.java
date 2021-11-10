package ru.mycompany.firstchapter;

import org.w3c.dom.css.Rect;
import ru.mycompany.forthchapter.Circle;
import ru.mycompany.forthchapter.Line;
import ru.mycompany.forthchapter.Rectangle;
import ru.mycompany.secondchapter.Car;
import ru.mycompany.secondchapter.Point;
import ru.mycompany.thirdchapter.Employee;
import ru.mycompany.thirdchapter.Measurable;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        printBinOctHex(15);
        System.out.println("///////////////////////////");

        System.out.println(normalizeAngle(50));
        System.out.println(normalizeAngle(0));
        System.out.println(normalizeAngle(360));
        System.out.println(normalizeAngle(370));
        System.out.println(normalizeAngle(-10));
        System.out.println(normalizeAngle(-710));
        System.out.println("///////////////////////////");

        System.out.println(normalizeAngleOptimized(50));
        System.out.println(normalizeAngleOptimized(0));
        System.out.println(normalizeAngleOptimized(360));
        System.out.println(normalizeAngleOptimized(370));
        System.out.println(normalizeAngleOptimized(-10));
        System.out.println(normalizeAngleOptimized(-710));
        System.out.println("///////////////////////////");
        System.out.println(maxOfThree(5, 7, 12));
        System.out.println(maxOfThreeOptimized(5, 7, 12));
        System.out.println("///////////////////////////");
        printMaxAndMinOfPositiveDouble();
        System.out.println("///////////////////////////");
        printMaxAndMinOfPositiveDoubleOptimized();
        System.out.println("///////////////////////////");
        System.out.println(evaluateFactorial(1000));
        System.out.println("///////////////////////////");
        System.out.println(lottery());
        System.out.println(lottery());
        System.out.println(lottery());
        System.out.println("///////////////////////////");
        Point point1 = new Point(3.5, 5);
        Point point2 = point1.translate(5, 10);
        Point point3 = point2.scale(0.5);

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println("///////////////////////////");
        Car bmw = new Car(20, 20);
        bmw.drive(10);
        System.out.println(bmw.getCurrentDistance());
        System.out.println(bmw.getFuelLevel());

        bmw.addFuel(17);
        bmw.addFuel(17);

        bmw.drive(50);
        System.out.println(bmw.getCurrentDistance());
        System.out.println(bmw.getFuelLevel());
        bmw.drive(500);
        System.out.println(bmw.getCurrentDistance());
        System.out.println("///////////////////////////");

        Employee employee1 = new Employee("John",1223);
        Employee employee2 = new Employee("Fedor", 2734);
        Employee employee3 = new Employee("Julia",1593);

        Employee[] programmers = {employee1,employee2,employee3};
        System.out.println(avarage(programmers));


        //We need downcast here because a method 'getName' is available only for instances of Employee
        //not for all Measurables

        Measurable bestEmployee = largest(programmers);
        if (bestEmployee.getClass() == Employee.class) {
            System.out.println(((Employee) bestEmployee).getName());
        }

        System.out.println("///////////////////////////");

        Point trialPoint = new Point(5,6);
        Point trialPoint2 = new Point(-4, -7);
        Circle circle1 = new Circle(trialPoint, 3);
        Rectangle rectangle1 = new Rectangle(trialPoint, 2, 4);
        Line line1 = new Line(trialPoint, trialPoint2);
        System.out.println(circle1);
        System.out.println(rectangle1);
        System.out.println(line1);

        System.out.println(circle1.getCenter());
        System.out.println(rectangle1.getCenter());
        System.out.println(line1.getCenter());

        System.out.println("///////////////////////////");
        Circle circle2 = circle1.clone();
        circle1.moveBy(3, 4);

        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println(circle1==circle2);

        Rectangle rectangle2 = rectangle1.clone();
        rectangle1.moveBy(2,1);

        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println(rectangle1==rectangle2);

        Line line2 = line1.clone();
        line1.moveBy(-2, -5);

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line1==line2);

    }

    public static void printBinOctHex(int decimal) {
        System.out.println("Input number = " + decimal);
        System.out.println("In binary = " + Integer.toBinaryString(decimal));
        System.out.println("In octal = " + Integer.toOctalString(decimal));
        System.out.println("In hexadecimal = " + Integer.toHexString(decimal));
        if (decimal == 0)
            System.out.println("Can not find reciprocal because the figure is zero");
        else
            System.out.println("Reciprocal in hex " + Float.toHexString(1f / decimal));
    }

    public static int normalizeAngle(int angle) {
        if (angle >= 0 && angle < 360) return angle;
        if (angle >= 360) return (angle % 360);
        else
            return -(angle % 360);
    }

    public static int normalizeAngleOptimized(int angle) {
        if (angle >= 0 && angle < 360) return angle;
        if (angle >= 360) return (Math.floorMod(angle, 360));
        else
            return -(Math.floorMod(angle, -360));
    }

    public static int maxOfThree(int one, int two, int three) {
        int localMax = one;
        if (one < two)
            localMax = two;
        if (localMax < three)
            localMax = three;
        return localMax;
    }

    public static int maxOfThreeOptimized(int one, int two, int three) {
        return Math.max(Math.max(one, two), three);
    }

    public static void printMaxAndMinOfPositiveDouble() {
        System.out.println("Positive min of Double: " + Math.nextUp(0));
        System.out.println("Positive max of Double: " + Math.nextDown(Double.POSITIVE_INFINITY));
    }

    public static void printMaxAndMinOfPositiveDoubleOptimized() {
        System.out.println("Positive min of Double: " + Double.MIN_VALUE);
        System.out.println("Positive max of Double: " + Double.MAX_VALUE);
    }

    public static BigInteger evaluateFactorial(int n) {
        assert (n >= 0) : "Factorial is defined on positive int only";
        BigInteger result = BigInteger.valueOf(1);
        BigInteger modifier = BigInteger.valueOf(1);
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                modifier = BigInteger.valueOf(i);
                result = result.multiply(modifier);
            }
        }
        return result;
    }

    public static ArrayList<Integer> lottery() {
        ArrayList<Integer> start = new ArrayList();
        for (int i = 1; i <= 49; i++) {
            start.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            Random random = new Random();
            int pointer = random.nextInt(49 - i) + 1;
            result.add(start.get(pointer - 1));
            start.remove(pointer - 1);
        }
        Collections.sort(result);
        return result;
    }

    public static double avarage(Measurable[] objects) {
        double result = 0;
        for (int i = 0; i < objects.length; i++) {
            result += objects[i].getMeasure();
        }
        return result/(objects.length);
    }

    public static Measurable largest (Measurable[] objects) {
        Measurable currentLargest = objects[0];
        for (int i = 1; i < objects.length; i++) {
            if (currentLargest.getMeasure() < objects[i].getMeasure())
                currentLargest = objects[i];
        }
        return currentLargest;
    }
}
