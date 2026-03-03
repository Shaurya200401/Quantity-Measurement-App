package com.apps.quantitymeasurement;

public class Quantity {
    private final double value;
    private final IMeasurable unit;

    public Quantity(double value, IMeasurable unit) {
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit() {
        return Math.round(this.value * this.unit.getConversionFactor() * 1000.0) / 1000.0;
    }

    public boolean compare(Quantity other) {
        if (other == null)
            return false;

        // Prevent cross-category comparison for UC6
        if (this.unit.getClass() != other.unit.getClass())
            return false;

        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
    }

    public Quantity add(Quantity other, IMeasurable targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Cannot add null quantity");
        if (this.unit.getClass() != other.unit.getClass())
            throw new IllegalArgumentException("Cannot add quantities of different categories");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumInBase = this.convertToBaseUnit() + other.convertToBaseUnit();
        double targetValue = sumInBase / targetUnit.getConversionFactor();
        return new Quantity(Math.round(targetValue * 100.0) / 100.0, targetUnit);
    }

    public Quantity add(Quantity other) {
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
        Quantity other = (Quantity) obj;
        return compare(other);
    }
}
