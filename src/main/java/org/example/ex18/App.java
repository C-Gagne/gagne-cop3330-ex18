/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Crystal Gagne
 */

package org.example.ex18;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App mainApp = new App();

        String conversionType = mainApp.getConversionType();

        double x = mainApp.getTemperatures(conversionType);
        double y = mainApp.calculateConversion(x, conversionType);

        String outputString = genOutputString(conversionType, y);
        System.out.println(outputString);

    }

    public String getConversionType()
    {
        System.out.println("If you want to convert from C to F, please enter C.\nIf you want to convert from F to C, please enter F.");
        String strConversionType = in.nextLine();
        if (strConversionType.equalsIgnoreCase("F") || strConversionType.equalsIgnoreCase("C"))
        {
            System.out.println("Your choice " +strConversionType);
            return strConversionType;
        }
        else {
            System.out.println("Please enter 0 or 1.");
            return getConversionType();
        }
    }

    public Double getTemperatures(String conversionType)
    {
        System.out.println("Please enter the temperature in " +conversionType);
        return in.nextDouble();
    }

    public Double calculateConversion(double x, String conversionType)
    {
        double conversion = 0.0;
        if (conversionType.equalsIgnoreCase("F"))
        {
            // C = (F − 32) × 5 / 9
            conversion = (x - 32) * (5.0 / 9.0);
        }
        else if (conversionType.equalsIgnoreCase("C"))
        {
            // F = (C × 9 / 5) + 32
            conversion = (x * 9.0 / 5.0) + 32;
        }
        return conversion;
    }

    public static String genOutputString(String conversionType, double y)
    {
        if (conversionType.equalsIgnoreCase("F"))
        {
            return String.format("The temperature in Celsius is %.2f", y);
        }
        else
        {
            return String.format("The temperature in Fahrenheit is %.2f", y);
        }
    }
}
