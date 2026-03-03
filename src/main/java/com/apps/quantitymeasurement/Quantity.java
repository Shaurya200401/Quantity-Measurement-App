package com.apps.quantitymeasurement;

public class Quantity<U extends IMeasurable> {
    protected final double value;
    protected final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit() {
        return Math.round(this.unit.convertToBase(this.value) * 100.0) / 100.0;
    }

    public boolean compare(Quantity<U> other) {
        if (other == null)
            return false;

        double epsilon = 0.001;
        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < epsilon;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Quantity<?> other = (Quantity<?>) obj;
        // At runtime, due to type erasure, we must do a category check here if we want
        // equals() to be safe against raw types
        if (this.unit.getClass() != other.unit.getClass())
            return false;
        double epsilon = 0.001;
        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < epsilon;
    }
}
