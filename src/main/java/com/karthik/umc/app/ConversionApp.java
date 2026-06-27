package com.karthik.umc.app;

import com.karthik.umc.service.ConversionManager;

import java.util.Scanner;

public class ConversionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversionManager conversionManager = new ConversionManager();
        
        System.out.println("=== UNIVERSAL CONVERSION CALCULATOR ===");
        System.out.println("Welcome to the comprehensive conversion tool!");
        
        while (true) {
            displayMainMenu();
            System.out.print("Enter your choice (1-6): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        handleCurrencyConversion(scanner, conversionManager);
                        break;
                    case 2:
                        handleLengthConversion(scanner, conversionManager);
                        break;
                    case 3:
                        handleWeightConversion(scanner, conversionManager);
                        break;
                    case 4:
                        handleTimeConversion(scanner, conversionManager);
                        break;
                    case 5:
                        handleTemperatureConversion(scanner, conversionManager);
                        break;
                    case 6:
                        System.out.println("Thank you for using the Conversion Calculator!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1-6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
            
            System.out.println("\n" + "=".repeat(50) + "\n");
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("\nSelect conversion type:");
        System.out.println("1. Currency Conversion");
        System.out.println("2. Length/Height Conversion");
        System.out.println("3. Weight/Mass Conversion");
        System.out.println("4. Time Conversion");
        System.out.println("5. Temperature Conversion");
        System.out.println("6. Exit");
    }
    
    private static void handleCurrencyConversion(Scanner scanner, ConversionManager manager) {
        System.out.println("\n=== CURRENCY CONVERSION ===");
        System.out.println("Available currencies:");
        System.out.println("1. INR (Indian Rupee)");
        System.out.println("2. USD (US Dollar)");
        System.out.println("3. EUR (Euro)");
        System.out.println("4. GBP (British Pound)");
        System.out.println("5. JPY (Japanese Yen)");
        System.out.println("6. CAD (Canadian Dollar)");
        System.out.println("7. AUD (Australian Dollar)");
        System.out.println("8. CHF (Swiss Franc)");
        
        try {
            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            
            System.out.print("From currency (1-8): ");
            int fromCurrency = Integer.parseInt(scanner.nextLine());
            
            System.out.print("To currency (1-8): ");
            int toCurrency = Integer.parseInt(scanner.nextLine());
            
            double result = manager.convertCurrency(amount, fromCurrency, toCurrency);
            String fromSymbol = getCurrencySymbol(fromCurrency);
            String toSymbol = getCurrencySymbol(toCurrency);
            
            System.out.printf("\nResult: %.2f %s = %.2f %s\n", amount, fromSymbol, result, toSymbol);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid numbers.");
        }
    }
    
    private static void handleLengthConversion(Scanner scanner, ConversionManager manager) {
        System.out.println("\n=== LENGTH/HEIGHT CONVERSION ===");
        System.out.println("Available units:");
        System.out.println("1. Millimeters (mm)");
        System.out.println("2. Centimeters (cm)");
        System.out.println("3. Meters (m)");
        System.out.println("4. Kilometers (km)");
        System.out.println("5. Inches (in)");
        System.out.println("6. Feet (ft)");
        System.out.println("7. Yards (yd)");
        System.out.println("8. Miles (mi)");
        
        try {
            System.out.print("Enter length: ");
            double length = Double.parseDouble(scanner.nextLine());
            
            System.out.print("From unit (1-8): ");
            int fromUnit = Integer.parseInt(scanner.nextLine());
            
            System.out.print("To unit (1-8): ");
            int toUnit = Integer.parseInt(scanner.nextLine());
            
            double result = manager.convertLength(length, fromUnit, toUnit);
            String fromSymbol = getLengthSymbol(fromUnit);
            String toSymbol = getLengthSymbol(toUnit);
            
            System.out.printf("\nResult: %.4f %s = %.4f %s\n", length, fromSymbol, result, toSymbol);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid numbers.");
        }
    }
    
    private static void handleWeightConversion(Scanner scanner, ConversionManager manager) {
        System.out.println("\n=== WEIGHT/MASS CONVERSION ===");
        System.out.println("Available units:");
        System.out.println("1. Milligrams (mg)");
        System.out.println("2. Grams (g)");
        System.out.println("3. Kilograms (kg)");
        System.out.println("4. Metric tons (t)");
        System.out.println("5. Ounces (oz)");
        System.out.println("6. Pounds (lb)");
        System.out.println("7. Stones (st)");
        System.out.println("8. US tons (US ton)");
        
        try {
            System.out.print("Enter weight: ");
            double weight = Double.parseDouble(scanner.nextLine());
            
            System.out.print("From unit (1-8): ");
            int fromUnit = Integer.parseInt(scanner.nextLine());
            
            System.out.print("To unit (1-8): ");
            int toUnit = Integer.parseInt(scanner.nextLine());
            
            double result = manager.convertWeight(weight, fromUnit, toUnit);
            String fromSymbol = getWeightSymbol(fromUnit);
            String toSymbol = getWeightSymbol(toUnit);
            
            System.out.printf("\nResult: %.4f %s = %.4f %s\n", weight, fromSymbol, result, toSymbol);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid numbers.");
        }
    }
    
    private static void handleTimeConversion(Scanner scanner, ConversionManager manager) {
        System.out.println("\n=== TIME CONVERSION ===");
        System.out.println("Available units:");
        System.out.println("1. Seconds (s)");
        System.out.println("2. Minutes (min)");
        System.out.println("3. Hours (h)");
        System.out.println("4. Days (d)");
        System.out.println("5. Weeks (wk)");
        System.out.println("6. Months (mo)");
        System.out.println("7. Years (yr)");
        
        try {
            System.out.print("Enter time: ");
            double time = Double.parseDouble(scanner.nextLine());
            
            System.out.print("From unit (1-7): ");
            int fromUnit = Integer.parseInt(scanner.nextLine());
            
            System.out.print("To unit (1-7): ");
            int toUnit = Integer.parseInt(scanner.nextLine());
            
            double result = manager.convertTime(time, fromUnit, toUnit);
            String fromSymbol = getTimeSymbol(fromUnit);
            String toSymbol = getTimeSymbol(toUnit);
            
            System.out.printf("\nResult: %.4f %s = %.4f %s\n", time, fromSymbol, result, toSymbol);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid numbers.");
        }
    }
    
    private static void handleTemperatureConversion(Scanner scanner, ConversionManager manager) {
        System.out.println("\n=== TEMPERATURE CONVERSION ===");
        System.out.println("Available units:");
        System.out.println("1. Celsius (°C)");
        System.out.println("2. Fahrenheit (°F)");
        System.out.println("3. Kelvin (K)");
        
        try {
            System.out.print("Enter temperature: ");
            double temp = Double.parseDouble(scanner.nextLine());
            
            System.out.print("From unit (1-3): ");
            int fromUnit = Integer.parseInt(scanner.nextLine());
            
            System.out.print("To unit (1-3): ");
            int toUnit = Integer.parseInt(scanner.nextLine());
            
            double result = manager.convertTemperature(temp, fromUnit, toUnit);
            String fromSymbol = getTemperatureSymbol(fromUnit);
            String toSymbol = getTemperatureSymbol(toUnit);
            
            System.out.printf("\nResult: %.2f %s = %.2f %s\n", temp, fromSymbol, result, toSymbol);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid numbers.");
        }
    }
    
    private static String getCurrencySymbol(int currency) {
        switch (currency) {
            case 1: return "INR";
            case 2: return "USD";
            case 3: return "EUR";
            case 4: return "GBP";
            case 5: return "JPY";
            case 6: return "CAD";
            case 7: return "AUD";
            case 8: return "CHF";
            default: return "Unknown";
        }
    }
    
    private static String getLengthSymbol(int unit) {
        switch (unit) {
            case 1: return "mm";
            case 2: return "cm";
            case 3: return "m";
            case 4: return "km";
            case 5: return "in";
            case 6: return "ft";
            case 7: return "yd";
            case 8: return "mi";
            default: return "Unknown";
        }
    }
    
    private static String getWeightSymbol(int unit) {
        switch (unit) {
            case 1: return "mg";
            case 2: return "g";
            case 3: return "kg";
            case 4: return "t";
            case 5: return "oz";
            case 6: return "lb";
            case 7: return "st";
            case 8: return "US ton";
            default: return "Unknown";
        }
    }
    
    private static String getTimeSymbol(int unit) {
        switch (unit) {
            case 1: return "s";
            case 2: return "min";
            case 3: return "h";
            case 4: return "d";
            case 5: return "wk";
            case 6: return "mo";
            case 7: return "yr";
            default: return "Unknown";
        }
    }
    
    private static String getTemperatureSymbol(int unit) {
        switch (unit) {
            case 1: return "°C";
            case 2: return "°F";
            case 3: return "K";
            default: return "Unknown";
        }
    }
} 