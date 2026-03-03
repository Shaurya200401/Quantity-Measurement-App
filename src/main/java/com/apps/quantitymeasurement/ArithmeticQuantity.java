package com.apps.quantitymeasurement;

import java.util.function.DoubleBinaryOperator;

public class ArithmeticQuantity<U extends IArithmeticMeasurable> extends Quantity<U> {

    public ArithmeticQuantity(double value, U unit) {
        super(value, unit);
    }

    private ArithmeticQuantity<U> calculate(ArithmeticQuantity<U> other, U targetUnit, DoubleBinaryOperator operator) {
        if (other == null)
            throw new IllegalArgumentException("Cannot operate on null quantity");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double val1 = this.convertToBaseUnit();
        double val2 = other.convertToBaseUnit();
        double resultInBase = operator.applyAsDouble(val1, val2);

        double targetValue = resultInBase / targetUnit.getConversionFactor();
        return new ArithmeticQuantity<>(Math.round(targetValue * 100.0) / 100.0, targetUnit);
    }

    public ArithmeticQuantity<U> add(ArithmeticQuantity<U> other, U targetUnit) {
        return this.calculate(other, targetUnit, Double::sum);
    }

    public ArithmeticQuantity<U> add(ArithmeticQuantity<U> other) {
        return this.add(other, this.unit);
    }

    public ArithmeticQuantity<U> subtract(ArithmeticQuantity<U> other, U targetUnit) {
        return this.calculate(other, targetUnit, (a, b) -> a - b);
    }

    public ArithmeticQuantity<U> subtract(ArithmeticQuantity<U> other) {
        return this.subtract(other, this.unit);
    }

    public double divide(ArithmeticQuantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException("Cannot divide by null quantity");
        if (other.convertToBaseUnit() == 0.0)
            throw new ArithmeticException("Division by zero");

        double result = this.convertToBaseUnit() / other.convertToBaseUnit();
        return Math.round(result * 100.0) / 100.0;
    }
}
