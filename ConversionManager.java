public class ConversionManager {
    
    // Currency conversion rates (as of recent data - these would ideally be fetched from an API)
    private static final double[][] CURRENCY_RATES = {
        // INR, USD, EUR, GBP, JPY, CAD, AUD, CHF
        {1.0, 0.012, 0.011, 0.0095, 1.8, 0.016, 0.018, 0.011}, // INR
        {83.0, 1.0, 0.92, 0.79, 150.0, 1.35, 1.52, 0.92},      // USD
        {90.0, 1.09, 1.0, 0.86, 163.0, 1.47, 1.65, 1.0},       // EUR
        {105.0, 1.27, 1.16, 1.0, 190.0, 1.71, 1.92, 1.16},     // GBP
        {0.55, 0.0067, 0.0061, 0.0053, 1.0, 0.009, 0.010, 0.0061}, // JPY
        {62.0, 0.74, 0.68, 0.58, 111.0, 1.0, 1.13, 0.68},      // CAD
        {55.0, 0.66, 0.61, 0.52, 99.0, 0.89, 1.0, 0.61},       // AUD
        {90.0, 1.09, 1.0, 0.86, 163.0, 1.47, 1.65, 1.0}        // CHF
    };
    
    public double convertCurrency(double amount, int fromCurrency, int toCurrency) {
        if (fromCurrency < 1 || fromCurrency > 8 || toCurrency < 1 || toCurrency > 8) {
            throw new IllegalArgumentException("Invalid currency selection");
        }
        
        // Convert to 0-based indexing
        int from = fromCurrency - 1;
        int to = toCurrency - 1;
        
        // Convert to USD first, then to target currency
        double usdAmount = amount / CURRENCY_RATES[from][1]; // Convert to USD
        return usdAmount * CURRENCY_RATES[1][to]; // Convert from USD to target
    }
    
    public double convertLength(double length, int fromUnit, int toUnit) {
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
    
    public double convertWeight(double weight, int fromUnit, int toUnit) {
        if (fromUnit < 1 || fromUnit > 8 || toUnit < 1 || toUnit > 8) {
            throw new IllegalArgumentException("Invalid weight unit selection");
        }
        
        // Convert to kilograms first
        double kilograms = toKilograms(weight, fromUnit);
        
        // Convert from kilograms to target unit
        return fromKilograms(kilograms, toUnit);
    }
    
    private double toKilograms(double value, int unit) {
        switch (unit) {
            case 1: return value / 1000000.0; // mg to kg
            case 2: return value / 1000.0;    // g to kg
            case 3: return value;             // kg to kg
            case 4: return value * 1000.0;    // metric ton to kg
            case 5: return value * 0.0283495; // oz to kg
            case 6: return value * 0.453592;  // lb to kg
            case 7: return value * 6.35029;   // stone to kg
            case 8: return value * 907.185;   // US ton to kg
            default: throw new IllegalArgumentException("Invalid weight unit");
        }
    }
    
    private double fromKilograms(double kilograms, int unit) {
        switch (unit) {
            case 1: return kilograms * 1000000.0; // kg to mg
            case 2: return kilograms * 1000.0;    // kg to g
            case 3: return kilograms;             // kg to kg
            case 4: return kilograms / 1000.0;    // kg to metric ton
            case 5: return kilograms / 0.0283495; // kg to oz
            case 6: return kilograms / 0.453592;  // kg to lb
            case 7: return kilograms / 6.35029;   // kg to stone
            case 8: return kilograms / 907.185;   // kg to US ton
            default: throw new IllegalArgumentException("Invalid weight unit");
        }
    }
    
    public double convertTime(double time, int fromUnit, int toUnit) {
        if (fromUnit < 1 || fromUnit > 7 || toUnit < 1 || toUnit > 7) {
            throw new IllegalArgumentException("Invalid time unit selection");
        }
        
        // Convert to seconds first
        double seconds = toSeconds(time, fromUnit);
        
        // Convert from seconds to target unit
        return fromSeconds(seconds, toUnit);
    }
    
    private double toSeconds(double value, int unit) {
        switch (unit) {
            case 1: return value;           // seconds to seconds
            case 2: return value * 60.0;    // minutes to seconds
            case 3: return value * 3600.0;  // hours to seconds
            case 4: return value * 86400.0; // days to seconds
            case 5: return value * 604800.0; // weeks to seconds
            case 6: return value * 2592000.0; // months to seconds (30 days)
            case 7: return value * 31536000.0; // years to seconds (365 days)
            default: throw new IllegalArgumentException("Invalid time unit");
        }
    }
    
    private double fromSeconds(double seconds, int unit) {
        switch (unit) {
            case 1: return seconds;           // seconds to seconds
            case 2: return seconds / 60.0;    // seconds to minutes
            case 3: return seconds / 3600.0;  // seconds to hours
            case 4: return seconds / 86400.0; // seconds to days
            case 5: return seconds / 604800.0; // seconds to weeks
            case 6: return seconds / 2592000.0; // seconds to months
            case 7: return seconds / 31536000.0; // seconds to years
            default: throw new IllegalArgumentException("Invalid time unit");
        }
    }
    
    public double convertTemperature(double temperature, int fromUnit, int toUnit) {
        if (fromUnit < 1 || fromUnit > 3 || toUnit < 1 || toUnit > 3) {
            throw new IllegalArgumentException("Invalid temperature unit selection");
        }
        
        // Convert to Celsius first
        double celsius = toCelsius(temperature, fromUnit);
        
        // Convert from Celsius to target unit
        return fromCelsius(celsius, toUnit);
    }
    
    private double toCelsius(double value, int unit) {
        switch (unit) {
            case 1: return value;                    // Celsius to Celsius
            case 2: return (value - 32) * 5.0 / 9.0; // Fahrenheit to Celsius
            case 3: return value - 273.15;           // Kelvin to Celsius
            default: throw new IllegalArgumentException("Invalid temperature unit");
        }
    }
    
    private double fromCelsius(double celsius, int unit) {
        switch (unit) {
            case 1: return celsius;                    // Celsius to Celsius
            case 2: return celsius * 9.0 / 5.0 + 32;  // Celsius to Fahrenheit
            case 3: return celsius + 273.15;           // Celsius to Kelvin
            default: throw new IllegalArgumentException("Invalid temperature unit");
        }
    }
} 