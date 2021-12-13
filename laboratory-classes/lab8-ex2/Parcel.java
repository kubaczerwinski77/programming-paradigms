package com.kubaczerwinski77;

public class Parcel {

    double[] dims;
    Shape shape;

    public Parcel(double[] dims, Shape shape) {
        this.dims = dims;
        this.shape = shape;
    }

    public double[] getDims() {
        return dims;
    }

    public void setDims(double[] dims) {
        this.dims = dims;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double volume() {
        if (shape.equals(Shape.CUBOID)) return dims[0] * dims[1] * dims[2];
        else if (shape.equals(Shape.CYLINDER)) return Math.PI * dims[1] * dims[1] * dims[0];
        else if (shape.equals(Shape.SPHERE)) return 4 * Math.PI * dims[0] * dims[0] * dims[0] / 3;
        else if (shape.equals(Shape.SPECIAL)) return dims[0] * dims[0] * Math.sqrt(3) / 4;
        return 0;
    }

    @Override
    public String toString() {
        if (shape.equals(Shape.CUBOID)) return "CuboidParcel | dims: " + dims[0] + " " + dims[1] + " " + dims[2] + " volume: " + this.volume();
        else if (shape.equals(Shape.CYLINDER)) return "CylinderParcel | dims: " + dims[0] + " " + dims[1] + " volume: " + this.volume();
        // EDIT
        else if (shape.equals(Shape.SPECIAL)) return "SpecialPackage | dims: " + dims[0] + " " + dims[1] + " volume: " + this.volume();
        else if (shape.equals(Shape.SPHERE)) return "SphereParcel | dims: " + dims[0] + " volume: " + this.volume();
        return "Unknown Parcel";
    }
}
