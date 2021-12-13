package com.kubaczerwinski77;

public class SphereParcel extends Parcel{

    private double radius;

    public SphereParcel(double[] dims) {
        this.radius = dims[0];
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double volume() {
        return 4 * Math.PI * radius * radius * radius / 3;
    }

    @Override
    public String toString() {
        return "SphereParcel{" +
                "radius=" + radius +
                '}' + " volume: " + this.volume();
    }
}
