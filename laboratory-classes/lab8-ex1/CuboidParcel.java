package com.kubaczerwinski77;

public class CuboidParcel extends Parcel{

    private double width;
    private double height;
    private double length;

    CuboidParcel(double[] dims) {
        this.width = dims[0];
        this.height = dims[1];
        this.length = dims[2];
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    double volume() {
        return width * height * length;
    }

    @Override
    public String toString() {
        return "CuboidParcel{" +
                "width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}' + " volume: " + this.volume();
    }
}
