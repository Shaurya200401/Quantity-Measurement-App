package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void demonstrateFeetEquality() {
        Length feet1 = new Length(0.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(0.0, Length.LengthUnit.FEET);
        System.out.println("Feet Equality (0.0 == 0.0): " + feet1.equals(feet2));
    }

    public static void demonstrateInchesEquality() {
        Length inches1 = new Length(0.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(0.0, Length.LengthUnit.INCHES);
        System.out.println("Inches Equality (0.0 == 0.0): " + inches1.equals(inches2));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
