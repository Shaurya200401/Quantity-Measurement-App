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

    public static void demonstrateCrossCategoryPrevention() {
        System.out.println("\n--- Cross Category Prevention ---");
        Quantity kg1 = new Quantity(1.0, WeightUnit.KG);
        Quantity liters1 = new Quantity(1.0, VolumeUnit.LITRE);
        System.out.println("1.0 KG == 1.0 LITRE : " + kg1.equals(liters1));
    }

    public static void demonstrateAddition() {
        System.out.println("\n--- Addition Demonstration ---");
        Quantity feet1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity inches2 = new Quantity(2.0, LengthUnit.INCHES);
        Quantity result1 = feet1.add(inches2, LengthUnit.INCHES);
        System.out.println("1.0 FEET + 2.0 INCHES (in INCHES) = "
                + result1.convertToBaseUnit() / LengthUnit.INCHES.getConversionFactor() + " INCHES");

        Quantity gallon1 = new Quantity(1.0, VolumeUnit.GALLON);
        Quantity liters3_78 = new Quantity(3.78541, VolumeUnit.LITRE);
        Quantity result2 = gallon1.add(liters3_78, VolumeUnit.LITRE);
        System.out.println("1.0 GALLON + 3.78541 LITRES (in LITRES) = "
                + result2.convertToBaseUnit() / VolumeUnit.LITRE.getConversionFactor() + " LITRES");

        System.out.println("\nConcepts Learned by Implementing UC7-UC9:");
        System.out.println("ADDITION, METRIC CONVERSIONS, IMMUTABILITY");
    }

    public static void main(String[] args) {
        demonstrateLengthComparison();
        demonstrateVolumeComparison();
        demonstrateWeightComparison();
        demonstrateCrossCategoryPrevention();
        demonstrateAddition();
    }
}
