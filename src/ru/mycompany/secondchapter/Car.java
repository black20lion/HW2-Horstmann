package ru.mycompany.secondchapter;

//This class should not be immutable because we need to have access
//to its fields (fuelLevel, x) and we do not expect to get a new
//instance of the Class every time we change value of these fields
//(adding fuel to tank, driving the car along the X-Axis)

public class Car {
    private double tankVolume;
    private double fuelLevel;
    private double fuelEfficiency;
    private double x;

    public Car(double fuelEfficiency, double tankVolume) {
        this.fuelEfficiency = fuelEfficiency;
        this.tankVolume = tankVolume;
    }

    public void drive(double numberOfMiles) {
        assert numberOfMiles >= 0 : "Impossible to cover negative number of miles";
        double milesCanBeCovered = fuelEfficiency * fuelLevel;
        fuelLevel -= numberOfMiles / fuelEfficiency;
        if (fuelLevel < 0) {
            fuelLevel = 0;
            System.out.println("Not enough fuel to cover the distance");
            System.out.println(milesCanBeCovered + " miles was covered");
            System.out.println(numberOfMiles - milesCanBeCovered + " miles left to destination");
            System.out.println("tank is empty");
            x += milesCanBeCovered;
        } else {
            x += numberOfMiles;
        }
    }

    public void addFuel(double extraGallons) {
        assert extraGallons >= 0 : "Impossible to add negative number of Gallons";
        double overLoading = (fuelLevel + extraGallons) - tankVolume;
        fuelLevel += extraGallons;
        if (fuelLevel > tankVolume) {
            fuelLevel = tankVolume;
            System.out.println("The tank is full");
            System.out.println(overLoading + " gallons out of tank");
        }
    }

    public double getCurrentDistance() {
        return x;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

}
