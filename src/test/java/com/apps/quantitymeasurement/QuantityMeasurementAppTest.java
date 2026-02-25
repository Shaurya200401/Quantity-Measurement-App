package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    // --- Feet Tests ---
    @Test
    public void testFeetEquality_SameValue() {
        Length feet1 = new Length(0.0, LengthUnit.FEET);
        Length feet2 = new Length(0.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Length feet1 = new Length(0.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Length feet1 = new Length(0.0, LengthUnit.FEET);
        assertFalse(feet1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Length feet1 = new Length(0.0, LengthUnit.FEET);
        Object otherType = new Object();
        assertFalse(feet1.equals(otherType));
    }

    @Test
    public void testFeetEquality_SameReference() {
        Length feet1 = new Length(0.0, LengthUnit.FEET);
        Length feet2 = feet1;
        assertTrue(feet1.equals(feet2));
    }

    // --- Inches Tests ---
    @Test
    public void testInchesEquality_SameValue() {
        Length inches1 = new Length(0.0, LengthUnit.INCHES);
        Length inches2 = new Length(0.0, LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Length inches1 = new Length(0.0, LengthUnit.INCHES);
        Length inches2 = new Length(1.0, LengthUnit.INCHES);
        assertFalse(inches1.equals(inches2));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Length inches1 = new Length(0.0, LengthUnit.INCHES);
        assertFalse(inches1.equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Length inches1 = new Length(0.0, LengthUnit.INCHES);
        Object otherType = new Object();
        assertFalse(inches1.equals(otherType));
    }

    @Test
    public void testInchesEquality_SameReference() {
        Length inches1 = new Length(0.0, LengthUnit.INCHES);
        Length inches2 = inches1;
        assertTrue(inches1.equals(inches2));
    }

    // --- Cross-Unit Comparison Tests ---
    @Test
    public void testCrossUnit_FeetToInches() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testCrossUnit_YardsToFeet() {
        Length yards = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        assertTrue(yards.equals(feet));
    }

    @Test
    public void testCrossUnit_YardsToInches() {
        Length yards = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yards.equals(inches));
    }

    @Test
    public void testCrossUnit_CentimetersToInches() {
        Length cm = new Length(5.08, LengthUnit.CENTIMETERS);
        Length inches = new Length(2.0, LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    @Test
    public void testCrossUnit_InchesToCentimeters() {
        Length inches = new Length(2.0, LengthUnit.INCHES);
        Length cm = new Length(5.08, LengthUnit.CENTIMETERS);
        assertTrue(inches.equals(cm));
    }
}
