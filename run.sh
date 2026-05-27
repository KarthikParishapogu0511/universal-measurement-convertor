#!/bin/bash
echo "Compiling Java files..."
javac ConversionApp.java ConversionManager.java
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Starting the Conversion Calculator..."
    echo
    java ConversionApp
else
    echo "Compilation failed! Please check your Java installation."
    read -p "Press Enter to continue..."
fi 