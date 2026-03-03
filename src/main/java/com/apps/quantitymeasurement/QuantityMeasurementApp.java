package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void demonstrateLengthComparison() {
        System.out.println("--- Length Comparison ---");
        Quantity yards1 = new Quantity(1.0, LengthUnit.YARDS);
        Quantity feet3 = new Quantity(3.0, LengthUnit.FEET);
        System.out.println("1.0 YARDS == 3.0 FEET : " + yards1.equals(feet3));

        Quantity cm1 = new Quantity(1.0, LengthUnit.CENTIMETERS);
        Quantity inches039 = new Quantity(0.393701, LengthUnit.INCHES);
        System.out.println("1.0 CENTIMETERS == 0.393701 INCHES : " + cm1.equals(inches039));
    }

    public static void demonstrateVolumeComparison() {
        System.out.println("\n--- Volume Comparison ---");
        Quantity gallon1 = new Quantity(1.0, VolumeUnit.GALLON);
        Quantity liters378 = new Quantity(3.78541, VolumeUnit.LITRE);
        System.out.println("1.0 GALLON == 3.78541 LITRES : " + gallon1.equals(liters378));

        Quantity liters1 = new Quantity(1.0, VolumeUnit.LITRE);
        Quantity ml1000 = new Quantity(1000.0, VolumeUnit.ML);
        System.out.println("1.0 LITRE == 1000.0 ML : " + liters1.equals(ml1000));
    }

    public static void demonstrateWeightComparison() {
        System.out.println("\n--- Weight Comparison ---");
        Quantity kg1 = new Quantity(1.0, WeightUnit.KG);
        Quantity grams1000 = new Quantity(1000.0, WeightUnit.GRAMS);
        System.out.println("1.0 KG == 1000.0 GRAMS : " + kg1.equals(grams1000));

        Quantity tonne1 = new Quantity(1.0, WeightUnit.TONNE);
        Quantity kg1000 = new Quantity(1000.0, WeightUnit.KG);
        System.out.println("1.0 TONNE == 1000.0 KG : " + tonne1.equals(kg1000));
    }

    public static void demonstrateVolumeAndWeight() {
        System.out.println("\nConcepts Learned by Implementing UC4-UC5:");
        System.out.println("GENERIC DESIGN, EXTENDED UNITS");
    }

    public static void main(String[] args) {
        demonstrateLengthComparison();
        demonstrateVolumeComparison();
        demonstrateWeightComparison();
        demonstrateVolumeAndWeight();
    }
}
