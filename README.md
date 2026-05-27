# Universal Conversion Calculator

A comprehensive Java application that performs various types of unit conversions including currency, length, weight, time, and temperature.

## Features

### 1. Currency Conversion
- Supports 8 major currencies:
  - INR (Indian Rupee)
  - USD (US Dollar)
  - EUR (Euro)
  - GBP (British Pound)
  - JPY (Japanese Yen)
  - CAD (Canadian Dollar)
  - AUD (Australian Dollar)
  - CHF (Swiss Franc)

### 2. Length/Height Conversion
- Supports 8 length units:
  - Millimeters (mm)
  - Centimeters (cm)
  - Meters (m)
  - Kilometers (km)
  - Inches (in)
  - Feet (ft)
  - Yards (yd)
  - Miles (mi)

### 3. Weight/Mass Conversion
- Supports 8 weight units:
  - Milligrams (mg)
  - Grams (g)
  - Kilograms (kg)
  - Metric tons (t)
  - Ounces (oz)
  - Pounds (lb)
  - Stones (st)
  - US tons (US ton)

### 4. Time Conversion
- Supports 7 time units:
  - Seconds (s)
  - Minutes (min)
  - Hours (h)
  - Days (d)
  - Weeks (wk)
  - Months (mo) - based on 30 days
  - Years (yr) - based on 365 days

### 5. Temperature Conversion
- Supports 3 temperature scales:
  - Celsius (°C)
  - Fahrenheit (°F)
  - Kelvin (K)

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line interface

### Compilation
1. Open a command prompt/terminal in the project directory
2. Compile both Java files:
   ```bash
   javac ConversionApp.java ConversionManager.java
   ```

### Running the Application
1. After successful compilation, run the application:
   ```bash
   java ConversionApp
   ```

## Usage Instructions

1. **Start the Application**: Run `java ConversionApp` in your terminal
2. **Select Conversion Type**: Choose from the main menu (1-6)
3. **Enter Values**: Follow the prompts to enter:
   - The value you want to convert
   - The source unit/currency (by number)
   - The target unit/currency (by number)
4. **View Results**: The application will display the converted value
5. **Continue or Exit**: Choose to perform more conversions or exit

## Example Usage

```
=== UNIVERSAL CONVERSION CALCULATOR ===
Welcome to the comprehensive conversion tool!

Select conversion type:
=======
# universal-console-measurement-conversion-java-calculator 

A Java console-based application that performs multiple real-world unit conversions through an interactive menu-driven interface.

This project demonstrates core Java programming concepts including object-oriented programming, modular design, input validation, exception handling, switch-case logic, and separation of concerns.

## Features

Supports the following conversion categories:

- Currency Conversion
- Length / Height Conversion
- Weight / Mass Conversion
- Time Conversion
- Temperature Conversion

---

## Supported Units

### Currency
- INR (Indian Rupee)
- USD (US Dollar)
- EUR (Euro)
- GBP (British Pound)
- JPY (Japanese Yen)
- CAD (Canadian Dollar)
- AUD (Australian Dollar)
- CHF (Swiss Franc)

### Length
- Millimeters (mm)
- Centimeters (cm)
- Meters (m)
- Kilometers (km)
- Inches (in)
- Feet (ft)
- Yards (yd)
- Miles (mi)

### Weight
- Milligrams (mg)
- Grams (g)
- Kilograms (kg)
- Metric Tons (t)
- Ounces (oz)
- Pounds (lb)
- Stones (st)
- US Tons

### Time
- Seconds
- Minutes
- Hours
- Days
- Weeks
- Months
- Years

### Temperature
- Celsius
- Fahrenheit
- Kelvin

---

## Project Structure

```bash
src/
 ├── ConversionApp.java
 └── ConversionManager.java
```

### ConversionApp.java
Responsible for:

- Displaying the main menu
- Handling user input
- Calling appropriate conversion methods
- Managing application flow
- Formatting output

### ConversionManager.java
Responsible for:

- Conversion logic implementation
- Unit conversion calculations
- Currency conversion calculations
- Validation checks
- Helper conversion methods

---

## Concepts Demonstrated

This project showcases:

- Java Classes and Objects
- Method Decomposition
- Object-Oriented Programming
- Encapsulation
- Exception Handling
- Input Validation
- Arrays
- Switch Statements
- Console Interaction
- Modular Code Design
- Reusable Helper Methods

---

## How It Works

The application starts with a menu-driven interface.

Example:

```text
=== UNIVERSAL CONVERSION CALCULATOR ===

>>>>>>> 88a28b8107f6ab04e2c92462d3e3f5835085ef32
1. Currency Conversion
2. Length/Height Conversion
3. Weight/Mass Conversion
4. Time Conversion
5. Temperature Conversion
6. Exit
<<<<<<< HEAD

Enter your choice (1-6): 1

=== CURRENCY CONVERSION ===
Available currencies:
1. INR (Indian Rupee)
2. USD (US Dollar)
3. EUR (Euro)
4. GBP (British Pound)
5. JPY (Japanese Yen)
6. CAD (Canadian Dollar)
7. AUD (Australian Dollar)
8. CHF (Swiss Franc)

Enter amount: 100
From currency (1-8): 1
To currency (1-8): 2

Result: 100.00 INR = 1.20 USD
```

## Technical Details

### Architecture
- **ConversionApp.java**: Main application class with user interface
- **ConversionManager.java**: Core conversion logic and calculations

### Conversion Methods
- **Currency**: Uses a conversion matrix with USD as the base currency
- **Length**: Converts to meters as the base unit, then to target unit
- **Weight**: Converts to kilograms as the base unit, then to target unit
- **Time**: Converts to seconds as the base unit, then to target unit
- **Temperature**: Converts to Celsius as the base unit, then to target unit

### Error Handling
- Input validation for all user inputs
- Proper error messages for invalid selections
- Exception handling for number format errors

## Notes

- Currency conversion rates are approximate and may not reflect current market rates
- For real-time currency conversion, consider integrating with a currency API
- The application uses standard conversion factors for all unit conversions
- All calculations are performed with double precision for accuracy

## Future Enhancements

- Integration with real-time currency APIs
- Additional conversion categories (area, volume, speed, etc.)
- GUI interface
- History of conversions
- Batch conversion capabilities
- Export results to file

## License

This project is open source and available under the MIT License. 
=======
```

User selects a conversion category, enters:

- numeric value
- source unit
- target unit

The program:

1. validates input
2. converts source value into a base unit
3. converts base unit into target unit
4. displays formatted output

Example:

```text
Enter weight: 10
From unit: kg
To unit: lb

Result: 10.0000 kg = 22.0462 lb
```

---

## Design Approach

This project follows separation of concerns:

- `ConversionApp` → user interaction layer
- `ConversionManager` → business logic layer

This improves:

- readability
- maintainability
- scalability
- testing potential

---

## Future Improvements

Planned enhancements:

- Live currency exchange API integration
- GUI version using Java Swing / JavaFX
- Database support for conversion history
- Unit testing with JUnit
- Better input validation
- Enum-based unit management
- Maven project structure
- Spring Boot REST API version

---

## How to Run

### Compile

```bash
javac ConversionApp.java ConversionManager.java
```

### Run

```bash
java ConversionApp
```

---

## Sample Skills Highlighted

This project reflects practical understanding of:

- Core Java
- OOP Design
- Problem Solving
- Code Organization
- Exception Management
- Real-world Logic Implementation

---

## Author

Karthik
Aspiring Java Full Stack Developer
>>>>>>> 88a28b8107f6ab04e2c92462d3e3f5835085ef32
