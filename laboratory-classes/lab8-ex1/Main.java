package com.kubaczerwinski77;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        double[] dims3L = {4, 5, 6};
        double[] dims3S = {1, 2, 2};
        double[] dims2L = {5, 12};
        double[] dims2S = {2, 1};
        double[] dims1L = {10};
        double[] dims1M = {5};
        double[] dims1S = {1};

        Parcel p1 = new CuboidParcel(dims3L);
        Parcel p2 = new CuboidParcel(dims3S);

        Parcel p3 = new CylinderParcel(dims2L);
        Parcel p4 = new CylinderParcel(dims2S);

        Parcel p5 = new SphereParcel(dims1L);
        Parcel p6 = new SphereParcel(dims1M);
        Parcel p7 = new SphereParcel(dims1S);

        // Special Parcel
        Parcel p8 = new SpecialParcel(dims2L);
        Parcel p9 = new SpecialParcel(dims2S);

        ArrayList<Parcel> parcels = new ArrayList<>();
        parcels.add(p1);
        parcels.add(p2);
        parcels.add(p3);
        parcels.add(p4);
        parcels.add(p5);
        parcels.add(p6);
        parcels.add(p7);
        // Add Special Package
        parcels.add(p8);
        parcels.add(p9);

        PostOffice postOffice = new PostOffice(30, 120);
        postOffice.handleParcels(parcels);
        postOffice.printGroups();

    }
}
