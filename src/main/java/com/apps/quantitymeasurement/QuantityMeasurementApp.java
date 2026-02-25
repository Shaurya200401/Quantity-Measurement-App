package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void demonstrateLengthComparison() {
        Length yards1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet3 = new Length(3.0, Length.LengthUnit.FEET);
        System.out.println("Input: Quantity(1.0, YARDS) and Quantity(3.0, FEET)");
        System.out.println("Output: Equal (" + yards1.equals(feet3) + ")\n");

        Length yards1_v2 = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches36 = new Length(36.0, Length.LengthUnit.INCHES);
        System.out.println("Input: Quantity(1.0, YARDS) and Quantity(36.0, INCHES)");
        System.out.println("Output: Equal (" + yards1_v2.equals(inches36) + ")\n");

        Length yards2_1 = new Length(2.0, Length.LengthUnit.YARDS);
        Length yards2_2 = new Length(2.0, Length.LengthUnit.YARDS);
        System.out.println("Input: Quantity(2.0, YARDS) and Quantity(2.0, YARDS)");
        System.out.println("Output: Equal (" + yards2_1.equals(yards2_2) + ")\n");

        Length cm2_1 = new Length(2.0, Length.LengthUnit.CENTIMETERS);
        Length cm2_2 = new Length(2.0, Length.LengthUnit.CENTIMETERS);
        System.out.println("Input: Quantity(2.0, CENTIMETERS) and Quantity(2.0, CENTIMETERS)");
        System.out.println("Output: Equal (" + cm2_1.equals(cm2_2) + ")\n");

        Length cm1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inches039 = new Length(0.393701, Length.LengthUnit.INCHES);
        System.out.println("Input: Quantity(1.0, CENTIMETERS) and Quantity(0.393701, INCHES)");
        System.out.println("Output: Equal (" + cm1.equals(inches039) + ")\n");

        System.out.println("Concepts Learned by Implementing UC4:");
        System.out.println("SCALABILITY OF GENERIC DESIGN");
    }

    public static void main(String[] args) {
        demonstrateLengthComparison();
    }
}
