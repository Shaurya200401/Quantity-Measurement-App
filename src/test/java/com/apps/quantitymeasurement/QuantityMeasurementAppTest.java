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

    // --- Addition Tests ---
    @Test
    public void testAddition_Lengths_Implicit() {
        Quantity inch2 = new Quantity(2.0, LengthUnit.INCHES);
        Quantity inch2_again = new Quantity(2.0, LengthUnit.INCHES);
        Quantity result = inch2.add(inch2_again);
        assertTrue(result.equals(new Quantity(4.0, LengthUnit.INCHES)));
    }

    @Test
    public void testAddition_Lengths_Explicit() {
        Quantity foot1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity inch2 = new Quantity(2.0, LengthUnit.INCHES);
        Quantity result = foot1.add(inch2, LengthUnit.INCHES);
        assertTrue(result.equals(new Quantity(14.0, LengthUnit.INCHES)));
    }

    @Test
    public void testAddition_Lengths_Explicit_Yard() {
        Quantity yard1 = new Quantity(1.0, LengthUnit.YARDS);
        Quantity feet3 = new Quantity(3.0, LengthUnit.FEET);
        Quantity result = yard1.add(feet3, LengthUnit.YARDS);
        assertTrue(result.equals(new Quantity(2.0, LengthUnit.YARDS)));
    }

    @Test
    public void testAddition_Volumes() {
        Quantity gallon1 = new Quantity(1.0, VolumeUnit.GALLON);
        Quantity liters3_78 = new Quantity(3.78541, VolumeUnit.LITRE);
        Quantity result = gallon1.add(liters3_78, VolumeUnit.LITRE);
        assertTrue(result.equals(new Quantity(7.57, VolumeUnit.LITRE))); // 3.78541 + 3.78541 = 7.57082 ~ 7.57
    }

    @Test
    public void testAddition_Weights() {
        Quantity tonne1 = new Quantity(1.0, WeightUnit.TONNE);
        Quantity kg1000 = new Quantity(1000.0, WeightUnit.KG);
        Quantity result = tonne1.add(kg1000, WeightUnit.KG);
        assertTrue(result.equals(new Quantity(2000.0, WeightUnit.KG)));
    }

    @Test
    public void testAddition_CrossCategory_Exception() {
        Quantity kg = new Quantity(1.0, WeightUnit.KG);
        Quantity liter = new Quantity(1.0, VolumeUnit.LITRE);
        boolean exceptionThrown = false;
        try {
            kg.add(liter, VolumeUnit.LITRE);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
