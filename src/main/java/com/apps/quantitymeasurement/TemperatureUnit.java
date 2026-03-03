package com.apps.quantitymeasurement;

public enum TemperatureUnit implements IMeasurable {
    CELSIUS,
    FAHRENHEIT;

    @Override
    public double convertToBase(double value) {
        if (this == FAHRENHEIT) {
            return (value - 32.0) * 5.0 / 9.0;
        }
        return value; // CELSIUS is the base unit
    }
}
