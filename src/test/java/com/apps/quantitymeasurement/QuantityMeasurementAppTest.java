package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.apps.quantitymeasurement.Length;
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
}
