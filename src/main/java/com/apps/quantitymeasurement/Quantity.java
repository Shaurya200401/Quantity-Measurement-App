package com.apps.quantitymeasurement;

public class Quantity<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit() {
        return Math.round(this.value * this.unit.getConversionFactor() * 1000.0) / 1000.0;
    }

    public boolean compare(Quantity<U> other) {
        if (other == null)
            return false;

        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Cannot add null quantity");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumInBase = this.convertToBaseUnit() + other.convertToBaseUnit();
        double targetValue = sumInBase / targetUnit.getConversionFactor();
        return new Quantity<>(Math.round(targetValue * 100.0) / 100.0, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return this.add(other, this.unit);
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
        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
    }
}
