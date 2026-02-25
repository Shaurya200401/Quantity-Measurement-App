package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {

    // --- Feet Tests ---
    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(1.0);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet1 = new Feet(0.0);
        assertFalse(feet1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet1 = new Feet(0.0);
        Object otherType = new Object();
        assertFalse(feet1.equals(otherType));
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = feet1;
        assertTrue(feet1.equals(feet2));
    }

    // --- Inches Tests ---
    @Test
    public void testInchesEquality_SameValue() {
        Inches inches1 = new Inches(0.0);
        Inches inches2 = new Inches(0.0);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches inches1 = new Inches(0.0);
        Inches inches2 = new Inches(1.0);
        assertFalse(inches1.equals(inches2));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches inches1 = new Inches(0.0);
        assertFalse(inches1.equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches inches1 = new Inches(0.0);
        Object otherType = new Object();
        assertFalse(inches1.equals(otherType));
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inches1 = new Inches(0.0);
        Inches inches2 = inches1;
        assertTrue(inches1.equals(inches2));
    }
}
