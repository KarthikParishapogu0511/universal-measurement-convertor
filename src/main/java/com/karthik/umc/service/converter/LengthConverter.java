package com.karthik.umc.service.converter;

public class LengthConverter {
    public double convert(double length, int fromUnit, int toUnit) {
        if (fromUnit < 1 || fromUnit > 8 || toUnit < 1 || toUnit > 8) {
            throw new IllegalArgumentException("Invalid length unit selection");
        }

        // Convert to meters first
        double meters = toMeters(length, fromUnit);

        // Convert from meters to target unit
        return fromMeters(meters, toUnit);
    }

    private double toMeters(double value, int unit) {
        switch (unit) {
            case 1: return value / 1000.0; // mm to m
            case 2: return value / 100.0;  // cm to m
            case 3: return value;          // m to m
            case 4: return value * 1000.0; // km to m
            case 5: return value * 0.0254; // inches to m
            case 6: return value * 0.3048; // feet to m
            case 7: return value * 0.9144; // yards to m
            case 8: return value * 1609.344; // miles to m
            default: throw new IllegalArgumentException("Invalid length unit");
        }
    }

    private double fromMeters(double meters, int unit) {
        switch (unit) {
            case 1: return meters * 1000.0; // m to mm
            case 2: return meters * 100.0;  // m to cm
            case 3: return meters;          // m to m
            case 4: return meters / 1000.0; // m to km
            case 5: return meters / 0.0254; // m to inches
            case 6: return meters / 0.3048; // m to feet
            case 7: return meters / 0.9144; // m to yards
            case 8: return meters / 1609.344; // m to miles
            default: throw new IllegalArgumentException("Invalid length unit");
        }
    }
}
