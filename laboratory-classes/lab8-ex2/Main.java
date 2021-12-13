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

        Parcel p1 = new Parcel(dims3L, Shape.CUBOID);
        Parcel p2 = new Parcel(dims3S, Shape.CUBOID);

        Parcel p3 = new Parcel(dims2S, Shape.CYLINDER);
        Parcel p4 = new Parcel(dims2L, Shape.CYLINDER);

        Parcel p5 = new Parcel(dims1S, Shape.SPHERE);
        Parcel p6 = new Parcel(dims1M, Shape.SPHERE);
        Parcel p7 = new Parcel(dims1L, Shape.SPHERE);

        // EDIT
        Parcel p8 = new Parcel(dims2S, Shape.SPECIAL);
        Parcel p9 = new Parcel(dims2L, Shape.SPECIAL);

        ArrayList<Parcel> parcels = new ArrayList<>();
        parcels.add(p1);
        parcels.add(p2);
        parcels.add(p3);
        parcels.add(p4);
        parcels.add(p5);
        parcels.add(p6);
        parcels.add(p7);
        //EDIT
        parcels.add(p8);
        parcels.add(p9);

        PostOffice postOffice = new PostOffice(30, 120);
        postOffice.handleParcels(parcels);
        postOffice.printGroups();

    }
}
