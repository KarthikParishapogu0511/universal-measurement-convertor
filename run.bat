@echo off
echo Compiling Java files...
javac ConversionApp.java ConversionManager.java
if %errorlevel% equ 0 (
    echo Compilation successful!
    echo Starting the Conversion Calculator...
    echo.
    java ConversionApp
) else (
    echo Compilation failed! Please check your Java installation.
    pause
) 