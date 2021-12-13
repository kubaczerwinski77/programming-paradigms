package com.kubaczerwinski77;

public class CylinderParcel extends Parcel{
    private double height;
    private double radius;

    CylinderParcel(double[] dims) {
        this.height = dims[0];
        this.radius = dims[1];
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return "CylinderParcel{" +
                "height=" + height +
                ", radius=" + radius +
                '}' + " volume: " + this.volume();
    }
}
