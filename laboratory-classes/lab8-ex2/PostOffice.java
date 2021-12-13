package com.kubaczerwinski77;

import java.util.ArrayList;

public class PostOffice {
    private double minimum;
    private double maximum;
    private final ArrayList<Parcel> smallParcels;
    private final ArrayList<Parcel> mediumParcels;
    private final ArrayList<Parcel> largeParcels;

    PostOffice(double minimum, double maximum) {
        this.maximum = maximum;
        this.minimum = minimum;
        smallParcels = new ArrayList<>();
        mediumParcels = new ArrayList<>();
        largeParcels = new ArrayList<>();
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    void handleParcels(ArrayList<Parcel> parcels) {
        for (Parcel parcel : parcels) {
            if (parcel.volume() <= minimum) {
                smallParcels.add(parcel);
            } else if (parcel.volume() > minimum && parcel.volume() <= maximum) {
                mediumParcels.add(parcel);
            } else {
                largeParcels.add(parcel);
            }
        }
    }

    void printGroups() {
        System.out.println("SMALL PARCELS:");
        for (Parcel parcel : smallParcels) {
            System.out.println(parcel);
        }
        System.out.println("\nMEDIUM PARCELS:");
        for (Parcel parcel : mediumParcels) {
            System.out.println(parcel);
        }
        System.out.println("\nLARGE PARCELS:");
        for (Parcel parcel : largeParcels) {
            System.out.println(parcel);
        }
    }
}
