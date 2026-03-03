package com.apps.quantitymeasurement;

import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit() {
        return Math.round(this.value * this.unit.getConversionFactor() * 100.0) / 100.0;
    }

    public boolean compare(Quantity<U> other) {
        if (other == null)
            return false;

        double epsilon = 0.001;
        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < epsilon;
    }

    private Quantity<U> calculate(Quantity<U> other, U targetUnit, DoubleBinaryOperator operator) {
        if (other == null)
            throw new IllegalArgumentException("Cannot operate on null quantity");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double val1 = this.convertToBaseUnit();
        double val2 = other.convertToBaseUnit();
        double resultInBase = operator.applyAsDouble(val1, val2);

        double targetValue = resultInBase / targetUnit.getConversionFactor();
        return new Quantity<>(Math.round(targetValue * 100.0) / 100.0, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        return this.calculate(other, targetUnit, Double::sum);
    }

    public Quantity<U> add(Quantity<U> other) {
        return this.add(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        return this.calculate(other, targetUnit, (a, b) -> a - b);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return this.subtract(other, this.unit);
    }

    public double divide(Quantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException("Cannot divide by null quantity");
        if (other.convertToBaseUnit() == 0.0)
            throw new ArithmeticException("Division by zero");

        double result = this.convertToBaseUnit() / other.convertToBaseUnit();
        return Math.round(result * 100.0) / 100.0;
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
