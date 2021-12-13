package com.kubaczerwinski77;

public class SpecialParcel extends Parcel{

    private double edge;
    private double height;

    public SpecialParcel(double[] dims) {
        this.edge = dims[0];
        this.height = dims[1];
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    double volume() {
        return (edge * edge * Math.sqrt(3) / 4) * 6 * height;
    }

    @Override
    public String toString() {
        return "SpecialParcel{" +
                "edge=" + edge +
                ", height=" + height +
                '}' + " volume: " + this.volume();
    }
}
