package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class QuantityMeasurementAppTest {

    // --- Length Equality Tests ---
    @Test
    public void testFeetEquality_SameValue() {
        var feet1 = new Quantity<>(0.0, LengthUnit.FEET);
        var feet2 = new Quantity<>(0.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        var feet1 = new Quantity<>(0.0, LengthUnit.FEET);
        var feet2 = new Quantity<>(1.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testLengthEquality_NullComparison() {
        var feet1 = new Quantity<>(0.0, LengthUnit.FEET);
        assertFalse(feet1.equals(null));
    }

    @Test
    public void testLengthEquality_DifferentClass() {
        var feet1 = new Quantity<>(0.0, LengthUnit.FEET);
        Object otherType = new Object();
        assertFalse(feet1.equals(otherType));
    }

    // --- Cross-Unit Comparison Tests (Length) ---
    @Test
    public void testCrossUnit_FeetToInches() {
        var feet = new Quantity<>(1.0, LengthUnit.FEET);
        var inches = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testCrossUnit_YardsToFeet() {
        var yards = new Quantity<>(1.0, LengthUnit.YARDS);
        var feet = new Quantity<>(3.0, LengthUnit.FEET);
        assertTrue(yards.equals(feet));
    }

    @Test
    public void testCrossUnit_CentimetersToInches() {
        var cm = new Quantity<>(5.08, LengthUnit.CENTIMETERS);
        var inches = new Quantity<>(2.0, LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    // --- Cross-Unit Comparison Tests (Volume) ---
    @Test
    public void testCrossUnit_GallonToLiters() {
        var gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        var liters = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertTrue(gallon.equals(liters));
    }

    @Test
    public void testCrossUnit_LitersToML() {
        var liters = new Quantity<>(1.0, VolumeUnit.LITRE);
        var ml = new Quantity<>(1000.0, VolumeUnit.ML);
        assertTrue(liters.equals(ml));
    }

    // --- Cross-Unit Comparison Tests (Weight) ---
    @Test
    public void testCrossUnit_KGToGrams() {
        var kg = new Quantity<>(1.0, WeightUnit.KG);
        var grams = new Quantity<>(1000.0, WeightUnit.GRAMS);
        assertTrue(kg.equals(grams));
    }

    @Test
    public void testCrossUnit_TonneToKG() {
        var tonne = new Quantity<>(1.0, WeightUnit.TONNE);
        var kg = new Quantity<>(1000.0, WeightUnit.KG);
        assertTrue(tonne.equals(kg));
    }

    // --- Prevent Cross-Category Comparison ---
    @Test
    public void testCrossCategory_LengthAndVolume() {
        var inch = new Quantity<>(1.0, LengthUnit.INCHES);
        var ml = new Quantity<>(1.0, VolumeUnit.ML);
        assertFalse(inch.equals(ml));
    }

    @Test
    public void testCrossCategory_WeightAndVolume() {
        var kg = new Quantity<>(1.0, WeightUnit.KG);
        var liter = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertFalse(kg.equals(liter));
    }

    // --- Addition Tests ---
    @Test
    public void testAddition_Lengths_Implicit() {
        var inch2 = new Quantity<>(2.0, LengthUnit.INCHES);
        var inch2_again = new Quantity<>(2.0, LengthUnit.INCHES);
        var result = inch2.add(inch2_again);
        assertTrue(result.equals(new Quantity<>(4.0, LengthUnit.INCHES)));
    }

    @Test
    public void testAddition_Lengths_Explicit() {
        var foot1 = new Quantity<>(1.0, LengthUnit.FEET);
        var inch2 = new Quantity<>(2.0, LengthUnit.INCHES);
        var result = foot1.add(inch2, LengthUnit.INCHES);
        assertTrue(result.equals(new Quantity<>(14.0, LengthUnit.INCHES)));
    }

    @Test
    public void testAddition_Lengths_Explicit_Yard() {
        var yard1 = new Quantity<>(1.0, LengthUnit.YARDS);
        var feet3 = new Quantity<>(3.0, LengthUnit.FEET);
        var result = yard1.add(feet3, LengthUnit.YARDS);
        assertTrue(result.equals(new Quantity<>(2.0, LengthUnit.YARDS)));
    }

    @Test
    public void testAddition_Volumes() {
        var gallon1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        var liters3_78 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        var result = gallon1.add(liters3_78, VolumeUnit.LITRE);
        assertTrue(result.equals(new Quantity<>(7.58, VolumeUnit.LITRE))); // 1 Gallon=3.79L, 3.785L=3.79L ->
                                                                           // 3.79+3.79=7.58
    }

    @Test
    public void testAddition_Weights() {
        var tonne1 = new Quantity<>(1.0, WeightUnit.TONNE);
        var kg1000 = new Quantity<>(1000.0, WeightUnit.KG);
        var result = tonne1.add(kg1000, WeightUnit.KG);
        assertTrue(result.equals(new Quantity<>(2000.0, WeightUnit.KG)));
    }

    // --- Immutability Test (UC9) ---
    @Test
    public void testAddition_ReturnsNewObject_PreservingOriginal() {
        var original = new Quantity<>(2.0, LengthUnit.INCHES);
        var toBeAdded = new Quantity<>(2.0, LengthUnit.INCHES);

        var result = original.add(toBeAdded);

        // Assert result is 4 inches
        assertTrue(result.equals(new Quantity<>(4.0, LengthUnit.INCHES)));
        // Assert original remains 2 inches
        assertTrue(original.equals(new Quantity<>(2.0, LengthUnit.INCHES)));
        // Assert they are not the same object in memory
        assertFalse(original == result);
    }

    // --- Subtraction Tests (UC12) ---
    @Test
    public void testSubtract_Lengths_Implicit() {
        var yards2 = new Quantity<>(2.0, LengthUnit.YARDS);
        var feet3 = new Quantity<>(3.0, LengthUnit.FEET);
        var result = yards2.subtract(feet3);
        assertTrue(result.equals(new Quantity<>(1.0, LengthUnit.YARDS))); // 2 YARDS - 1 YARD = 1 YARD
    }

    @Test
    public void testSubtract_Volumes_Explicit() {
        var gallon1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        var liters1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        var result = gallon1.subtract(liters1, VolumeUnit.LITRE);
        assertTrue(result.equals(new Quantity<>(2.79, VolumeUnit.LITRE))); // 3.79 - 1.0 = 2.79
    }

    // --- Division Tests (UC12) ---
    @Test
    public void testDivide_Lengths() {
        var inch2 = new Quantity<>(2.0, LengthUnit.INCHES);
        var inch1 = new Quantity<>(1.0, LengthUnit.INCHES);
        double result = inch2.divide(inch1);
        assertTrue(Math.abs(result - 2.0) < 0.001);
    }

    @Test
    public void testDivide_ByZero_Exception() {
        var inch2 = new Quantity<>(2.0, LengthUnit.INCHES);
        var inch0 = new Quantity<>(0.0, LengthUnit.INCHES);
        boolean exceptionThrown = false;
        try {
            inch2.divide(inch0);
        } catch (ArithmeticException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
