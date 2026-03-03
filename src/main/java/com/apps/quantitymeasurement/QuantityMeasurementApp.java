package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void demonstrateLengthComparison() {
        System.out.println("--- Length Comparison ---");
        var yards1 = new ArithmeticQuantity<>(1.0, LengthUnit.YARDS);
        var feet3 = new ArithmeticQuantity<>(3.0, LengthUnit.FEET);
        System.out.println("1.0 YARDS == 3.0 FEET : " + yards1.equals(feet3));

        var cm1 = new ArithmeticQuantity<>(1.0, LengthUnit.CENTIMETERS);
        var inches039 = new ArithmeticQuantity<>(0.393701, LengthUnit.INCHES);
        System.out.println("1.0 CENTIMETERS == 0.393701 INCHES : " + cm1.equals(inches039));
    }

    public static void demonstrateVolumeComparison() {
        System.out.println("\n--- Volume Comparison ---");
        var gallon1 = new ArithmeticQuantity<>(1.0, VolumeUnit.GALLON);
        var liters378 = new ArithmeticQuantity<>(3.78541, VolumeUnit.LITRE);
        System.out.println("1.0 GALLON == 3.78541 LITRES : " + gallon1.equals(liters378));

        var liters1 = new ArithmeticQuantity<>(1.0, VolumeUnit.LITRE);
        var ml1000 = new ArithmeticQuantity<>(1000.0, VolumeUnit.ML);
        System.out.println("1.0 LITRE == 1000.0 ML : " + liters1.equals(ml1000));
    }

    public static void demonstrateWeightComparison() {
        System.out.println("\n--- Weight Comparison ---");
        var kg1 = new ArithmeticQuantity<>(1.0, WeightUnit.KG);
        var grams1000 = new ArithmeticQuantity<>(1000.0, WeightUnit.GRAMS);
        System.out.println("1.0 KG == 1000.0 GRAMS : " + kg1.equals(grams1000));

        var tonne1 = new ArithmeticQuantity<>(1.0, WeightUnit.TONNE);
        var kg1000 = new ArithmeticQuantity<>(1000.0, WeightUnit.KG);
        System.out.println("1.0 TONNE == 1000.0 KG : " + tonne1.equals(kg1000));
    }

    public static void demonstrateAddition() {
        System.out.println("\n--- Addition Demonstration ---");
        var feet1 = new ArithmeticQuantity<>(1.0, LengthUnit.FEET);
        var inches2 = new ArithmeticQuantity<>(2.0, LengthUnit.INCHES);
        var result1 = feet1.add(inches2, LengthUnit.INCHES);
        System.out.println("1.0 FEET + 2.0 INCHES (in INCHES) = "
                + result1.convertToBaseUnit() / LengthUnit.INCHES.getConversionFactor() + " INCHES");

        var gallon1 = new ArithmeticQuantity<>(1.0, VolumeUnit.GALLON);
        var liters3_78 = new ArithmeticQuantity<>(3.78541, VolumeUnit.LITRE);
        var result2 = gallon1.add(liters3_78, VolumeUnit.LITRE);
        System.out.println("1.0 GALLON + 3.78541 LITRES (in LITRES) = "
                + result2.convertToBaseUnit() / VolumeUnit.LITRE.getConversionFactor() + " LITRES");

        System.out.println("\nConcepts Learned by Implementing UC7-UC9:");
        System.out.println("ADDITION, METRIC CONVERSIONS, IMMUTABILITY");
    }

    public static void demonstrateTemperatureComparison() {
        System.out.println("\n--- Temperature Comparison (UC14) ---");
        var c100 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        var f212 = new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT);
        System.out.println("100.0 CELSIUS == 212.0 FAHRENHEIT : " + c100.equals(f212));
    }

    public static void demonstrateAdvancedArithmetic() {
        System.out.println("\n--- Advanced Arithmetic (UC12) ---");
        var yards2 = new ArithmeticQuantity<>(2.0, LengthUnit.YARDS);
        var feet3 = new ArithmeticQuantity<>(3.0, LengthUnit.FEET);
        var resultSub = yards2.subtract(feet3);
        System.out.println("2.0 YARDS - 3.0 FEET = "
                + resultSub.convertToBaseUnit() / LengthUnit.YARDS.getConversionFactor() + " YARDS");

        var inch2 = new ArithmeticQuantity<>(2.0, LengthUnit.INCHES);
        var inch1 = new ArithmeticQuantity<>(1.0, LengthUnit.INCHES);
        double resultDiv = inch2.divide(inch1);
        System.out.println("2.0 INCHES / 1.0 INCH = " + resultDiv);
    }

    public static void main(String[] args) {
        demonstrateLengthComparison();
        demonstrateVolumeComparison();
        demonstrateWeightComparison();
        demonstrateTemperatureComparison();
        demonstrateAddition();
        demonstrateAdvancedArithmetic();
    }
}
