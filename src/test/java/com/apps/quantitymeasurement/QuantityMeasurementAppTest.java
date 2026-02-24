package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_SameValue() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testEquality_DifferentValue() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(1.0);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testEquality_NullComparison() {
        Feet feet1 = new Feet(0.0);
        assertFalse(feet1.equals(null));
    }

    @Test
    public void testEquality_NonNumericInput() {
        Feet feet1 = new Feet(0.0);
        Object otherType = new Object();
        assertFalse(feet1.equals(otherType));
    }

    @Test
    public void testEquality_SameReference() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = feet1;
        assertTrue(feet1.equals(feet2));
    }
}
