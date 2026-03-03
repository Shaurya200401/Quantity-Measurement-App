package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class QuantityMeasurementAppTest {

    // --- Length Equality Tests ---
    @Test
    public void testFeetEquality_SameValue() {
        Quantity feet1 = new Quantity(0.0, LengthUnit.FEET);
        Quantity feet2 = new Quantity(0.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Quantity feet1 = new Quantity(0.0, LengthUnit.FEET);
        Quantity feet2 = new Quantity(1.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testLengthEquality_NullComparison() {
        Quantity feet1 = new Quantity(0.0, LengthUnit.FEET);
        assertFalse(feet1.equals(null));
    }

    @Test
    public void testLengthEquality_DifferentClass() {
        Quantity feet1 = new Quantity(0.0, LengthUnit.FEET);
        Object otherType = new Object();
        assertFalse(feet1.equals(otherType));
    }

    // --- Cross-Unit Comparison Tests (Length) ---
    @Test
    public void testCrossUnit_FeetToInches() {
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);
        Quantity inches = new Quantity(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testCrossUnit_YardsToFeet() {
        Quantity yards = new Quantity(1.0, LengthUnit.YARDS);
        Quantity feet = new Quantity(3.0, LengthUnit.FEET);
        assertTrue(yards.equals(feet));
    }

    @Test
    public void testCrossUnit_CentimetersToInches() {
        Quantity cm = new Quantity(5.08, LengthUnit.CENTIMETERS);
        Quantity inches = new Quantity(2.0, LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    // --- Cross-Unit Comparison Tests (Volume) ---
    @Test
    public void testCrossUnit_GallonToLiters() {
        Quantity gallon = new Quantity(1.0, VolumeUnit.GALLON);
        Quantity liters = new Quantity(3.78541, VolumeUnit.LITRE);
        assertTrue(gallon.equals(liters));
    }

    @Test
    public void testCrossUnit_LitersToML() {
        Quantity liters = new Quantity(1.0, VolumeUnit.LITRE);
        Quantity ml = new Quantity(1000.0, VolumeUnit.ML);
        assertTrue(liters.equals(ml));
    }

    // --- Cross-Unit Comparison Tests (Weight) ---
    @Test
    public void testCrossUnit_KGToGrams() {
        Quantity kg = new Quantity(1.0, WeightUnit.KG);
        Quantity grams = new Quantity(1000.0, WeightUnit.GRAMS);
        assertTrue(kg.equals(grams));
    }

    @Test
    public void testCrossUnit_TonneToKG() {
        Quantity tonne = new Quantity(1.0, WeightUnit.TONNE);
        Quantity kg = new Quantity(1000.0, WeightUnit.KG);
        assertTrue(tonne.equals(kg));
    }

    // --- Prevent Cross-Category Comparison ---
    @Test
    public void testCrossCategory_LengthAndVolume() {
        Quantity inch = new Quantity(1.0, LengthUnit.INCHES);
        Quantity ml = new Quantity(1.0, VolumeUnit.ML);
        assertFalse(inch.equals(ml));
    }

    @Test
    public void testCrossCategory_WeightAndVolume() {
        Quantity kg = new Quantity(1.0, WeightUnit.KG);
        Quantity liter = new Quantity(1.0, VolumeUnit.LITRE);
        assertFalse(kg.equals(liter));
    }
}
